/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list;


import heps.db.param_list.exl2db.Param2DB;
import heps.db.param_list.exl2db.ReadExl;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author C.M.P
 */
public class HepsDbParam_list1 {

    public static String exl2DB(String filePath) throws ParseException {
        ReadExl r = new ReadExl();
        Workbook wb = ReadExl.getWorkbook(filePath);
        Param2DB param2DB = new Param2DB();
        String param2DBResult = "";
                
        String file_type = filePath.substring(filePath.lastIndexOf(".") + 1);
        System.out.println("文件类型："+ file_type);
        String checkFileTypeResult="";
        if ((!"xls".equals(file_type)) && (!"xlsx".equals(file_type))) {
            System.out.println("Warning:Please insert the spreadsheet of .xls format");
        } else {
            checkFileTypeResult = "文件类型复合";
            System.out.println(checkFileTypeResult);
            SummaryInformation si = r.getSummaryInformation(filePath);
            String created_by = si.getAuthor();
            Date create_date = si.getLastSaveDateTime();

            param2DBResult = Param2DB.instDB(wb, file_type, created_by, create_date);
            param2DBResult = Param2DB.instDB(wb, "Accelerator", created_by, create_date);
                       

        }
        return checkFileTypeResult+","+param2DBResult;
        
    }


}
