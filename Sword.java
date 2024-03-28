/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Sword extends Treasure {
    private int value;
    private String rank;
    
    public Sword(){
        super();
        this.rank = "Normal";
        this.value = 20;
    }
    
    
    public Sword(String rank, int value){
        this.rank = rank;
        this.value = value;
    }
    
    
    public int slash(){
        return value;
        
    }
    
    public String rank(){
        return "This is a " + rank + " sword. It will increase your attack power by " + value;
    }
}
