
import java.util.Random;

public class Monster {
    public String name;
    public int hp;
    public int attack;
    
    public Monster(String name, int x){
       this.name = name;
       this.hp = x;
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
    public String toString(){
        return this.name + " has " + this.hp +  " health remaining.";
    }
}
