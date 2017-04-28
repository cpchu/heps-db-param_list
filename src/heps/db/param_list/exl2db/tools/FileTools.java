/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.exl2db.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author lv
 */
public class FileTools {
    
    public static FileInputStream getFileInputStream(String filePath) {
        FileInputStream inp = null;
        try {
            inp=new FileInputStream(filePath);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileTools.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        return inp;
    }
        
    public static Workbook getWorkbook(FileInputStream inp) {
        Workbook wb=null;
        try {
            wb=WorkbookFactory.create(inp);
        } catch (IOException  ex) {
            Logger.getLogger(FileTools.class.getName()).log(Level.SEVERE, null, ex);
          
        }catch(InvalidFormatException ex){
           Logger.getLogger(FileTools.class.getName()).log(Level.SEVERE, null, ex);
        }
        return wb;
    }
}
