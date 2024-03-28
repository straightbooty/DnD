
import java.util.Random;


public class Dragon extends Monster {
    public String name;
    public int hp;
    public int attack;
    
    public Dragon(String name){
        super(name,1000);
        this.name = name;
        this.hp = 1000;
    }
    
    public int strike(){
        Random rand = new Random();
        int roll = rand.nextInt(12);
        int dice = rand.nextInt(12);
        int str = roll + dice;
        this.attack = str * 20;
        if (this.attack > 300){
            System.out.println("Critical Hit: ");
            return this.attack;
        }
        else if (this.attack < 200){
            System.out.println("Weak Attack");
            return this.attack;
        }
        
        else {
            System.out.println("Normal Attack");
            return this.attack;
        }
    }
}
