package com.prashast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ExcelUtil {

    private String dataSource;
    private Connection connection;


    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public Connection makeConnection(){

        String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
        String url = "jdbc:odbc:"+getDataSource();
        try{
            Class.forName(driver);
            connection=DriverManager.getConnection(url);
        }catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace();
            System.out.println("Error establishing connection to Excel file");
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
            System.out.println("Error establishing connection to Excel file");
        }
       return connection;
    }
}
