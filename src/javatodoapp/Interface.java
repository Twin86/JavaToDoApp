/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatodoapp;
import database.DataBaseMySQL;
import java.io.File;
/**
 *
 * @author sebastian
 */
public class Interface {
    //protected config path
    protected String config_file_path = new File("").getAbsolutePath() + "/src/resource/database.properties";
    protected String user;
    protected String dbControler;
    //database controlers
    protected DataBaseMySQL mysql;
    
    public boolean login(String user,char[] pass) {
        switch (dbControler) {
            case "MySQL" :{
                String[] myKeys = {"*"};
                mysql.get(myKeys, "tasks");
           }
        } 
        return true;
    }

    public boolean logout() {

        return true;
    }

    public void setDbControler(int choose) {
        switch (choose) {
            
            default:{
                dbControler = "MySQL";
                mysql = new DataBaseMySQL(config_file_path);
                break;
            }
        }    
    }
    
    
}
