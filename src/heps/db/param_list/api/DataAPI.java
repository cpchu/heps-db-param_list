/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.api;

import heps.db.param_list.entity.Data;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author Paul
 */
public class DataAPI {
    @PersistenceUnit
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("heps-db-param_listPU");
    static final EntityManager em = emf.createEntityManager();

    @PersistenceContext  
    
    public List<Data> getDataFor(String sys, String team, String param_name, String attribute) {
        Query q;
        ArrayList<Data> dataList = new ArrayList<>();
        q = em.createQuery("SELECT d FROM Data d WHERE d.system=:system_id AND d.team=:team_id AND d.parameter:=parameter_id AND d.attribute:=attribute_id ")
                .setParameter("system_id", sys)
                .setParameter("team_id", team)
                .setParameter("parameter_id", param_name)
                .setParameter("attribute_id", attribute);
        dataList = (ArrayList) q.getResultList();
        
        return dataList;
    }
    
    public void setData() {
        
    }
}
