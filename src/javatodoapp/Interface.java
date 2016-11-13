/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatodoapp;

import database.DataBaseMySQL;
import java.io.File;
import java.sql.ResultSet;

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

    public boolean login(String user, char[] pass) {

        boolean isLogin = false;

        switch (dbControler) {
            case "MySQL": {

                ResultSet result;

                result = mysql.get("select id,email,pass from users where email ='" + user + "' and is_delete <> 1");

                if (mysql.getRowCount(result) == 1) {
                    try {
                        while (result.next()) {
                            
                            if(new String(pass).equals(result.getString("pass"))){
                                
                                
                                user = result.getString("email");
                                isLogin = true;
                                break;
                            }
                            
                        }
                        
                    } catch (Exception e) {
                        System.out.println("Błąd "+e.toString());
                    }

                }
                
                break;

            }

            default: {

                break;
            }
        }
        return isLogin;
    }

    public boolean logout() {

        return true;
    }

    public void setDbControler(int choose) {
        switch (choose) {

            default: {
                dbControler = "MySQL";
                mysql = new DataBaseMySQL(config_file_path);
                break;
            }
        }
    }

}
