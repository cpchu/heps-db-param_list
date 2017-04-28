/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package heps.db.param_list.exl2db.tools;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *
 * @author lv
 * @author chu
 */
public class ReadPersistenceXML {

    public static Map getPropMap() {
        Map propMap=new HashMap();
        try {
            File f = new File("src/META-INF/persistence.xml");
            SAXReader reader = new SAXReader();
            Document document = reader.read(f);
            Element root = document.getRootElement();
            Element props = root.element("persistence-unit").element("properties");
            Iterator it = root.element("persistence-unit").element("properties").elementIterator();
            while (it.hasNext()) {
                Element element = (Element) it.next();
                propMap.put(element.attribute("name").getData(), element.attribute("value").getData());
                //System.out.println(element.attribute("value").getData());
            }
        } catch (DocumentException ex) {
            Logger.getLogger(ReadPersistenceXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        return propMap;
    }
}
