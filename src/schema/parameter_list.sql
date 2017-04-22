-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Parameter_List
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Parameter_List
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Parameter_List` DEFAULT CHARACTER SET utf8 ;
USE `Parameter_List` ;

-- -----------------------------------------------------
-- Table `Parameter_List`.`Manager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Parameter_List`.`Manager` (
  `Id` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Parameter_List`.`Unit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Parameter_List`.`Unit` (
  `Id` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Parameter_List`.`Reference`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Parameter_List`.`Reference` (
  `Id` INT NOT NULL,
  `Title` VARCHAR(45) NULL,
  `Author` VARCHAR(45) NULL,
  `Publication` VARCHAR(45) NULL,
  `URL` VARCHAR(45) NULL,
  `Keywords` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Parameter_List`.`Team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Parameter_List`.`Team` (
  `Id` INT NOT NULL,
  `Parent_id` INT NULL,
  `Name` VARCHAR(45) NULL,
  `Manager_id` INT NULL,
  PRIMARY KEY (`Id`),
  INDEX `manager_id_idx` (`Manager_id` ASC),
  INDEX `fk_Team_Team1_idx` (`Parent_id` ASC),
  CONSTRAINT `fk_manager_id`
    FOREIGN KEY (`Manager_id`)
    REFERENCES `Parameter_List`.`Manager` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parent_id`
    FOREIGN KEY (`Parent_id`)
    REFERENCES `Parameter_List`.`Team` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Parameter_List`.`System`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Parameter_List`.`System` (
  `Id` INT NOT NULL,
  `Parent_id` INT NULL,
  `Name` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_parent_id_idx` (`Parent_id` ASC),
  CONSTRAINT `fk_parent_id1`
    FOREIGN KEY (`Parent_id`)
    REFERENCES `Parameter_List`.`System` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Parameter_List`.`Attribute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Parameter_List`.`Attribute` (
  `Id` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Parameter_List`.`Parameter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Parameter_List`.`Parameter` (
  `Id` INT NOT NULL,
  `Name` VARCHAR(45) NULL,
  `Unit_id` INT NULL,
  `Definition` VARCHAR(45) NULL,
  `Reference_id` INT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_unit_id_idx` (`Unit_id` ASC),
  INDEX `fk_reference_id_idx` (`Reference_id` ASC),
  CONSTRAINT `fk_unit_id`
    FOREIGN KEY (`Unit_id`)
    REFERENCES `Parameter_List`.`Unit` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reference_id`
    FOREIGN KEY (`Reference_id`)
    REFERENCES `Parameter_List`.`Reference` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Parameter_List`.`Data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Parameter_List`.`Data` (
  `Team_id` INT NULL,
  `System_id` INT NULL,
  `Attribute_id` INT NULL,
  `Parameter_id` INT NOT NULL,
  `Value` VARCHAR(45) NULL,
  `Status` VARCHAR(45) NULL,
  `Date_modified` DATE NULL,
  `Comment` VARCHAR(45) NULL,
  PRIMARY KEY (`Parameter_id`, `Team_id`, `System_id`, `Attribute_id`),
  INDEX `fk_system_id_idx` (`System_id` ASC),
  INDEX `fk_attribute_id_idx` (`Attribute_id` ASC),
  INDEX `fk_parameter_id_idx` (`Parameter_id` ASC),
  CONSTRAINT `fk_team_id`
    FOREIGN KEY (`Team_id`)
    REFERENCES `Parameter_List`.`Team` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_system_id`
    FOREIGN KEY (`System_id`)
    REFERENCES `Parameter_List`.`System` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_attribute_id`
    FOREIGN KEY (`Attribute_id`)
    REFERENCES `Parameter_List`.`Attribute` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parameter_id`
    FOREIGN KEY (`Parameter_id`)
    REFERENCES `Parameter_List`.`Parameter` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
