/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.api;

import heps.db.param_list.entity.Manager;
import heps.db.param_list.entity.Parameter;
import heps.db.param_list.entity.System;
import heps.db.param_list.entity.Team;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

/**
 *
 * @author C.M.P
 */
public class ParameterAPI {
    @PersistenceUnit
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("heps-db-param_listPU");
    static final EntityManager em = emf.createEntityManager();

    @PersistenceContext      

    /**
     * @param paramName
     * @return
     */
    public String getParameterValue(String paramName) {
        String val = null;
        
        return val;
    }
    
    /**
     * 
     * @param sys
     * @return
     */
    public List<Parameter> getAllParametersForSystem(System sys) {
            List<Parameter> pList = null;
            
            return pList;
    }
    
    /**
     * 
     * @param team
     * @return 
     */
    public List<Parameter> getAllParametersForTeam(Team team) {
            List<Parameter> pList = null;
            
            return pList;
    }
    
    /**
     * 
     * @param manager
     * @return 
     */
    public List<Parameter> getAllParametersForManager(Manager manager) {
            List<Parameter> pList = null;
            
            return pList;
    }
    
    /**
     * 
     * @param paramName
     * @return 
     */
    public Parameter getParameterByName(String paramName){
        Parameter param = null;
        
        return param;
    }
    
    /**
     * 
     * @param keyword
     * @return 
     */
    public List<Parameter> getParametersForKeyword(String keyword) {
        List<Parameter> pList = null;
        
        return pList;
    }
    
    /**
     * 
     * @param p 
     */
    public void setParameter(Parameter p) {
        
    }
    
    /**
     * 
     * @param manager
     * @param params 
     */
    public void setParametersForManager(String manager, List<Parameter> params) {
        
    }

    /**
     * 
     * @param system
     * @param params 
     */
    public void setAllParametersForSystem(String system, List<Parameter> params) {
        
    }
    
    /**
     * 
     * @param team
     * @param params 
     */
    public void setAllParametersForTeam(String team, List<Parameter> params) {
        
    }
    
    /**
     * 
     * @param paramName 
     */
    public void setParameterByName(String paramName) {
        
    }
}
