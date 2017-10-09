/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list;

import heps.db.param_list.entity.Parameter;
import heps.db.param_list.exl2db.Param2DB;
import heps.db.param_list.exl2db.ReadExl;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author C.M.P
 */
public class HepsDbParam_list {

    public static void exl2DB(String filePath) {
        ReadExl r = new ReadExl();
        Workbook wb = ReadExl.getWorkbook(filePath);

        String file_type = filePath.substring(filePath.lastIndexOf(".") + 1);
        if (!"xls".equals(file_type)) {
            System.out.println("Warning:Please insert the spreadsheet of .xls format");
        } else {
            SummaryInformation si = r.getSummaryInformation(filePath);
            String created_by = si.getAuthor();
            Date create_date = si.getLastSaveDateTime();

            try {
                Param2DB.instDB(wb, "Accelerator", created_by, create_date);
            } catch (ParseException ex) {
                Logger.getLogger(HepsDbParam_list.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HepsDbParam_list.exl2DB("C:\\work\\heps_data\\parameter_20170131a.xls");
    }

}
