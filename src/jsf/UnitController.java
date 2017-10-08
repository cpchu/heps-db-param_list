/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf;

import jpa.controller.UnitJpaController;
import heps.db.param_list.entity.Unit;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class UnitController {
   
   
     public UnitController() {
        //FacesContext facesContext = FacesContext.getCurrentInstance();
        //jpaController = (UnitJpaController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "unitJpa");
        
    }
    private List<Unit> unitItems = null;
    private UnitJpaController jpaController = new UnitJpaController();
    
    public String listSetup() {
        
        return "unit_list";
    }
    
    public List<Unit> getUnitItems() {
        if (unitItems == null) {
            
           // productCodeItems = jpaController.findProductCodeEntities(pagingInfo.getBatchSize(), pagingInfo.getFirstItem());
            unitItems = jpaController.findUnitEntities();
        }
        return unitItems;
    }
}
