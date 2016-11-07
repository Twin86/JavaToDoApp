/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author sebastian
 */
public class User {
    
    protected String name;
    protected int id;
    
    
    
    /*
    * @param String whit user name 
    */
    public User(String n){
        name = n;
    }
    
    //methods public
    
    /*
    * @param String new user name
    */
    public void setName(String newName){
        name = newName;
    }
    /*
    * @param none
    * @return String whit user name
    */
    public String getSelfInfo(){
        return name;
    }
    
}
