/*Author: Marco C 
 Purpose: This class handles the chest. It generates the items in the chest, also auto equips the best weapons and armours for you.
 Inherits from: none
 */  
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



public class Chests {
  int upperbound = 20;
  int min = 1;
  int max = 5;
  int random_int;
  Random rand = new Random();

  //Weapon objects
  Fists fist = new Fists();
  DuckySword duckySword = new DuckySword();
  BlockChain blockChain = new BlockChain();
  GonzalezSword gonzalezSword = new GonzalezSword();
  
  //Armour objects
  Naked naked = new Naked();
  ProstheticAB prostheticAB = new ProstheticAB();
  BrokenLG brokenLG = new BrokenLG();
  NotSoRandom notSoRandom = new NotSoRandom();
  YTDislikeShield ytDislikeShield = new YTDislikeShield();
  GrapheneAeroGel grapheneAeroGel = new GrapheneAeroGel();
  
  //Current Weapon storage
  String weapon;
  Double weaponMultiplier;
  String armour;
  Double armourReducer;

  //Found in Chest storage
  String foundWeapon;
  Double foundWeaponMultiplier;
  String foundArmour;
  Double foundArmourReducer;


  /*This method prints the results of a chest drop. Returns nothing.*/
  public void chestResults(Images img) throws InterruptedException{
    img.setImage("ImageFiles//unopenedChest.png");
    System.out.println("");
    System.out.println("Wandering through the darkness of the Kwuest Dungeon, something catches your eye in a parallel corridor.");
    TimeUnit.MILLISECONDS.sleep(2000);
    System.out.println("");
    System.out.println("Your Current Weapon is: " +Colours.GREEN_BRIGHT+weapon+Colours.RESET);
    System.out.println("");
    TimeUnit.MILLISECONDS.sleep(2000);
    System.out.println("Your Current Armour is: " + Colours.GREEN_BRIGHT+armour+Colours.RESET);
    System.out.println();
    TimeUnit.MILLISECONDS.sleep(2000);
    System.out.println(Colours.PURPLE_BRIGHT+"You open the chest..."+Colours.RESET);
    TimeUnit.MILLISECONDS.sleep(2000);
    System.out.println();
    genChest();
  }


  /*This method resets the necessary variables upon replay. Returns nothing.*/
  public void resetEquipment() {
    weapon = fist.name;
    weaponMultiplier = fist.damageMultiplier;
    armour = naked.name;
    armourReducer = naked.damageReducer;
  }


  /*This method generates the contents of a chest. Returns nothing.*/
  public void genChest() throws InterruptedException{
    boolean checkChest = true;

      int int_random = rand.nextInt(upperbound);

      //Randomize Chest Drop, 30% weapon & 70% armour
      if (int_random == 0) { //5% chance
        foundWeapon = gonzalezSword.name;
        foundWeaponMultiplier = gonzalezSword.damageMultiplier;
        autoEquipWeapon();
      } 
      else if (int_random == 1 || int_random == 2) { //10% chance
        foundWeapon = blockChain.name;
        foundWeaponMultiplier = blockChain.damageMultiplier;
        autoEquipWeapon();
      } 
      else if (int_random == 3 || int_random == 4 || int_random == 5) { //15% chance
        foundWeapon = duckySword.name;
        foundWeaponMultiplier = duckySword.damageMultiplier;
        autoEquipWeapon();
      } 
      else { //70% chance to recieve armour
        random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        switch (random_int){ //equal chance for each piece of armour
          case 1:
            foundArmour = prostheticAB.name;
            foundArmourReducer = prostheticAB.damageReducer;
              break;
          case 2:
            foundArmour = brokenLG.name;
            foundArmourReducer = brokenLG.damageReducer;
              break;
          case 3:
            foundArmour = notSoRandom.name;
            foundArmourReducer = notSoRandom.damageReducer;
              break;
          case 4:
            foundArmour = ytDislikeShield.name;
            foundArmourReducer = ytDislikeShield.damageReducer;
              break;
          case 5:
            foundArmour = grapheneAeroGel.name;
            foundArmourReducer = grapheneAeroGel.damageReducer;
              break;
        }//end of switch
        autoEquipArmour();
      }
    }//end of genChest


  /*This method equips compares the current armour to the one found and equips the best one. Returns nothing.*/
  public void autoEquipArmour()throws InterruptedException{
    TimeUnit.MILLISECONDS.sleep(2000);
    System.out.println("You've found "+Colours.GREEN_BRIGHT+foundArmour+Colours.RESET+"!");
    TimeUnit.MILLISECONDS.sleep(2000);
    System.out.println(); 
    if(armour.equalsIgnoreCase(foundArmour)){//If your armour is the same as what you found
      System.out.println("You notice "+Colours.GREEN_BRIGHT+foundArmour+Colours.RESET+ " is the same as your current armour. You leave it.");
    }
    else if(foundArmourReducer < armourReducer){//If your armour is worse than what you found
      System.out.println("You discover that "+Colours.GREEN_BRIGHT+foundArmour+Colours.RESET+" is more protective than "+Colours.GREEN_BRIGHT+armour+Colours.RESET+". You equip it.");
      armour = foundArmour;
      armourReducer = foundArmourReducer;
    }
    else{//If your armour is better of what you found
      System.out.println("You realize that "+Colours.GREEN_BRIGHT+foundArmour+Colours.RESET+" is flimsier than "+Colours.GREEN_BRIGHT+armour+Colours.RESET+". You leave it.");
    }
  }


  /*This method equips compares the current weapon to the one found and equips the best one. Returns nothing.*/
  public void autoEquipWeapon()throws InterruptedException{
    TimeUnit.MILLISECONDS.sleep(2000);
    System.out.println("You've found "+Colours.GREEN_BRIGHT+foundWeapon+Colours.RESET+"!");
    TimeUnit.MILLISECONDS.sleep(2000);
    System.out.println();
    if(weapon.equalsIgnoreCase(foundWeapon)){//If your weapon is the same as what you found
      System.out.println("You notice "+Colours.GREEN_BRIGHT+foundWeapon+Colours.RESET+ " is the same as your current sword. You leave it.");
      TimeUnit.MILLISECONDS.sleep(2000);
    }
    else if(foundWeaponMultiplier > weaponMultiplier){//If your weapon is the worse than what you found
      System.out.println("You discover that "+Colours.GREEN_BRIGHT+foundWeapon+Colours.RESET+" is sharper than "+Colours.GREEN_BRIGHT+weapon+Colours.RESET+". You equip it.");
      TimeUnit.MILLISECONDS.sleep(2000);
      weapon = foundWeapon;
      weaponMultiplier = foundWeaponMultiplier;
    }
    else{//If your weapon is better than what you found
      System.out.println("You realize that "+Colours.GREEN_BRIGHT+foundWeapon+Colours.RESET+" is duller than "+Colours.GREEN_BRIGHT+weapon+Colours.RESET+". You leave it.");
      TimeUnit.MILLISECONDS.sleep(2000);
    }
  }
}