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
import heps.db.param_list.entity.Data;

/**
 *
 * @author Administrator
 */
public class DataJpaController {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebApplication2PU");
    EntityManager em =  emf.createEntityManager();
    
    public List<Data> findDataEntities() {
       
        try {
           
            return em.createQuery("select d from Data d join d.parameter p join d.team t join d.system s join d.attribute a order by s").getResultList();
                  
        } finally {
            em.close();
            
        }
    }
    public List<Data> findDataBySystem(String name) {
       
        try {
           
            return em.createQuery("select d from Data d join d.parameter p join d.team t join d.system s join d.attribute a WHERE d.system.name = :name").setParameter("name", name).getResultList();
                  
        } finally {
            em.close();
            
        }
    }
    public List<Data> findDataByTeam(String name) {
       
        try {
           
            return em.createQuery("select d from Data d join d.parameter p join d.team t join d.system s join d.attribute a WHERE d.team.name = :name").setParameter("name", name).getResultList();
                  
        } finally {
            em.close();
            
        }
    }
}
