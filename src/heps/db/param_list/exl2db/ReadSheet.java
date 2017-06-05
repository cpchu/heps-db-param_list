/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.exl2db;

import heps.db.param_list.api.ParameterAPI;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    ArrayList<String> rowLabels = new ArrayList<>();
    ArrayList rowLabels1 = new ArrayList();
//    HashMap<String, ParameterAPI> paramList = new HashMap<>();

    enum labels {

    }

    public ArrayList getParamList(Workbook wb, String sheetName) {
        if (wb == null) {
            System.out.println("Error!");
        } else {
            Sheet sheet = wb.getSheet(sheetName);
            ArrayList dataList = new ArrayList();
            boolean labelRow1;
            boolean labelRow2;
            for (Iterator<Row> rit = sheet.rowIterator(); rit.hasNext();) {
                Row row = (Row) rit.next();
//                ArrayList oneRow = new ArrayList();
                ParameterAPI pam = new ParameterAPI();
                labelRow1 = false;
                labelRow2 = false;
                int cellCounter = 0;
                for (Cell cell : row) {
                    try {
                        Object o = "";
                        String label1 = null;
                        String label2 = null;
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_STRING:
                                o = cell.getStringCellValue();
                                if (o.equals("System")) {
                                    labelRow1 = true;
                                    labelRow2 = false;
                                }
                                if (o.equals("系统")) {
                                    labelRow1 = false;
                                    labelRow2 = true;
                                }

                                //preparing ParamterAPI object
                                switch (cellCounter) {
                                    case 0:
                                        pam.setSystem((String) o);
                                        break;
                                    case 1:
                                        pam.setTeam((String) o);
                                        break;
                                    case 2:
                                        pam.setTeamManager((String) o);
                                        break;
                                    case 3:
                                        break;
                                    case 4:
                                        pam.setParameterName((String) o);
                                        break;
                                    case 5:
                                        pam.setAttribute((String) o);
                                        break;
                                    case 6:
                                        pam.setUnit((String) o);
                                        break;
                                    case 7:
                                        pam.setData((String) o);
                                        break;
                                    case 8:
                                        DateFormat df = DateFormat.getDateInstance();
                                        pam.setDate(df.parse((String) o));
                                        break;
                                    case 9:
                                        pam.setDefinition((String) o);
                                        break;
                                    case 10:
                                        pam.setReferenceTitle((String) o);
                                        break;
                                    case 11:
                                        pam.setReferenceAuthor((String) o);
                                        break;
                                    case 12:
                                        pam.setReferencePublication((String) o);
                                        break;
                                    case 13:
                                        pam.setReferenceURL((String) o);
                                        break;
                                    case 14:
                                        pam.setKeyword((String) o);
                                        break;
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
//                    oneRow.add(o);
                        if (labelRow1) {
                            label1 = (String) o;
                            rowLabels.add(label1);
                        }
                        if (labelRow2) {
                            label2 = (String) o;
                            rowLabels1.add(label2);
                        }

                        cellCounter++;
                    } catch (ParseException ex) {
                        Logger.getLogger(ReadSheet.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (!labelRow1 && !labelRow2) {
//                    dataList.add(oneRow);
                    dataList.add(pam);
                }
            }
            return dataList;
        }
        return null;
    }

    public ArrayList getRowLabels() {
        return rowLabels;
    }

}
