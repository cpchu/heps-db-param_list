/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.exl2db;

import heps.db.param_list.api.ParameterAPI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author lv
 * @author chu
 */
public class ReadSheet {
   
    static ArrayList rowLabels = new ArrayList();
    HashMap<String, ParameterAPI> paramList = new HashMap<String, ParameterAPI>();
    
    public static ArrayList getParamList(Workbook wb, String sheetName) {
        if (wb == null) {
            System.out.println("Error!");
        } else {
            Sheet sheet = wb.getSheet(sheetName);            
            ArrayList dataList = new ArrayList();
            for (Iterator<Row> rit = sheet.rowIterator(); rit.hasNext();) {
                Row row = (Row) rit.next();
                ArrayList oneRow = new ArrayList();
                boolean labelRow = false;
                for (Cell cell : row) {
                    Object o = "";
                    String label = null;
                    switch (cell.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            o = cell.getStringCellValue();
                            if (o.equals("System")||o.equals("系统")) {
                                labelRow = true;
                                if (o.equals("System")) {
                                    label = (String) o;
                                }
                            }
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            o = cell.getNumericCellValue();
                            break;
                        case Cell.CELL_TYPE_BOOLEAN:
                            o = cell.getBooleanCellValue();
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            o = cell.getCellFormula();
                            break;
                        case Cell.CELL_TYPE_BLANK:
                            o = "";
                            break;
                        case Cell.CELL_TYPE_ERROR:
                            System.out.println("Error");
                            break;
                    }               
                    oneRow.add(o);
                    if (labelRow) {
                        rowLabels.add(label);
                    }
                }
                if(!labelRow) {
                    dataList.add(oneRow);
                }
            }
            return dataList;
        }
        return null;
    }
    
    public static ArrayList getRowLabels(){
        return rowLabels;
    }
}
