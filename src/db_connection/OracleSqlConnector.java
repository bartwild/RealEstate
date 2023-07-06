package db_connection;

import java.sql.*;  

public class OracleSqlConnector{  
    public static Connection getConnection(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//CONN_STRING","LOGIN","PASS");
            return con;
        }
        catch(Exception e){System.out.println(e);}
        return null;
    }
};
