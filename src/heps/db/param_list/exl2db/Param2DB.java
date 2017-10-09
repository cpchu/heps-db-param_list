/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.exl2db;

import heps.db.param_list.api.DataAPI;
import heps.db.param_list.api.ParameterAPI;
import heps.db.param_list.entity.Data;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author C.M.P
 */
public class Param2DB {

    public static String instDB(Workbook wb, String sheetName, String created_by, Date create_date) throws ParseException {
        ReadSheet readSheet = new ReadSheet();
        ArrayList paramList = readSheet.getParamList(wb, sheetName);
        String param2DBResult = "";
        String paramAllName="";
String paramAllNameNow="";
        for (int i = 0; i < paramList.size(); i++) {
            ParameterAPI p = (ParameterAPI) paramList.get(i);
            paramAllNameNow=p.getParameterName();
            paramAllName=paramAllNameNow+"-----正在更新！！\n"+paramAllName;
//            ArrayList paramMap = (ArrayList) paramList.get(i);

            // System.out.println(p);
            // First check if the parameter already exists in the DB. 
            // If it does exist, only create a new data for the existing parameter.
            // If not, create a new parameter 
            DataAPI dapi = new DataAPI();
            Data data = dapi.getDataFor(p.getSystem(), p.getTeam(), p.getParameterName(), p.getAttribute());
            
            if (data != null) {
                dapi.updateData(data, p);
                param2DBResult = "参数更新成功！";
            } else {
                dapi.saveNewParameter(p);
                param2DBResult = "参数保存成功！";
            }

        }

        return "以下参数正在更新:\n"+paramAllName+"!!!\n"+param2DBResult;
    }

}
