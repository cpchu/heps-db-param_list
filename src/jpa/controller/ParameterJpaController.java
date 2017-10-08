/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import heps.db.param_list.entity.Parameter;

/**
 *
 * @author Administrator
 */
public class ParameterJpaController {
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "WebApplication2PU")
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public List<Parameter> findParameterEntities() {
        EntityManager em = getEntityManager();
        try {
            //return em.createQuery("SELECT p FROM Parameter p").getResultList();
            return em.createQuery("select p from Parameter p join p.unit u join p.reference r").getResultList();
                        
        } finally {
            em.close();
        }
    }
}
