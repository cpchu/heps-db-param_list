/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.exl2db;

import heps.db.param_list.api.DataAPI;
import heps.db.param_list.api.ParameterAPI;
import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author C.M.P
 */
public class Param2DB {
    public static void instDB(Workbook wb, String sheetName, String created_by, Date create_date) {
        ReadSheet readSheet = new ReadSheet();
        ArrayList paramList = readSheet.getParamList(wb, sheetName);
        ArrayList dbLabels = readSheet.getRowLabels();
        System.out.println(dbLabels);
        for (int i = 0; i < paramList.size(); i++) {
            ParameterAPI p = (ParameterAPI) paramList.get(i);
//            ArrayList paramMap = (ArrayList) paramList.get(i);
            
            System.out.println(p);
            // First check if the parameter already exists in the DB. 
            // If it does exist, only create a new data for the existing parameter.
            // If not, create a new parameter 
            DataAPI dapi = new DataAPI();
            if (!dapi.getDataFor(p.getSystem(), p.getTeam(), p.getParameterName(), p.getAttribute()).isEmpty()) {
                
            } else {
                
            }
            
        }

    }

}
