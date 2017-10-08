/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import java.util.List;
import javax.faces.context.FacesContext;
import jpa.controller.ParameterJpaController;
import heps.db.param_list.entity.Parameter;

/**
 *
 * @author Administrator
 */
public class ParameterController {
    
     public ParameterController() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        jpaController = (ParameterJpaController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "parameterJpa");
        
    }
    private List<Parameter> parameterItems = null;
    private ParameterJpaController jpaController = null;
    
    public String listSetup() {
        
        return "parameter_list";
    }
    
    public List<Parameter> getParameterItems() {
        if (parameterItems == null) {
            
           // productCodeItems = jpaController.findProductCodeEntities(pagingInfo.getBatchSize(), pagingInfo.getFirstItem());
            parameterItems = jpaController.findParameterEntities();
        }
        return parameterItems;
    }
}
