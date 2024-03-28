/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Potion extends Treasure{
    private int value;
    private String rank;
    
    public Potion(String rank){
        super();
        this.rank = "Normal";
        this.value = 70;
    }
    
    public int heal(){
        return value;
    }
    
    public String rank(){
        return "You have found a " + rank + " potion. It will increase your hp by " + value;
    }
}
