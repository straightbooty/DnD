

import java.util.Random;


public class Hero {
    private String name;
    public int hp;
    public int xp;
    public int attack;
    
    public Hero(){
        this.name = "Hero";
        this.hp = 500;
        this.xp = 0;
        
        
    }
    
    public int strike(){
        Random rand = new Random();
        int roll = rand.nextInt(12);
        int dice = rand.nextInt(12);
        int str = roll + dice;
        this.attack = str;
        if (this.attack > 20){
            System.out.println("Critical Hit");
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
    
    
    public int swordStrike(){
        Sword sword = new Sword("Legendary", 150);
        Random rand = new Random();
        int roll = rand.nextInt(12);
        int dice = rand.nextInt(12);
        int legend = sword.slash();
        int str = roll + dice + legend;
        this.attack = str;
        if (this.attack > 30){
            System.out.println("Critical Hit");
            return this.attack;
        }
        else if (this.attack < 15){
            System.out.println("Weak Attack");
            return this.attack;
        }
        
        else {
            System.out.println("Normal Attack");
            return this.attack;
        }
        
    }
    
    
    
    public int move(){
        Random rand = new Random();
        int walk = rand.nextInt(10);
        return walk;
    }
    
    public String toString(){
        return "You have "  + this.hp + " health remaining." + "\n" + "You have " + this.xp + "experience.";
    }
    
    public String equip(){
       return this.name + " the item.";
    }
    
    
    
    public int levelUp(int x){
        return this.xp + x;
    }
    
    
    public int dodge(){
        Random rand = new Random();
        int dodge = rand.nextInt(10);
        return dodge;
    }    
}
