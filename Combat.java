/*Author: Marco C & Marco O
 Purpose: This class handles the battle. It is used at the end of the game to decide if you win or lose.
 Inherits from: none.
 */  

import java.util.concurrent.TimeUnit;
import java.lang.Math;


public class Combat {

  int userMin = 100;
  int userMax = 151;
  int bossMin = 150;
  int bossMax = 200;
  int userattackMin = 30;
  int userattackMax = 50;
  int bossattackMin = 30;
  int bossattackMax = 75;
  int moveMin = 0;
  int moveMax = 9;
  double userAttack;
  double bossAttack;

/*
The runCombat Method is the start of the combat class it's what first occurs when you run into the boss
the method gives you story and sets your weapons and armour to what you found in the chests on your journey
*/
  public void runCombat(Chests chest, Images img) throws InterruptedException{
    
    String weapon = chest.weapon;
    String armour = chest.armour;

    TimeUnit.MILLISECONDS.sleep(1000);
    System.out.println("....");
    System.out.println();
    TimeUnit.MILLISECONDS.sleep(1000);
    System.out.println("Treading through the darkness, you come to find a large old door, with ancient patterns and designs lining the sides.");
    System.out.println();
    TimeUnit.MILLISECONDS.sleep(4000);
    System.out.println("An ominous aura seethes through the cracks,serving as a warning to all who enter.");
    System.out.println("");
    TimeUnit.MILLISECONDS.sleep(4000);
    System.out.println("Weapon in hand and fear swallowed, you muster up your courage.");
    System.out.println("");
    TimeUnit.MILLISECONDS.sleep(4000);
    System.out.println("The doors open into a wide dark corridor.")
    ;
    TimeUnit.MILLISECONDS.sleep(3000);
    System.out.println("");
    System.out.println("Loud foodsteps walk towards you. Your eyes widen as you see the evil entity.");
    TimeUnit.MILLISECONDS.sleep(4500);
    System.out.println("");
    System.out.println(Colours.PURPLE_BRIGHT+"DEMON KING SHROOMBA APPEARS."+Colours.RESET);
    img.setImage("ImageFiles//bossencounter.png");
    System.out.println("");
    TimeUnit.MILLISECONDS.sleep(2000); //Introductory Story
    /*
    The next lines generate a random number for the userHP between 100 - 150
    The next line generates the bosses health between 150 - 200
    */
    double userHP = (int) Math.floor(Math.random() * (userMax - userMin + 1) + userMin);
    double bossHP = (int) Math.floor(Math.random() * (bossMax - bossMin + 1) + bossMin);

    System.out.println("Your Starting Health: "+ Colours.GREEN_BRIGHT + userHP+Colours.RESET);
    TimeUnit.MILLISECONDS.sleep(2000);
    System.out.println("Boss' Starting Health: " +Colours.GREEN_BRIGHT + bossHP+ Colours.RESET);
    TimeUnit.MILLISECONDS.sleep(2000);
    do {//Do while to keep the auto ran combat to keep running as long as the user and Boss are alive
      img.setImage("ImageFiles//fightstart.png");
      TimeUnit.MILLISECONDS.sleep(1500);
      userMove(chest, img);
      bossHP = bossHP - userAttack;// calculates the Boss' new health after the User attacks

      if (bossHP > 0) {//checks the boss' health before he attacks because he can't attack if he's dead
        bossMove(chest, img);
        userHP = userHP - bossAttack;// calculates the User' new health after the Boss attacks
      }
      System.out.println("");
      System.out.println("User Health: " + Colours.GREEN_BRIGHT + Math.round(userHP) + Colours.RESET);
      TimeUnit.MILLISECONDS.sleep(2000);
      System.out.println("Boss Health: "+ Colours.GREEN_BRIGHT+ Math.round(bossHP) +Colours.RESET);
      TimeUnit.MILLISECONDS.sleep(2000);
      System.out.println("");

    } while (bossHP > 0 && userHP > 0);

    if (userHP <= 0) {
      System.out.println("Demon King Shroomba swings his mighty weapon one last time and you see everything fading around you. Your life flashes before your eyes as you see your family, waifu, and memories before everything turns to black.");
      TimeUnit.MILLISECONDS.sleep(4000);
      System.out.println();
      img.setImage("ImageFiles//gameover.png");
      System.out.println(Colours.RED+"GAME OVER! YOU FAIL! "+Colours.RESET+"System.exit(Your Life)");// Message displayed if the user dies to the boss
      TimeUnit.MILLISECONDS.sleep(2000);
    }
    if (bossHP <= 0) {
      System.out.println("With a final swing of your weapon, and a jump on the top of his head, Demon King Shroomba falls and disappears, freeing the lost souls of the city, and having the land return to peace once more.");
      System.out.println("");
      TimeUnit.MILLISECONDS.sleep(4000);
      img.setImage("ImageFiles//youwin.png");
      System.out.println
      (Colours.GREEN_BRIGHT+"GAME OVER! YOU WON! "+Colours.RESET+"YOU HAVE SLAYED THE FOUL BOSS!");// Message displayed if you beat the boss
      TimeUnit.MILLISECONDS.sleep(2000);
    }
  }//method
 

  public double userMove(Chests chest, Images img) throws InterruptedException{
    int moveChance = (int) Math.floor(Math.random() * (moveMax - moveMin + 1) + moveMin);

    if (moveChance >= 1) {// checks to see if the attack 
      img.setImage("ImageFiles//playerattack.png");
      userAttack = (int) Math.floor(Math.random() * (userattackMax - userattackMin + 1) + userattackMin);//generates a random attack value from 30 - 50
      userAttack = userAttack * chest.weaponMultiplier;// Weapon attack multiplier
      System.out.println();


      if (moveChance == 1) {// checks to see if the attack was a crit
        System.out.println(Colours.RED+"You Hit A Critical Strike!"+Colours.RESET);
        System.out.println("");
        System.out.println("100+ Style points!");
        TimeUnit.MILLISECONDS.sleep(2000);
        userAttack = userAttack * 1.5;//Critical attack multiplier
        System.out.println("");
        System.out.println("You have dealt " +Colours.GREEN_BRIGHT + Math.round(userAttack) + Colours.RESET+" damage");//displays the damage the user has dealt
        System.out.println("");
        TimeUnit.MILLISECONDS.sleep(3000);
      } 
      else {
        System.out.println("You have dealt " +Colours.GREEN_BRIGHT + Math.round(userAttack) + Colours.RESET+" damage");//displays the damage the user has dealt
        System.out.println("");
        TimeUnit.MILLISECONDS.sleep(3000);
      }
    }
    if (moveChance == 0) {
      userAttack=0;
      System.out.println();
      System.out.println(Colours.RED+"You Missed Your Attack! BOO HOO"+Colours.RESET);
      TimeUnit.MILLISECONDS.sleep(2000);
      System.out.println("");
      System.out.println("Wow... I thought you were better than this.");
      System.out.println("");
      TimeUnit.MILLISECONDS.sleep(3000);
    }
    return userAttack;
  }

  public double bossMove(Chests chest, Images img) throws InterruptedException{
    img.setImage("ImageFiles//bossattack.png");

    bossAttack = (int) Math.floor(Math.random() * (bossattackMax - bossattackMin + 1) + bossattackMin);
    int moveChance = (int) Math.floor(Math.random() * (moveMax - moveMin + 1) + moveMin); //generates the move the Boss makes (Crit, Normal attack)
    if (moveChance == 1) {
      bossAttack = bossAttack * 1.5;//Critical Hit multiplier
      bossAttack = bossAttack * chest.armourReducer;//Damage reducing multiplier
      System.out.println("The Boss has hit a "+Colours.RED+"critical strike"+Colours.RESET+"! He dealt " +Colours.GREEN_BRIGHT+ Math.round(bossAttack) + Colours.RESET+ " Damage");
      TimeUnit.MILLISECONDS.sleep(2000);
      System.out.println("");
      System.out.println("He isn't called a boss for nothing. ");
      TimeUnit.MILLISECONDS.sleep(2000);
    } // else
    else {
      bossAttack = bossAttack * chest.armourReducer;//Damage reducing multiplier
      System.out.println("The Boss has dealt " +Colours.GREEN_BRIGHT+ Math.round(bossAttack) +Colours.RESET+" damage ");
      TimeUnit.MILLISECONDS.sleep(2000);
      System.out.println("");
      System.out.println("OUCH! That hurt!");
      TimeUnit.MILLISECONDS.sleep(2000);
    }
    return bossAttack;
  }// method
} // Class