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
        ArrayList paramList = ReadSheet.getParamList(wb, sheetName);
        ArrayList dbLabel = ReadSheet.getRowLabels();
        for (int i = 0; i < paramList.size(); i++) {
            Parameter p = null;
            ArrayList paramMap = (ArrayList) paramList.get(i);
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
