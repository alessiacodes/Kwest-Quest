/*Author: Alessia Ruberto
 Purpose: This class is responsible for displaying pop-up images by sending the path to the argument of setImage.
 Source: https://www.youtube.com/watch?v=Zh_CJxYi0wU
 Inherits from: none.
 */  
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Images extends JFrame{

  JPanel panel = new JPanel();
  JLabel label = new JLabel();

  /*Constructor, sets up window on startup*/
  public Images(){
    setTitle("Kwuest Quest");
    setVisible(true);
    setSize(640,390);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }


  /*This method is used to set/update the image in the window. Send image path as string in the argument.*/
  public void setImage(String path){
    label.setIcon(new ImageIcon(path));
    panel.add(label, "push, align center");
    add(panel);
    validate();
  }

}//end of Image class