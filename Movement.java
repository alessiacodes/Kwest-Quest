/*Author: Alessia Ruberto
 Purpose: This class handles the players movement. It is used everytime an input from the player is needed on where they'd like to move.
 Inherits from: none.
 */  

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Movement{
  private int playerPositionX;
  private int playerPositionY;
  Scanner in = new Scanner(System.in);

  /*Constructor*/
  public Movement(){
    setInitialPosition();
  }//end of Constructor


  /*Accessor method; returns playerPositionX.*/
  public int getPlayerPositionX(){
    return playerPositionX;
  }

  /*Accessor method; returns playerPositionY.*/
  public int getPlayerPositionY(){
    return playerPositionY;
  }
  

  /*This method is used to initially set the players position to the middle of the board (3,3). Also used to reset the player position if needed. Returns nothing.*/
  public void setInitialPosition(){
    playerPositionX=3; 
    playerPositionY=3;
  }


  /*This method allows the user to input where they'd like to move and checks conditions to make sure the move is valid. Then, it updates the appropriate x/y value and displays their new location.*/
  public void movePlayer()throws InterruptedException{
    boolean retryEntry = true;
    String movementChoice;

    while(retryEntry==true){ //lots of error proofing, loop until correct
      System.out.println();
      TimeUnit.MILLISECONDS.sleep(1000);
      System.out.print(Colours.CYAN+"Where would you like to move?"+Colours.RESET+"(w,a,s,d): "); 
        try{
          while(retryEntry==true){ //loop for logic errors
            movementChoice= in.nextLine();
              if(movementChoice.equalsIgnoreCase("w")&&checkHitBorder(movementChoice)==false||movementChoice.equalsIgnoreCase("a")&&checkHitBorder(movementChoice)==false||movementChoice.equalsIgnoreCase("s")&&checkHitBorder(movementChoice)==false||movementChoice.equalsIgnoreCase("d")&&checkHitBorder(movementChoice)==false){ //Correct entry + does not hit border
                System.out.println("Your current position is "+Colours.GREEN_BRIGHT+"("+playerPositionX+", "+playerPositionY+")"+Colours.RESET+".");
                  break;
              }
              else if(movementChoice.equalsIgnoreCase("w")&&checkHitBorder(movementChoice)==true||movementChoice.equalsIgnoreCase("a")&&checkHitBorder(movementChoice)==true||movementChoice.equalsIgnoreCase("s")&&checkHitBorder(movementChoice)==true||movementChoice.equalsIgnoreCase("d")&&checkHitBorder(movementChoice)==true){ //Hits border
                System.out.print(Colours.RED+"Error! "+Colours.RESET+"This area is restricted. Please move a different direction (w,a,s,d): ");
              } 
              else{ //Incorrect entry
                System.out.print(Colours.RED+"Error! "+Colours.RESET+"Please enter one of the characters listed!(w,a,s,d): ");
              }
          }
            break;
        }
        catch(Exception e){ //make sure no errors occur during input
          System.out.println(Colours.RED+"Error!"+Colours.RESET+" Please enter a String!");
          in.next(); //prevents infite catch loop
        }
    }//end of big while loop
  }//end of movePlayer 


  /*This method takes the users movement choice and checks if it will hit a border on the 5x5 map (ie. can't go to 0 or above 5). If it does not hit the border, it will update the appropriate position variable. Returns boolean value of whether the player hits the border (true) or not (false).*/
  public boolean checkHitBorder(String movementChoice){
    boolean hitBorder;
    if(movementChoice.equalsIgnoreCase("s")){ //down
      if((playerPositionY+1)>5){
        hitBorder=true;
      }
      else{
        playerPositionY+=1;
        hitBorder=false;
      }
    }
    else if(movementChoice.equalsIgnoreCase("a")){ //left
      if((playerPositionX-1)<1){
        hitBorder=true;
      }
      else{
        playerPositionX-=1;
        hitBorder=false;
      }
    }
    else if(movementChoice.equalsIgnoreCase("w")){ //up
      if((playerPositionY-1)<1){
        hitBorder=true;
      }
      else{
        playerPositionY-=1;
        hitBorder=false;
      }
    }
    else{ //equals "d", right
      if((playerPositionX+1)>5){
        hitBorder=true;
      }
      else{
        playerPositionX+=1;
        hitBorder=false;
      }
    }
    return hitBorder;
  }//end of checkHitBorder

}//end of Movement class