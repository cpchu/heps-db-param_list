/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.exl2db;

import heps.db.param_list.exl2db.tools.FileTools;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hpsf.MarkUnsupportedException;
import org.apache.poi.hpsf.NoPropertySetStreamException;
import org.apache.poi.hpsf.PropertySetFactory;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.poifs.eventfilesystem.POIFSReader;
import org.apache.poi.poifs.eventfilesystem.POIFSReaderEvent;
import org.apache.poi.poifs.eventfilesystem.POIFSReaderListener;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author lv
 * @author chu
 */
public class ReadExl {

    private SummaryInformation si;

    public static Workbook getWorkbook(String filePath) {
        if (filePath == null || "".equals(filePath)) {
            System.out.println("Warning: Please assign the specific path of the spreadsheet!");
            return null;
        } else {
            FileInputStream inp = FileTools.getFileInputStream(filePath);
            Workbook wb = FileTools.getWorkbook(inp);
            return wb;
        }
    }
    
    public String getFileName(String filePath){
       int startIndex=filePath.lastIndexOf("\\");
       int lastIndex=filePath.indexOf(".");
       String fileName=filePath.substring(startIndex+1, lastIndex);
       return fileName;
    }

    public void getPropertys(String filePath) {
        try {
            final String filename = filePath;
            POIFSReader r = new POIFSReader();
            r.registerListener(new MyPOIFSReaderListener(),
                    "\005SummaryInformation");
            r.read(new FileInputStream(filename));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadExl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadExl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    class MyPOIFSReaderListener implements POIFSReaderListener {

        @Override
        public void processPOIFSReaderEvent(POIFSReaderEvent event) {
            //SummaryInformation si = null;
            try {
                si = (SummaryInformation) PropertySetFactory.create(event.getStream());
            } catch (NoPropertySetStreamException | MarkUnsupportedException | IOException ex) {
                throw new RuntimeException("Property set stream \""
                        + event.getPath() + event.getName() + "\": " + ex);
            }
            /*final String title = si.getTitle();
            if (title != null) {
                System.out.println("Title: \"" + title + "\"");
            } else {
                System.out.println("Document has no title.");
            }
            System.out.println(si.getAuthor());*/
        }
    }

    public SummaryInformation getSummaryInformation(String filePath) {
        if(si==null){
           this.getPropertys(filePath);
        }
        return si;
    }
    
    public void setSummaryInformation(String filePath){
       this.getPropertys(filePath);
    }
}
