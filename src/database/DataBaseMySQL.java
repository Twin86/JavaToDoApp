/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author sebastian
 */
public class DataBaseMySQL {

    //static config path
    protected String config_file_path = new File("").getAbsolutePath() + "/src/resource/database.properties";

    //var
    protected String dbHost;
    protected String dbUser;
    protected String dbPass;

    //db handler
    public Connection conn = null;

    /**
     *
     * @param null
     */
    public DataBaseMySQL(String config_file) {
        Configurations configs = new Configurations();
        try {
            Configuration config = configs.properties(new File(config_file));

            dbHost = config.getString("database.host");
            dbUser = config.getString("database.user");
            dbPass = config.getString("database.password");

            dbConnect();

        } catch (ConfigurationException cex) {
            System.out.print(cex.getMessage());
        }
    }

    public void dbConnect() {
        System.out.println("Connecting to the database...");
        try {
            conn = DriverManager.getConnection(dbHost, dbUser, dbPass);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    public int getRowCount(ResultSet resultSet) {
        if (resultSet == null) {
            return 0;
        }
        try {
            resultSet.last();
            return resultSet.getRow();
        } catch (SQLException exp) {
            exp.printStackTrace();
        } finally {
            try {
                resultSet.beforeFirst();
            } catch (SQLException exp) {
                exp.printStackTrace();
            }
        }
        return 0;
    }

    public ResultSet get(String[] keys, String t_name) {

        ResultSet res;
        Statement stmt;

        String query = "select ";

        for (int i = 0; i < keys.length; i++) {

            query = query + keys[i] + " ,";
        }

        query = query.replace(query.substring(query.length() - 1), "");
        query = query + "from " + t_name;

        System.out.println(query);

        try {

            stmt = conn.createStatement();
            res = stmt.executeQuery(query);

            return res;
            /*
             while (res.next()) {
             int id = res.getInt("id");
             String title = res.getString("title");
             System.out.println("Get value from kay's :"+title);
                
             }
             */

            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return res = null;

    }

    public ResultSet get(String quary) {

        ResultSet res;
        Statement stmt;

        try {

            stmt = conn.createStatement();
            res = stmt.executeQuery(quary);

            return res;

            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return res = null;

    }

}
