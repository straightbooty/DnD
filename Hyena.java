
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
public class Hyena extends Monster {
    public String name;
    public int hp;
    public int attack;
    
    public Hyena(String name){
        super(name,100);
        this.name = name;
        this.hp = 100;
    }
    
    public int strike(){
        Random rand = new Random();
        int roll = rand.nextInt(12);
        int dice = rand.nextInt(12);
        int str = roll + dice;
        this.attack = str;
        if (this.attack > 20){
            System.out.println("Critical Hit: ");
            return this.attack;
        }
        else if (this.attack < 10){
            System.out.println("Weak Attack");
            return this.attack;
        }
        
        else {
            System.out.println("Normal Attack");
            return this.attack;
        }
    }
}
