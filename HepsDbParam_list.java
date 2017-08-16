/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list;

import heps.db.param_list.db2exl.WriteExl;
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
public class HepsDbParam_list {

    public static void exl2DB(String filePath) throws ParseException {
        ReadExl r = new ReadExl();
        Workbook wb = ReadExl.getWorkbook(filePath);
        Param2DB param2DB = new Param2DB();

        String file_type = filePath.substring(filePath.lastIndexOf(".") + 1);
        System.out.println("文件类型："+ file_type);
        if ((!"xls".equals(file_type)) && (!"xlsx".equals(file_type))) {
            System.out.println("Warning:Please insert the spreadsheet of .xls format");
        } else {
            System.out.println("文件类型复合");
            SummaryInformation si = r.getSummaryInformation(filePath);
            String created_by = si.getAuthor();
            Date create_date = si.getLastSaveDateTime();

            param2DB.instDB(wb, "Accelerator", created_by, create_date);

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException, IOException {
       // check if Excel row is null or all cell are blank and null 
       Workbook wb = ReadExl.getWorkbook("C:\\work\\heps_data\\parameter_20170131_modifyByZhaozhuo.xls");
       ReadExl.checkBlankData(wb, "Accelerator");
        // TODO code application logic here
       HepsDbParam_list.exl2DB("C:\\work\\heps_data\\parameter_20170131_modifyByZhaozhuo.xls");
       
       //WriteExl writeExl = new WriteExl();
       //writeExl.writeExl("d:\\workbook.xls", "Accelerator");
    }

}
