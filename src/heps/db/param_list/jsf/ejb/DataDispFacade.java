/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.jsf.ejb;

import heps.db.param_list.entity.Data;
import heps.db.param_list.jsf.entity.DataDisp;
import java.util.ArrayList;
import java.util.Iterator;
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
public class DataDispFacade {

    @PersistenceUnit
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("param_listPU");
    static EntityManager em = emf.createEntityManager();

    @PersistenceContext

    public List<DataDisp> getDataDispList(){
       Query q;
       q=em.createNamedQuery("Data.findAll");
       List<Data> dataList=q.getResultList();
       if(dataList.isEmpty()) return null;
       else{
          List<DataDisp> dispList=new ArrayList();
          Iterator it=dataList.iterator();
          while(it.hasNext()){
             Data data=(Data) it.next();
             DataDisp dp=new DataDisp();
             dp.setSystem(data.getSystemid().getName());
             dp.setSubsystem(data.getSubsystemid().getName());
             dp.setDevice(data.getDeviceId().getName());
             dp.setParameterName(data.getParameterid().getName());
             dp.setAttibute(data.getAttributeid().getName());
             dp.setUnit(data.getParameterid().getUnitid().getName());
             dp.setValue(data.getValue());
             dp.setChangeDate(data.getDatemodified());
             dp.setDefinition(data.getParameterid().getDefinition());
             dp.setReferenceTitle(data.getParameterid().getReferenceid().getTitle());
             dp.setReferenceAuthor(data.getParameterid().getReferenceid().getAuthor());
             dp.setReferencePublication(data.getParameterid().getReferenceid().getPublication());
             dp.setReferenceURL(data.getParameterid().getReferenceid().getUrl());
             dp.setKeyword(data.getParameterid().getReferenceid().getKeywords());
             dispList.add(dp);
          }       
           return dispList;
       }
      
    }
    
}
