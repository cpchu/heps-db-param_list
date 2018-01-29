/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.jsf.ejb;

import heps.db.param_list.entity.Data;
import heps.db.param_list.jsf.entity.DataDisp;
import heps.db.param_list.tools.ConstantClassField;
import java.text.SimpleDateFormat;
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
import heps.db.param_list.ejb.DataFacade;

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

    public List<DataDisp> getDataDispList() {
        Query q;
        q = em.createNamedQuery("Data.findAll");
        List dataList = q.getResultList();
        List<DataDisp> dispList = new ArrayList();
       // System.out.println("++++"+dataList.size());
        if (dataList.isEmpty() || dataList == null) {
            return null;
        } else {
            Iterator<Data> it = dataList.iterator();
            while (it.hasNext()) {
                Object object=it.next();
               // System.out.println("*********"+object);
                Data data = new DataFacade().setData(object);  
              //  System.out.println("---------"+data.getClass().getName());
                DataDisp dp = new DataDisp();              
                if (data.getSystemid() != null) {
                    dp.setSystem(data.getSystemid().getName());
                }
                if (data.getSubsystemid() != null) {
                    dp.setSubsystem(data.getSubsystemid().getName());
                }
                if (data.getDevicetypeId() != null) {
                    dp.setDevice(data.getDevicetypeId().getName());
                }
                if (data.getParameterid() != null) {
                    dp.setParameterName(data.getParameterid().getName());
                    dp.setDefinition(data.getParameterid().getDefinition());
                    if (data.getParameterid().getUnitid() != null) {
                        dp.setUnit(data.getParameterid().getUnitid().getName());
                    }
                    if (data.getParameterid().getReferenceid() != null) {
                        dp.setReferenceTitle(data.getParameterid().getReferenceid().getTitle());
                        dp.setReferenceAuthor(data.getParameterid().getReferenceid().getAuthor());
                        dp.setReferencePublication(data.getParameterid().getReferenceid().getPublication());
                        dp.setReferenceURL(data.getParameterid().getReferenceid().getUrl());
                        dp.setKeyword(data.getParameterid().getReferenceid().getKeywords());
                    }
                }
                if (data.getAttributeid() != null) {
                    dp.setAttibute(data.getAttributeid().getName());
                }
                
                if(data.getDatemodified()!=null){
                    dp.setChangeDate(data.getDatemodified());
                }

                dp.setValue(data.getValue());
              
                dp.setId(data.getId().longValue());                           
                dispList.add(dp);
            }
            return dispList;
        }
    }

}
