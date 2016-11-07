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


/**
 *
 * @author sebastian
 */
public class DataBase {

    //static config path
    static String config_file_path = "/resource/database.properities";
    
    //var
    protected String dbHost;
    protected String dbUser;
    //read config
    protected void read() {
        
        Configurations configs = new Configurations();
        try {
            Configuration config = configs.properties(new File(config_file_path));
            
            dbHost = config.getString("database.host");
            dbUser = config.getString("database.user");
        
        } catch (ConfigurationException cex) {
            System.out.print(cex.getMessage());
        }
    }

    public DataBase() {
       read();
    }

    public String getSelf() {
       return dbHost;
    }
}
