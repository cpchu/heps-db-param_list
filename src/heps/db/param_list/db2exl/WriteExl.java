/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.db2exl;

import heps.db.param_list.entity.Data;
import heps.db.param_list.exl2db.tools.DataJpaController;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author Administrator
 */
public class WriteExl {

    List<Data> dataList;
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.CHINESE);

    public void writeExl(String filePath, String sheetName) throws FileNotFoundException, IOException {
        DataJpaController djc = new DataJpaController();
        dataList = djc.findDataEntities();
        /*
        for(int i = 0;i<dataList.size();i++){
            System.out.println("i:"+i+"parameter:"+dataList.get(i).getParameter().getName()+"team:"+dataList.get(i).getTeam().getName()+"size:"+dataList.size());
        }
**/
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(sheetName);
        for (int i = 0; i < dataList.size(); i++) {
            HSSFRow row = sheet.createRow(i);

            HSSFCell cell = row.createCell(0);
            cell.setCellValue(dataList.get(i).getSystem().getName());

            cell = row.createCell(1);
            cell.setCellValue(dataList.get(i).getTeam().getName());

            cell = row.createCell(2);
            try {
                cell.setCellValue(dataList.get(i).getTeam().getManagerid().getName().toString());
            } catch (NullPointerException e) {
                cell.setCellValue("");
            }

            cell = row.createCell(3);
            try {
                cell.setCellValue(dataList.get(i).getTeam().getParentid().getName());
            } catch (NullPointerException e) {
                cell.setCellValue("");
            }

            cell = row.createCell(4);
            try {
                cell.setCellValue(dataList.get(i).getSystem().getParentid().getName());
            } catch (NullPointerException e) {
                cell.setCellValue("");
            }

            cell = row.createCell(5);
            try {
                cell.setCellValue(dataList.get(i).getParameter().getName());
            } catch (NullPointerException e) {
                cell.setCellValue("");
            }

            cell = row.createCell(6);
            try {
                cell.setCellValue(dataList.get(i).getAttribute().getName());
            } catch (NullPointerException e) {
                cell.setCellValue("");
            }
            cell = row.createCell(7);
            try {
                cell.setCellValue(dataList.get(i).getParameter().getUnitid().getName());
            } catch (NullPointerException e) {
                cell.setCellValue("");
            }
            cell = row.createCell(8);
            try {
                cell.setCellValue(dataList.get(i).getValue());
            } catch (NullPointerException e) {
                cell.setCellValue("");
            }
            cell = row.createCell(9);
            try {
                //cell.setCellType(CellType.NUMERIC);
                
                cell.setCellValue(sdf.format(dataList.get(i).getDatemodified()));
            } catch (NullPointerException e) {
                cell.setCellValue("");
            }
            cell = row.createCell(10);
            try {
                cell.setCellValue(dataList.get(i).getComment());
            } catch (NullPointerException e) {
                cell.setCellValue("");
            }
            cell = row.createCell(11);
            try {
                cell.setCellValue(dataList.get(i).getParameter().getReferenceid().getTitle());
            } catch (NullPointerException e) {
                cell.setCellValue("");
            }
            cell = row.createCell(12);
            try {
                cell.setCellValue(dataList.get(i).getParameter().getReferenceid().getAuthor());
            } catch (NullPointerException e) {
                cell.setCellValue("");
            }

            cell = row.createCell(13);
            try {
                cell.setCellValue(dataList.get(i).getParameter().getReferenceid().getPublication());
            } catch (NullPointerException e) {
                cell.setCellValue("");
            }

            cell = row.createCell(14);
            try {
                cell.setCellValue(dataList.get(i).getParameter().getReferenceid().getUrl());
            } catch (NullPointerException e) {
                cell.setCellValue("");
            }

            cell = row.createCell(15);
            try {
                cell.setCellValue(dataList.get(i).getParameter().getReferenceid().getKeywords());
            } catch (NullPointerException e) {
                cell.setCellValue("");
            }

        }
        //FileOutputStream output = new FileOutputStream("d:\\workbook.xls");
        FileOutputStream output = new FileOutputStream(filePath);
        wb.write(output);
        output.flush();

    }
}
