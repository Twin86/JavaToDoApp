/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatodoapp;

/**
 *
 * @author sebastian
 */
public class Interface {
    
    
    
    public boolean login(){
    
        return true;
    }
    
    public boolean logout(){
        
        return false;
    }
    
    public void setDbControler(int choose){
        
    }
    protected void printMenu(){
        System.out.println("ToDo App\n");
        System.out.println("******************\n");
        System.out.println("MENU:\n");
        System.out.println("------------------\n");
        System.out.println("1:Logowanie \n");
        System.out.println("2:Zadania \n");
        System.out.println("------------------\n");
        System.out.println("0:Wyloguj/Zamknij \n");
    }
    
    public void menu(){
        
        int option = 0;
        
        printMenu();
        
        do {            
            
        } while (option != 0);
    }
    
}
