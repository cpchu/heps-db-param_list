/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.exl2db;

import java.util.ArrayList;
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
   
    public static ArrayList getParamList(Workbook wb, String sheetName) {
        if (wb == null) {
            System.out.println("Error!");
        } else {
            Sheet sheet = wb.getSheet(sheetName);            
            ArrayList dataList = new ArrayList();
            for (Iterator<Row> rit = sheet.rowIterator(); rit.hasNext();) {
                Row row = (Row) rit.next();
                ArrayList oneRow = new ArrayList();
                for (Iterator<Cell> cit = row.iterator(); cit.hasNext();) {
                    Cell cell = cit.next();
                    Object o = "";
                    switch (cell.getCellType()) {

                        case Cell.CELL_TYPE_STRING:
                            o = cell.getStringCellValue();
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
                }
                dataList.add(oneRow);
            }
            return dataList;
        }
        return null;
    }
    
}
