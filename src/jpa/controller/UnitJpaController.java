/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controller;

import heps.db.param_list.entity.Unit;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author Administrator
 */
public class UnitJpaController {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication2PU");
    EntityManager em = emf.createEntityManager();
    public List<Unit> findUnitEntities() {
        
        try {
            return em.createQuery("select u from Unit u").getResultList();
        } finally {
            em.close();
            
        }
    }
}
