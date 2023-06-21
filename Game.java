/*Author: Alessia Ruberto
 Purpose: This class runs the overall game by putting together the different classes. Also allows for replay functionality.
 Inherits from: none.
 */  

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game{
  Board board = new Board();
  Chests chest = new Chests();
  Combat combat = new Combat();
  Images img = new Images();
  Menu menu = new Menu(img);
  Movement movement = new Movement();
  Scanner in = new Scanner(System.in);

  
  /*Constructor, runs the entire game.*/
  public Game()throws InterruptedException{
    String playAgain="yes";
    menu.displayStartupMessage();

    //Overall game loop
    while(playAgain.equalsIgnoreCase("yes")){
      boolean gameOver=false;

      //Set/reset variables for replay functionality
      movement.setInitialPosition();
      chest.resetEquipment();
      board.eventPlacement();

      //Loop movement around board
      while(gameOver==false){
        gameOver=board.boardDisplay(img, movement, chest, combat);
        if(gameOver==false){
        movement.movePlayer();
        }
      }
      gameOver=false; //reset for replay
      System.out.println();
      System.out.println();

    //Prompt for replay
    boolean retryEntry = true;
    while(retryEntry==true){ //lots of error proofing, loop until correct
      System.out.print(Colours.CYAN+"Would you like to play again?"+Colours.RESET+" (yes or no): ");
        try{ 
          playAgain=in.nextLine();
          if (playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("no")){ //correct input, exit loop
            retryEntry=false;
            break;
          }
          else{ //incorrect input but no real error
            System.out.println(Colours.RED+"Error!"+Colours.RESET+" Please enter an option! (yes or no): ");
          }
        }
        catch(Exception e){ //make sure no errors occur during input
          System.out.println(Colours.RED+"Error!"+Colours.RESET+" Please enter a string!");
          in.next(); //prevents infite catch loop
        }
      }//end of while loop
    }//end of game loop
    
    //end of program message
    img.setImage("ImageFiles//splashscreengame.png");
    System.out.println();
    System.out.println("Thanks for playing Kwuest Quest!");
    System.out.println();
    System.out.println(Colours.PURPLE_BRIGHT+"END"+Colours.RESET);
  }//end of runGame
  
}//end of Game class