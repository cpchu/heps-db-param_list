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
import java.util.Date;
import java.util.List;

/**
 *
 * @author C.M.P
 */
public class ParameterAPI {
    
    private String sys = null;
    private String team = null;
    private String team_manager = null;
    private String parent_team = null;
    private String parent_sys = null;            
    private String param_name = null;
    private String att = null;
    private String unit = null;
    private String data = null;
    private Date date = null;
    private String def = null;
    private String ref_title = null;
    private String ref_author = null;
    private String ref_publication = null;
    private String ref_url = null;
    private String keyword = null;
    

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
     * @param paramName
     * @return 
     */
    public Parameter getParameter(String paramName) {
        Parameter param = null;
        
        return param;
    }
    
    /**
     * 
     * @param paramName
     * @return 
     */
    public List<Parameter> getParameterForAllDates(String paramName) {
            List<Parameter> pList = null;
            
            return pList;        
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

    
    
    public String getSys() {
        return sys;
    }

    public void setSys(String sys) {
        this.sys = sys;
    }

    public String getTeam_manager() {
        return team_manager;
    }

    public void setTeam_manager(String team_manager) {
        this.team_manager = team_manager;
    }

    public String getParent_team() {
        return parent_team;
    }

    public void setParent_team(String parent_team) {
        this.parent_team = parent_team;
    }

    public String getParent_sys() {
        return parent_sys;
    }

    public void setParent_sys(String parent_sys) {
        this.parent_sys = parent_sys;
    }

    public String getParam_name() {
        return param_name;
    }

    public void setParam_name(String param_name) {
        this.param_name = param_name;
    }

    public String getAtt() {
        return att;
    }

    public void setAtt(String att) {
        this.att = att;
    }

    public String getDef() {
        return def;
    }

    public void setDef(String def) {
        this.def = def;
    }

    public String getRef_title() {
        return ref_title;
    }

    public void setRef_title(String ref_title) {
        this.ref_title = ref_title;
    }

    public String getRef_author() {
        return ref_author;
    }

    public void setRef_author(String ref_author) {
        this.ref_author = ref_author;
    }

    public String getRef_publication() {
        return ref_publication;
    }

    public void setRef_publication(String ref_publication) {
        this.ref_publication = ref_publication;
    }

    public String getRef_url() {
        return ref_url;
    }

    /**
     *
     * @return 
     */
    public void setRef_url(String ref_url) {
        this.ref_url = ref_url;
    }

    public String getAttribute() {
        return att;
    }
    
    /**
     * 
     * @param att 
     */
    public void setAttribute(String att) {
        this.att = att;
    }
    
    /**
     * 
     * @return 
     */
    public String getData() {
        return data;
    }
    
    /**
     * 
     * @param data 
     */
    public void setData(String data) {
        this.data = data;
    }
    
    /**
     * 
     * @return 
     */
    public Date getDate() {
        return date;
    }
    
    /**
     * 
     * @param date 
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
    /**
     * 
     * @return 
     */
    public String getDefinition() {
        return def;
    }
    
    /**
     * 
     * @param def 
     */
    public void setDefinition(String def) {
        this.def = def;
    }
    
    /**
     * 
     * @return 
     */
    public String getKeyword() {
        return keyword;
    }
    
    /**
     * 
     * @param keyword 
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    /**
     * 
     * @return 
     */
    public String getParameterName() {
        return param_name;
    }
    
    /**
     * 
     * @param param_name 
     */
    public void setParameterName(String param_name) {
        this.param_name = param_name;
    }
    
    /**
     * 
     * @return 
     */
    public String getReferenceAuthor() {
        return ref_author;
    }
    
    /**
     * 
     * @param ref_author 
     */
    public void setReferenceAuthor(String ref_author) {
        this.ref_author = ref_author;
    }
    
    /**
     * 
     * @return 
     */
    public String getReferencePublication() {
        return ref_publication;
    }
    
    /**
     * 
     * @param ref_publication 
     */
    public void setReferencePublication(String ref_publication) {
        this.ref_publication = ref_publication;
    }
    
    /**
     * 
     * @return 
     */
    public String getReferenceTitle() {
        return ref_title;
    }
    
    /**
     * 
     * @param ref_title 
     */
    public void setReferenceTitle(String ref_title) {
        this.ref_title = ref_title;
    }
    
    /**
     * 
     * @return 
     */
    public String getReferenceURL() {
        return ref_url;
    }
    
    /**
     * 
     * @param ref_url 
     */
    public void setReferenceURL(String ref_url) {
        this.ref_url = ref_url;
    }   
    
    /**
     * 
     * @return 
     */
    public String getSystem() {
        return sys;
    }
    
    /**
     * 
     * @param sys 
     */
    public void setSystem(String sys) {
        this.sys = sys;
    }
    
    /**
     * 
     * @return 
     */
    public String getTeam() {
        return team;
    }
    
    /**
     * 
     * @param team 
     */
    public void setTeam(String team) {
        this.team = team;
    }
    
    /**
     * 
     * @return 
     */
    public String getTeamManager() {
        return team_manager;
    }
    
    /**
     * 
     * @param team_manager 
     */
    public void setTeamManager(String team_manager) {
        this.team_manager = team_manager;
    }
    
    /**
     * 
     * @return 
     */
    public String getUnit() {
        return unit;
    }
    
    /**
     * 
     * @param unit 
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "ParameterAPI{" + "sys=" + sys + ", team=" + team + ", team_manager=" + team_manager + ", parent_team=" + parent_team + ", parent_sys=" + parent_sys + ", param_name=" + param_name + ", att=" + att + ", unit=" + unit + ", data=" + data + ", date=" + date + ", def=" + def + ", ref_title=" + ref_title + ", ref_author=" + ref_author + ", ref_publication=" + ref_publication + ", ref_url=" + ref_url + ", keyword=" + keyword + '}';
    }
    
    
}
