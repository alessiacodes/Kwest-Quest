/*Author: Alessia Ruberto
 Purpose: This class displays the menu and allows for interactions within the it.
 Inherits from: none.
 */  
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
class Menu{
  Scanner in = new Scanner(System.in);
  Images img;

  /*Constructor*/
  public Menu(Images img1){
    img=img1; //set image object to allow this class to display them.
  }


  /*This method displays the message at startup and allows the user to choose between starting the game and viewing instructions.*/
  public void displayStartupMessage()throws InterruptedException{
    //Begininng Message
    img.setImage("ImageFiles//splashscreengame.png");
    System.out.println();
    System.out.println(Colours.PURPLE_BRIGHT+"WELCOME TO KWUEST QUEST!"+Colours.RESET); 
      System.out.println("");

    System.out.println("Please "+Colours.GREEN_BRIGHT+"resize Repl window "+Colours.RESET+"to fit the entire frame for the best viewing experience. If you're having difficulty fitting the console and screen, "+Colours.GREEN_BRIGHT+"press F11."+Colours.RESET);
      System.out.println();
      pressEnter(true);
     
      System.out.println("  / \\               / \\\n" +
" /   \\             /   \\\n" +
"(_____)           (_____)\n" +
" |   |  _   _   _  |   |\n" +
" | O |_| |_| |_| |_| O |\n" +
" |-  |          _  | - |\n" +
" |   |   - _^_     |   |\n" +
" |  _|    //|\\\\  - |   |\n" +
" |   |   ///|\\\\\\   |  -|\n" +
" |-  |_  |||||||   |   |\n" +
" |   |   |||||||   |-  |\n" +
" |___|___|||||||___|___|\n" +
"         (      (\n" +
"          \\      \\\n" +
"           )      )\n" +
"           |      |\n" +
"           (      (\n" +
"            \\      \\");
  
    System.out.println("Our journey begins in the fallen kingdom of Kwuest.");
    System.out.println("");
  
        TimeUnit.MILLISECONDS.sleep(4000);

    System.out.println("One singular strong warrior is destined and fated to seek out and discover the secret of how the mighty kingdom had fallen.");
    System.out.println("");
   
        TimeUnit.MILLISECONDS.sleep(4500);
      
    System.out.println("Equipped with nothing but his fists and pride, he shall venture down into the dungeons below, finding the dark secrets that lie within.");
    System.out.println("");
    
        TimeUnit.MILLISECONDS.sleep(4000);
 
    //Prompt begin game or instructions
    System.out.println("Would you like to...");
    System.out.println("  1. Begin game");
    System.out.println("  2. See instructions");
      System.out.println();
    boolean retryEntry = true;
    int userInput=0;
    while(retryEntry==true){ //lots of error proofing, loop until correct
      System.out.print(Colours.CYAN+"Your choice"+Colours.RESET+" (1 or 2): ");
        try{ 
          System.out.println();
          userInput=in.nextInt();
          if (userInput==1 || userInput ==2){ //correct input, exit loop
            retryEntry=false;
          }
          else{ //incorrect input but still int
            System.out.println(Colours.RED+"Error!"+Colours.RESET+" Please enter an option! (1 or 2): ");
          }
        }
        catch(Exception e){ //make sure no errors occur during input
          System.out.println(Colours.RED+"Error!"+Colours.RESET+" Please enter an interger!");
          in.next(); //prevents infite catch loop
        }
    }//end of while loop

    //Handle user input
    switch (userInput){
      case 1:
        break;
      case 2:
        displayInstructions();
          break;
    }
  }//end of displayStartupMessage


  /*This method displays the instructions when called*/
  public void displayInstructions()throws InterruptedException{
    img.setImage("ImageFiles//howtoplay.png");
      System.out.println();
    pressEnter(false);
    pressEnter(true);
  }
  

  /*This method allows user to move forward through prompts by presseing ENTER. Returns nothing.*/
  public void pressEnter(boolean dispMessage){
  
    if(dispMessage==true){
      System.out.println(Colours.CYAN+"Press ENTER to continue..."+Colours.RESET);
    }
    boolean valid=false;
    String readLine=in.nextLine();
    while(valid==false){
      if(readLine.equals("")){
        valid=true;
      }
      else{
        valid=false;
        System.out.println(Colours.RED+"Please press enter to continue: "+Colours.RESET);
          readLine=in.nextLine();
      }
    }
  }//pressEnter end

}//end of Menu class