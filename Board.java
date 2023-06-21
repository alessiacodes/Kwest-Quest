/*Author: Armand
 Purpose: This class sets up the board to be used in other classes and generates locations for the chest and the boss.
 Inherits from: none.
 */  
import java.util.Random; // import the Random class

class Board {
  String[][] board= new String[5][5]; //creates event board  array
  static Random r = new Random(); //creates new random class
  boolean gameOver;
  
  public Board(){
    eventPlacement();
   //boardDisplay();
  }

  /*Creates a board with the events*/
  public void eventPlacement(){
      int empty=0; //creates empty accumulator
      int chestCheck=0; // creates chest accumulator
      int bossCheck=0; // creates boss accumulator

      //loop assigns a value for each event board location
      for(int row=0; row< board.length; row++){
        for(int col=0; col < board[row].length; col++){
          boolean centerCheck = false;
          if (row==2 && col==2){
            centerCheck = true;
          }
          boolean check=false;
          while(check==false){ //loop to make sure a value ends up in an index
            int event = r.nextInt(25); //randomly generates the event to add to location
            if(event>=0 && event<20 && empty<20){ //if empty was generated
              check=true; //changes check to true to move on to next spot
              empty++; //adds to empty accumulator
              board[row][col]="";
            }
            else if(event>19 && event<24 && chestCheck<4 && centerCheck==false){ //if chest was generated
              check=true; //changes check to true to move on to next spot
              chestCheck++; //adds to chest accumulator
              board[row][col]="chest";
            }
            else if(event==24 && bossCheck<1 && centerCheck==false){ //if boss was generated
              check=true; //changes check to true to move on to next spot
              bossCheck++; //adds to boss accumulator
              board[row][col]="boss";
            }
          }
        }
      }
    }

    
    /*A method for printing where chests and bosses are, purely for testing. Returns nothing.*/
    public void printEventPlacement(){
      for(int row=0; row<board.length; row++){
        System.out.println();//space
        for(int col=0; col < board[row].length; col++){
          //Change formatting depending on what value is in the index
          if(board[row][col].equals("")){
            System.out.print("[ empty ]");
          }
          else if(board[row][col].equals("chest")||board[row][col].equals("")){
            System.out.print("[ chest ]");
          }
          else {
            System.out.print("[ boss! ]");
          }
        }
      }
    }
    

    /*This method displays and handles the board. It marks the user's current position and runs methods related to the boss and chest when they're landed on. Returns nothing.*/
    public boolean boardDisplay(Images img, Movement move, Chests chest, Combat combat)throws InterruptedException{
      
      boolean foundChest=false;
      boolean foundBoss=false;
      gameOver=false;

      for(int row=0; row<board.length; row++){
        System.out.println();//space
        for(int col=0; col < board[row].length; col++){
          img.setImage("ImageFiles//adventuring .png"); //set appropriate image
          if((move.getPlayerPositionX()-1)==col &&(move.getPlayerPositionY()-1)==row){  //if player is located here
            System.out.print(Colours.RED_BACKGROUND+"[   x   ]"+Colours.RESET); //print red tile
            if(board[row][col].equalsIgnoreCase("chest") && !"opened".equals(board[row][col])){ //check for chest
              foundChest = true;
              board[row][col]="opened";
            }
            else if (board[row][col].equalsIgnoreCase("boss")&& !"opened".equals(board[row][col])){ //check for boss
              foundBoss = true;
              board[row][col]="opened";
            }
          }
          else{  //no player here
            System.out.print(Colours.GREEN_BACKGROUND+"[       ]"+Colours.RESET);
          }
          
        }
     }//end of big for loop

    if (foundChest==true){
      System.out.println();
      System.out.println();
      System.out.println(Colours.PURPLE_BRIGHT+"You've found a chest!"+Colours.RESET);
      chest.chestResults(img);
    }
    else if (foundBoss==true){
      System.out.println();
      System.out.println();
      System.out.println(Colours.PURPLE_BRIGHT+"You've encountered the boss!"+Colours.RESET);
      combat.runCombat(chest, img);
      gameOver=true;
    }

    foundChest=false; //reset variables
    foundBoss=false;
    return gameOver;
  }
}