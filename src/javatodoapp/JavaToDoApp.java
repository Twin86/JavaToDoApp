/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatodoapp;
import user.User;
import database.DataBase;


/**
 *
 * @author sebastian
 */
public class JavaToDoApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code
        User u = new User("Sebastian");
        DataBase db = new DataBase();
        System.out.print(u.getSelfInfo());
        System.out.print(db.getSelf());
    }
    
}
