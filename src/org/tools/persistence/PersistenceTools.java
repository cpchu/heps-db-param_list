/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tools.persistence;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author lv
 * @author chu
 */
public class PersistenceTools {

    public static Map setPersistenceParameters(String driver, String url, String user, String password) {
        Map map = new HashMap();
        String driver1 = null;
        String url1 = null;
        switch (driver.toLowerCase()) {
            case "mysql":
                driver1 = "com.mysql.jdbc.Driver";             
                url1 = "jdbc:mysql://" + url + "/discs_model";
                break;
            case "postgresql":
                driver1 = "org.postgresql.Driver";
                url1 = "jdbc:postgresql://" + url + "/discs_model";
                break;
            case "oracle":
                driver1 = "oracle.jdbc.driver";
                url1 = "jdbc:oracle:thin:@" + url + ":discs_model";
                break;
        }      
        map.put("javax.persistence.jdbc.driver",driver1);
        map.put("javax.persistence.jdbc.url",url1);
        map.put("javax.persistence.jdbc.user", user);
        map.put("javax.persistence.jdbc.password", password);
        return map;
    }
    
}
