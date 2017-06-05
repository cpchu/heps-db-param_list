/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.exl2db;

import heps.db.param_list.api.ParameterAPI;
import heps.db.param_list.entity.Parameter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
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
            
            
//            ArrayList rowClsList = (ArrayList) encapDataList.get(i);
//            Parameter beamParameter = new ParameterAPI().setBeamParameter(e, model, particleType, 0);
//            Iterator it = rowClsList.iterator();
//            while (it.hasNext()) {
//                BeamCell cellProp = (BeamCell) it.next();
//                if ("beam_parameter_prop".equals(cellProp.getTableName())) {
//                    new BeamParameterPropAPI().setBeamParameterProp(beamParameter, cellProp.getCategory(), cellProp.getName(), cellProp.getDatatype(), cellProp.getValue(), null);
//                }
//            }
        }

    }

}
