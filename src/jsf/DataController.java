/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import java.util.List;
import javax.faces.context.FacesContext;
import jpa.controller.DataJpaController;
import heps.db.param_list.entity.Data;

/**
 *
 * @author Administrator
 */
public class DataController {
    public DataController() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        jpaController = (DataJpaController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "dataJpa");
        
    }
    private List<Data> dataItems = null;
    private DataJpaController jpaController = null;
    
    public String listSetup() {
        
        return "data_list";
    }
    
    public List<Data> getDataItems() {
        if (dataItems == null) {
            
            dataItems = jpaController.findDataEntities();
        }
        return dataItems;
    }
}
