/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatodoapp;
import gui.JavaToDoAppGui;

/**
 *
 * @author sebastian
 */
public class JavaToDoApp {

    //protected
    
    
    //private
    private static JavaToDoAppGui app ;
    
    //public
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code
        app = new JavaToDoAppGui();
        app.setVisible(true);
    }
    
}
