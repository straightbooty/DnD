
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Goblin extends Monster {
    public String name;
    public int hp;
    public int attack;
    
    public Goblin(String name){
        super(name,70);
        this.name = name;
        this.hp = 70;
    }
    
    public int strike(){
        Random rand = new Random();
        int roll = rand.nextInt(10);
        int dice = rand.nextInt(10);
        int str = roll + dice;
        this.attack = str;
       
        
        if (this.attack < 10){
            System.out.println("Weak Attack");
            return this.attack;
        }
        
        else {
            System.out.println("Normal Attack");
            return this.attack;
        }
    }
}