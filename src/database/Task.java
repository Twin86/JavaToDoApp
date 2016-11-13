/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;
/**
 *
 * @author sebastian
 */
public class Task {
    
    protected String t_Name;
    protected String[] params = {"id","title","description"};
    
    public Task(String name){
        t_Name = name;
    }
    
    public void put(){
       
    }
    
    public void get(){
        //get(t_Name);
    }
}
