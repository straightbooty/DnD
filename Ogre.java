/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */

import java.util.Random;


public class Ogre extends Monster {
    public String name;
    public int hp;
    public int attack;
    
    public Ogre(String name){
        super(name,300);
        this.name = name;
        this.hp = 400;
    }

    public int strike(){
        Random rand = new Random();
        int roll = rand.nextInt(12);
        int dice = rand.nextInt(12);
        int str = roll + dice;
        this.attack = str + 30 ;
        if (this.attack > 40){
            System.out.println("Critical Hit: ");
            return this.attack;
        }
        
        else {
            System.out.println("Normal Attack");
            return this.attack;
        }
    }    
}
