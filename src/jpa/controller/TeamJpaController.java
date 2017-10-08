/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import heps.db.param_list.entity.Team;

/**
 *
 * @author Administrator
 */
public class TeamJpaController {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication2PU");
    EntityManager em =emf.createEntityManager();
    public List<Team> findTeamEntities(){
        try {
            return em.createQuery("select t from Team t").getResultList();
        } finally {
            em.close();
        }
        
    } 
}
