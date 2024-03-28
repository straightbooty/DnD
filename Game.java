
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    
    private static int fortune(){
        Scanner x = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Press enter to roll ");
        String enter = x.nextLine();
        int luck = rand.nextInt(20); //roll the dice
        if (enter.isEmpty()){
            if (luck <= 14){
                System.out.println("You have detected a group of monsters."); //Monster detected
            } 
            else if ( luck <= 5){
                System.out.println("You have been detected by a group of monsters."); // Monster detects you.
            }
            else if (luck == 15){
                System.out.println("You have found a chest!"); // find a chest
            }
            else{
                System.out.println("You have managed to remain undetected.");
            }
        }return luck;
    }
    
    
    public static int attack(Monster f){
        Hero hero = new Hero();
        Scanner x = new Scanner(System.in);
        int heroHealth = hero.hp;
        int monsterHealth = f.hp;
        while (true){
            System.out.println("Press Enter to attack ");
            String enter = x.nextLine();
            int attack = hero.strike(); //You attack
            System.out.println("You have struck the " + f.name + "\n" + "You have inflicted " + attack + " damage.");
            monsterHealth = monsterHealth - attack; //Your attack is subtracted from the monster's overall health
            System.out.println("The " + f.name + " has " + monsterHealth + " health remaining");
            if (monsterHealth <= 0){
                System.out.println("You have slain the " + f.name);
                break;                  //if the monster's hp gets to 0 or less the loop breaks
            }int bite = f.strike();     //monster sattacks you
            System.out.println("The " + f.name + " has attacked you " + "\n" + "It has inflicted " + bite + " damage.");
            heroHealth = heroHealth - bite;  //Monster attack is subtracted from your health
            System.out.println("You have " + heroHealth + " health remaning");
            if (heroHealth <= 0){
                System.out.println("You have been slain by the " + f.name);
                break;  //if your health falls to 0 or below the loop breaks
            }
        }System.out.println("Your remaining health is: "+ heroHealth);    
        return heroHealth;  //gives you remaining health
    }
    
    public static int attacked(Monster f){
        Hero hero = new Hero();
        Scanner x = new Scanner(System.in);
        int heroHealth = hero.hp;
        int monsterHealth = f.hp; 
        while (true){
            int bite = f.strike();  //monster attacks
            System.out.println("The " + f.name + " has attacked you " + "\n" + "It has inflicted " + bite + " damage.");
            heroHealth = heroHealth - bite; //monster attack is subtracted from hero health
            System.out.println("You have " + heroHealth + " health remaning");  //hero's remaining health
            if (heroHealth <= 0){
                System.out.println("You have been slain by the " + f.name); 
                break; //hero's health is 0 or less, loop breaks
            }
            System.out.println("Press Enter to attack ");
            String enter = x.nextLine();
            int attack = hero.strike(); //hero attacks
            System.out.println("You have struck the  " + f.name + "\n" + "You have inflicted " + attack + " damage.");
            monsterHealth = monsterHealth - attack; //attack subtracted from monster's health
            System.out.println("The " + f.name + " has " + monsterHealth + " health remaining");
            if (monsterHealth <= 0){
                System.out.println("You have slain the " + f.name);
                break;  //You killed the monster loop breaks
            }
        }System.out.println("Your remaining health is: " + heroHealth);
        return heroHealth; //hero's remaining health
    }
    
    
    public static ArrayList treasure(){
        ArrayList<Treasure> inventory = new ArrayList<>();
        Scanner x = new Scanner(System.in);
        Random rand = new Random();
        Sword sword = new Sword();
        Potion potion = new Potion("Normal");
        int treasure = rand.nextInt(10); //randomizer to decide if you chest is empty or not
        System.out.println("Press Enter to open the chest");
        String open = x.nextLine();
        if (treasure == 10){  
            System.out.println("You have found a sword");
            System.out.println(sword.rank()); //gives sword level
            inventory.add(sword); //sword item is added to your list
        }
        else if (treasure == 5){
            System.out.println("You have found a potion");
            System.out.println(potion.rank()); //gives potion level
            inventory.add(potion); //pts potion in your list
        }
        else{
            System.out.println("The chest is empty."); //you get nothing
        }
        return inventory; //returns the items in your list
    } 
    
    public static void fortuneNbattle(Hyena g){ 
      
            int luck = fortune(); //method to decide if you're found by monsters,  find monsters or finding treasure
            if (luck <= 14){    
                System.out.println(attack(g)); //you find monsters
            }
            else if (luck <= 5){
                System.out.println(attacked(g)); //monsters attack you
            }
            else if (luck <= 15){
                System.out.println(treasure()); //you find a chest
            }
            else{
                System.out.println("Keep going."); //nothing happened, roll again
            }
         
    }
    
    
    
    public static void fortuneNbattle(Dragon g){ 
            int luck = fortune();
            if (luck <= 14){
                System.out.println(attack(g));
            }
            else if (luck <= 5){
                System.out.println(attacked(g));
            }
            else if (luck <= 15){
                System.out.println(treasure());
            }
            else{
                System.out.println("Keep going."); //same shit but for the dragon
            }
        
    }
    
     public static int attackedG(Monster f){
        Hero hero = new Hero();
        Scanner x = new Scanner(System.in);
        int heroHealth = hero.hp;
        int monsterHealth = f.hp; 
        while (true){
            int bite = f.strike();  //monster attacks
            System.out.println("The " + f.name + " has attacked.");
            System.out.println("Press Enter to dodge");
            String duck = x.nextLine();
            int dodge = hero.dodge();// Hero has a o.7 chance of dodging
            if (dodge < 3){        
                System.out.println("You failed to dodge, the " + f.name + " has hit you " + "\n" + "It has inflicted " + bite + " damage.");
                heroHealth = heroHealth - bite; //monster attack is subtracted from hero health
            }
            else{
                System.out.println("You have dodged the " + f.name);
            }
            System.out.println("You have " + heroHealth + " health remaning");  //hero's remaining health
            if (heroHealth <= 0){
                System.out.println("You have been slain by the " + f.name); 
                break; //hero's health is 0 or less, loop breaks
            }
            System.out.println("Press Enter to attack ");
            String enter = x.nextLine();
            int attack = hero.strike(); //hero attacks
            System.out.println("You have struck the  " + f.name + "\n" + "You have inflicted " + attack + " damage.");
            monsterHealth = monsterHealth - attack; //attack subtracted from monster's health
            System.out.println("The " + f.name + " has " + monsterHealth + " health remaining");
            if (monsterHealth <= 0){
                System.out.println("You have slain the " + f.name);
                break;  //You killed the monster loop breaks
            }
        }System.out.println("Your remaining health is: " + heroHealth);
        return heroHealth; //hero's remaining health
    }
     
    public static int attackedD(Monster f){
        Hero hero = new Hero();
        Scanner x = new Scanner(System.in);
        int heroHealth = hero.hp;
        int monsterHealth = f.hp; 
        Potion potion = new Potion("Normal");
        while (true){
            int bite = f.strike();  //monster attacks
            System.out.println("The " + f.name + " has attacked.");
            System.out.println("Press Enter to dodge");
            String duck = x.nextLine();
            int dodge = hero.dodge();// Hero has a o.6 chance of dodging
            if (dodge < 4){        
                System.out.println("You failed to dodge, the " + f.name + " has hit you " + "\n" + "It has inflicted " + bite + " damage.");
                heroHealth = heroHealth - bite; //monster attack is subtracted from hero health
            }
            else{
                System.out.println("You have dodged the " + f.name);
            }
            System.out.println("You have " + heroHealth + " health remaning");  //hero's remaining health
            if (heroHealth <= 0){
                System.out.println("You have been slain by the " + f.name); 
                break; //hero's health is 0 or less, loop breaks
            }
            System.out.println("Press Enter to attack ");
            String enter = x.nextLine();
            int attack = hero.swordStrike(); //hero attacks
            System.out.println("You have struck the  " + f.name + "\n" + "You have inflicted " + attack + " damage.");
            monsterHealth = monsterHealth - attack; //attack subtracted from monster's health
            System.out.println("The " + f.name + " has " + monsterHealth + " health remaining");
            if (monsterHealth <= 0){
                System.out.println("You have slain the " + f.name);
                break;  //You killed the monster loop breaks
            }
            System.out.println("Press Enter to heal");
            int heal = potion.heal();
            String better = x.nextLine();
            if(heroHealth < 500){
               heroHealth = heroHealth + heal;
               if(heroHealth >= 500){
                   heroHealth = 500;
               }
            }
            else if(heroHealth <= 0){
                heroHealth = 0;
            }
            System.out.println("You have healed, your health is: " + heroHealth);
        }System.out.println("Your remaining health is: " + heroHealth);
         return heroHealth; //hero's remaining health 
    }
    public static void fortuneNbattle(Goblin g){ 
            int luck = fortune();
            if (luck == 15){
                System.out.println(treasure());
            }
            else if (luck <= 14){
                System.out.println(attack(g));
            }
            else if (luck <= 5){
                System.out.println(attacked(g));
            }
            else{
                System.out.println("Keep going."); //same shit but for goblins
            }
        
    }
 

    
    
     
    public static void main(String[] args) {
       Scanner x = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("In the far off kingdom of Mythos, there is magic and monsters, dungeons and dragons." + "\n" + "Our adevnture starts in the small town of Lykos, a new dungeon has appeared and with it the dragon Stormshredder has returned to the realm." + "\n" + "Stormshredder has kidnapped 4 of the brightest youth in the land, among them, the beloved Princess Andromeda." +  "\n" + "The task falls to you, Hero. You are the last of an ancient line of heores who have always defended the kingodm of Lykos, your own father died closing the dungeon the last time Stormshredder appeared and now the mantle falls to you." + "\n" + "It shall not be easy, but these things never are." + "\n" + "Go forth Hero and save the children of Lykos." + "\n" + "You ride toward the dungeon, the blood of your ancestors thrumming in your veins as you race toward your destiny.");
        Hero a = new Hero();
        int heroHealth = a.hp;
        int experience = a.xp;
        Goblin goblin = new Goblin("Goblin");
        Hyena hyena = new Hyena("Hyena");
        Ogre ogre = new Ogre("Ogre");
        Dragon storm = new Dragon("Stormshredder");
        
        System.out.println("You dismount your trusty steed at the entrance of the dungeon, he shall not be able to follow you in." + "\n" + "At the entrance you are confronted by an old man." + "\n" + "My granddaughter, she was taken by those foul beasts, please save her." + "\n" + "I will do the best I can grandfather." + "\n" + "Righteous fury burns in your heart at the thought of the old man's suffering, you swear to do whatever it takes to get his grnadchild back to him." + "\n" + "With grim determinatioin you stand at the dungeon's entrance.(Press 'Enter' to continue into the dungeon.)");
        String breaker = x.nextLine();
        System.out.print("You descend into the depths of the dungeon, heart pounding wildly as the darkness steals over your sight." + "\n" + "Eventually you see a light at the end of the tunnel, you rush toward it, your earier bravado already forgotten." + "\n" + "You come out into a large cavern, bloodstains dimly lit by the blue fluorescent crystals common to dungeons. From the look of them they're fresh." + "\n" + "A scream tears into the air, you look up to see a young girl, a gash on her right leg, a gobling stalks toward her, making angry cittering noises all the while." + "\n" + "Despite her dire circumstances, she holds her own bravely, swinging a club wildly at the beast." + "\n" + "You sneak toward the goblin slowly, hoping to get the drop on them. Press Enter to continue.");                
        String enter = x.nextLine();                       
        int imove = a.move(); //Method for moving in dungeon
        System.out.println("You have moved " + imove + " steps.");
        for(int e = 0; e <= 500; e += 100){ //until e gets to 500, you keep fighting, you'll fight 5 goblins.
            fortuneNbattle(goblin);
        }
        System.out.println("You have rescued the young girl, you dress her wounds and help her back to the tunnel from which you came before going on, to the next level." + "\n" + "Your wounds are magically restored as you enter cross over to the next level." + "\n" + "This must be the 'level up' your grandfather spoke about, you feel stronger already.");
              
        System.out.println("You step out onto the new floor feeling confident in your new abilities. A wave of killing intent smashes into you, the beasts are so much stronger here." + "\n" + "You grit your teeth together in determination." + "\n" + "You can't give up here, those kids are counting on you." + "\n" + "Press Enter to move.");
        String next = x.nextLine();
        int gmove = a.move();
        System.out.println("You have moved " + gmove + " steps.");
        for(int e = 0; e <= 400; e += 100){
            fortuneNbattle(hyena);
        }
        System.out.println("You continue to make your way through the dungeon searching for any sign of those kids." + "\n" + "You come upon a stuffed rabbit, it's checkered form drenched in blood, a hand is attached to it." + "\n" + "Anger seizes your heart and you roar out a chellenge, let them come you think savagely, immediatey you're attacked by a tribe of goblins." + "\n" + "With an animalistic fury you turn your grief upon them, revelling in the battle to come.");
        for(int e = 0; e <= 600; e += 100){
            attack(goblin);
        }
        System.out.println("You drop onto your knees from exhaustion, your anger draining away." + "\n" + "You weep even as you stumble back to your feet, you will not fail the rest." + "\n" + "You find the child on an altar made of bone and ashwood, what remains is barely a body." + "\n" + "You set the body alight and wait beside it, a beacon for all the beasts that will fall to your blade." + "\n" + "A film of red settles over your eyes as the first of them arrive.");
        System.out.println(attack(goblin));
        System.out.println(attacked(hyena));
        System.out.println(attacked(goblin));
        System.out.println("BOOOMMMM!!!! A large club crashes into you, you sail across the length of the cavern and the remaining monsters scatter, ROAARRRRR!!!!! An ogre makes it's way toward you, each step it takes causing the earth to tremor. You remember what your grandfather told you, ogres are insanely strong but very slow. You can do this.");
        System.out.println("New skill unlocked: Dodge");
        attackedG(ogre);
        System.out.println("You have levelled up and earned a new item, Healing Potion.");
        System.out.println("I see you have defeated my guradian, come forth if you dare, come and save the rest of these pathetic children. I can smell you hero. Come avenge your fallen ancestors. Their bones decorate my prison." + "/n" + "Please help us." + "\n" + "The children wail in distress." + "/n" + "You rush to the entrance of the Stormshredder's lair ignoring the oppressive presence of the dark dragon." +"\n" + "The moment you step onto the level, you fall to your knees." + "\n" + "The sheer pressure from Stormshredder's chaos energy presses against you pinning you to the floor like an insect." + "\n" + "You feel your bones grind against each other as you struggle to lift yourself from the ground");
        System.out.println("\n" + "YOU'RE WEAK, WEAKER THAN ANY MAN WHO HAS  EVER STOOD BEFORE ME." + "\n" + "THE LAST ONE FOUGHT WAS WORTHY OF MY TIME. YOU THOUGH, YOU'RE NOTHING, YOU WILL DIE CHOKING ON THE DIRT, YOU ARE NOT FIT TO GAZE UPON ME." + "\n" + "I WONDER IF YOU'LL BE ABLE TO HANDLE THE POWER OF YOUR ANCESTOR'S SWORD. IT WILL BE FUNNY TO WATCH YOU TRY AND FAIL TO LIVE UP TO THE NAME THAT IS HERO." + "A massive sword lands in the dirt beside you, it's former glory covered by dust and grime." + "\n" + "You can feel the spirit of your ancestors calling you from within it, you stretch your hand out to grasp the sword.");
        System.out.println("Press Enter to grab the sword.");
        String grab = x.nextLine();
        System.out.println("The moment your fingers grasp the handle you feel your strength return to you 1000 fold, you feel stronger than you ever have." + "\n" + "You stand up with a confidence that you haven't felt since the start of this campaign, maybe just maybe you can do it." + "\n" + "HOW?? I WILL CRUSH YOU LIKE THE BUG YOU ARE!!!!" + "\n" + "With a casual flick of your wrist you enter your sword stance, the spirit of your ancestors flows through, you shall not fall.");
        a.xp += 1000;
        System.out.println("Your experience has increased, all attacks will now have a base of 150.");
        int end = attackedD(storm);
        if (end <= 0){
            System.out.println("You lost, Game Over.");
        }
        else{
            System.out.println("You saved the kids from the Stormshredder and banished the monsters back to whence they came. You are worthy of the name Hero.");
        }
    }
        
}  
    

