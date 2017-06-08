-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema parameter_list
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema parameter_list
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `parameter_list` DEFAULT CHARACTER SET utf8 ;
USE `parameter_list` ;

-- -----------------------------------------------------
-- Table `parameter_list`.`attribute`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `parameter_list`.`attribute` (
  `Id` INT(11) NOT NULL,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `parameter_list`.`reference`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `parameter_list`.`reference` (
  `Id` INT(11) NOT NULL,
  `Title` VARCHAR(45) NULL DEFAULT NULL,
  `Author` VARCHAR(45) NULL DEFAULT NULL,
  `Publication` VARCHAR(45) NULL DEFAULT NULL,
  `URL` VARCHAR(45) NULL DEFAULT NULL,
  `Keywords` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `parameter_list`.`unit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `parameter_list`.`unit` (
  `Id` INT(11) NOT NULL,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `parameter_list`.`parameter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `parameter_list`.`parameter` (
  `Id` INT(11) NOT NULL,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  `Unit_id` INT(11) NULL DEFAULT NULL,
  `Definition` VARCHAR(45) NULL DEFAULT NULL,
  `Reference_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_unit_id_idx` (`Unit_id` ASC),
  INDEX `fk_reference_id_idx` (`Reference_id` ASC),
  CONSTRAINT `fk_reference_id`
    FOREIGN KEY (`Reference_id`)
    REFERENCES `parameter_list`.`reference` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_unit_id`
    FOREIGN KEY (`Unit_id`)
    REFERENCES `parameter_list`.`unit` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `parameter_list`.`system`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `parameter_list`.`system` (
  `Id` INT(11) NOT NULL,
  `Parent_id` INT(11) NULL DEFAULT NULL,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_parent_id_idx` (`Parent_id` ASC),
  CONSTRAINT `fk_parent_id1`
    FOREIGN KEY (`Parent_id`)
    REFERENCES `parameter_list`.`system` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `parameter_list`.`manager`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `parameter_list`.`manager` (
  `Id` INT(11) NOT NULL,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `parameter_list`.`team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `parameter_list`.`team` (
  `Id` INT(11) NOT NULL,
  `Parent_id` INT(11) NULL DEFAULT NULL,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  `Manager_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`Id`),
  INDEX `manager_id_idx` (`Manager_id` ASC),
  INDEX `fk_Team_Team1_idx` (`Parent_id` ASC),
  CONSTRAINT `fk_manager_id`
    FOREIGN KEY (`Manager_id`)
    REFERENCES `parameter_list`.`manager` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parent_id`
    FOREIGN KEY (`Parent_id`)
    REFERENCES `parameter_list`.`team` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `parameter_list`.`data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `parameter_list`.`data` (
  `data_id` INT NOT NULL,
  `Team_id` INT(11) NOT NULL DEFAULT '0',
  `System_id` INT(11) NOT NULL DEFAULT '0',
  `Attribute_id` INT(11) NOT NULL DEFAULT '0',
  `Parameter_id` INT(11) NOT NULL,
  `Value` VARCHAR(45) NULL DEFAULT NULL,
  `Status` VARCHAR(45) NULL DEFAULT NULL,
  `Date_modified` DATE NULL DEFAULT NULL,
  `Comment` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Team_id`, `System_id`, `Attribute_id`, `Parameter_id`, `data_id`),
  INDEX `fk_system_id_idx` (`System_id` ASC),
  INDEX `fk_attribute_id_idx` (`Attribute_id` ASC),
  INDEX `fk_parameter_id_idx` (`Parameter_id` ASC),
  INDEX `fk_team_id` (`Team_id` ASC),
  CONSTRAINT `fk_attribute_id`
    FOREIGN KEY (`Attribute_id`)
    REFERENCES `parameter_list`.`attribute` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_parameter_id`
    FOREIGN KEY (`Parameter_id`)
    REFERENCES `parameter_list`.`parameter` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_system_id`
    FOREIGN KEY (`System_id`)
    REFERENCES `parameter_list`.`system` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_team_id`
    FOREIGN KEY (`Team_id`)
    REFERENCES `parameter_list`.`team` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
