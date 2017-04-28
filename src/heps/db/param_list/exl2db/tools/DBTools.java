package heps.db.param_list.exl2db.tools;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.tools.persistence.PersistenceTools;

/**
 *
 * @author lv
 * @author chu
 */
public class DBTools {

    public static Connection conn;

    public static Connection getConnection(String driver, String url, String user, String password) throws SQLException {
        //Connection conn = null;
        if (conn == null) {
            Map properties = PersistenceTools.setPersistenceParameters(driver, url, user, password);
            //String driver1 = (String) properties.get("javax.persistence.jdbc.driver");
            // System.out.println(driver1);
            //  String url1 = (String) properties.get("javax.persistence.jdbc.url") + "?rewriteBatchedStatements=true";
            // String url1 = (String) properties.get("javax.persistence.jdbc.url");
            try {
                Class.forName(driver);
                conn = (Connection) DriverManager.getConnection(url, user, password);
                boolean rbsign = conn.getRewriteBatchedStatements();
                if (!rbsign) {
                    url = url + "?rewriteBatchedStatements=true";
                    closeConnection();
                    conn = (Connection) DriverManager.getConnection(url, user, password);
                }
            } catch (ClassNotFoundException ce) {
                ce.printStackTrace();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } else {
            String userName = conn.getMetaData().getUserName();
            String u = userName.substring(0, userName.indexOf("@"));
            if (!user.equals(u)) {
                closeConnection();
                DriverManager.getConnection(url, user, password);
                boolean rbsign = conn.getRewriteBatchedStatements();
                if (!rbsign) {
                    url = url + "?rewriteBatchedStatements=true";
                    closeConnection();
                    conn = (Connection) DriverManager.getConnection(url, user, password);
                }
            }
        }
        return conn;
    }

    public static Connection getConnection(String user, String password) throws SQLException {
        // Connection conn = null;
        Map properties = ReadPersistenceXML.getPropMap();
        String driver = (String) properties.get("javax.persistence.jdbc.driver");
        //String url = properties.get("javax.persistence.jdbc.url") + "?rewriteBatchedStatements=true";
        String url = (String) properties.get("javax.persistence.jdbc.url");
        if (conn == null) {
            
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBTools.class.getName()).log(Level.SEVERE, null, ex);
            }
            conn = (Connection) DriverManager.getConnection(url, user, password);
            boolean rbsign = conn.getRewriteBatchedStatements();
            if (!rbsign) {
                url = url + "?rewriteBatchedStatements=true";
                closeConnection();
                conn = (Connection) DriverManager.getConnection(url, user, password);
            }

        } else {
           
            String userName = conn.getMetaData().getUserName();
            String u = userName.substring(0, userName.indexOf("@"));
            if (!user.equals(u)) {
                closeConnection();
                DriverManager.getConnection(url, user, password);
                boolean rbsign = conn.getRewriteBatchedStatements();
                if (!rbsign) {
                    url = url + "?rewriteBatchedStatements=true";
                    closeConnection();
                    conn = (Connection) DriverManager.getConnection(url, user, password);
                }
            }
        }
        return conn;
    }

    public static Connection getConnection() {

        // Connection conn = null;   
        if (conn == null) {
         
            Map properties = ReadPersistenceXML.getPropMap();
            String driver = (String) properties.get("javax.persistence.jdbc.driver");
            // String url = properties.get("javax.persistence.jdbc.url") + "?rewriteBatchedStatements=true";
            String url = (String) properties.get("javax.persistence.jdbc.url");
            String user = (String) properties.get("javax.persistence.jdbc.user");
            String password = (String) properties.get("javax.persistence.jdbc.password");
            try {
                Class.forName(driver);
                conn = (Connection) DriverManager.getConnection(url, user, password);
                boolean rbsign = conn.getRewriteBatchedStatements();
                // System.out.println(rbsign);
                if (!rbsign) {
                    url = url + "?rewriteBatchedStatements=true";
                    //closeConnection(conn);
                    closeConnection();
                    conn = (Connection) DriverManager.getConnection(url, user, password);
                }
                // System.out.println("****" + conn.getRewriteBatchedStatements());
            } catch (ClassNotFoundException ce) {
                ce.printStackTrace();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return conn;
    }

    public static void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeStatement(Statement state) {
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closePreparedStatement(PreparedStatement state) {
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
