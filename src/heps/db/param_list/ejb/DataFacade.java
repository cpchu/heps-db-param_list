/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.ejb;

import heps.db.param_list.entity.Data;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
/**
 *
 * @author Lvhuihui
 */
@Stateless
public class DataFacade{

    @PersistenceUnit
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("param_listPU");
    static EntityManager em = emf.createEntityManager();

    @PersistenceContext

    public List<Data> getDataList(){
        Query q;     
        q=em.createNamedQuery("Data.findAll");
        List<Data> dataList= q.getResultList(); 
        System.out.println("----------"+dataList);
        return dataList;  
    }
    
}
