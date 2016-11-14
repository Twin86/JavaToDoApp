/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatodoapp;

import database.DataBaseMySQL;
import java.io.File;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sebastian
 */
public class Interface {

    //protected config path
    protected String config_file_path = new File("").getAbsolutePath() + "/src/resource/database.properties";
    protected String user[][] = new String[2][2];
    protected String dbControler;
    //database controlers
    protected DataBaseMySQL mysql;

    //protected methods
    protected ResultSet getData(String query) {
        ResultSet result = null;

        switch (dbControler) {
            case "MySQL": {
                result = mysql.get(query);
                break;
            }
        }

        return result;
    }

    //public methods
    public boolean login(String email, char[] pass) {

        boolean isLogin = false;

        switch (dbControler) {
            case "MySQL": {

                ResultSet result;

                result = mysql.get("select id,email,pass from users where email ='" + email + "' and is_delete <> 1");

                if (mysql.getRowCount(result) == 1) {
                    try {
                        while (result.next()) {

                            if (new String(pass).equals(result.getString("pass"))) {

                                user[0][0] = "email";
                                user[1][0] = result.getString("email");

                                user[1][0] = "id";
                                user[1][1] = result.getString("id");

                                isLogin = true;

                                result.close();
                                break;
                            }

                        }

                    } catch (Exception e) {
                        System.out.println("Błąd " + e.toString());
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

    public void updateTable(JTable table, String t_name) {

        ResultSet rs = getData("select * from " + t_name);

        //To remove previously added rows
        while (table.getRowCount() > 0) {
            ((DefaultTableModel) table.getModel()).removeRow(0);
        }
        try {
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                Object[] row = new Object[columns];
                for (int i = 1; i <= columns; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                ((DefaultTableModel) table.getModel()).insertRow(rs.getRow() - 1, row);
            }
        } catch (Exception e) {
            System.out.println("Błąd " + e.toString());
        }

    }

}
