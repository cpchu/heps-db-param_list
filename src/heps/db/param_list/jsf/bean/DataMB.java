/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.jsf.bean;

import heps.db.param_list.entity.Data;
import heps.db.param_list.ejb.DataFacade;
import heps.db.param_list.jsf.ejb.DataDispFacade;
import heps.db.param_list.jsf.entity.DataDisp;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Lvhuihui
 */
@ManagedBean
@SessionScoped
public class DataMB implements Serializable {

  //  @EJB
  //  private heps.db.param_list.session.DataFacade ejbFacade;
    private DataDispFacade ejbFacade=new DataDispFacade();
    private List<DataDisp> dataDispList=null;
    public DataMB() {       
    }
    public List<DataDisp> getDataDispList(){
     dataDispList=ejbFacade.getDataDispList();
      return dataDispList;
    }
}
