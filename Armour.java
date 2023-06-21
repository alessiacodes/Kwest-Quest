/*Author: Alessia Ruberto & Marco Capuano
 Purpose: This class defines an armour object by setting the armour name and damage reducer.
 Inherits from: none.
 */  
public class Armour{

  String name;
  double damageReducer;

  /*Constructor*/
  public Armour(String name1, double damageReducer1){
    name = name1;
    damageReducer = damageReducer1;
  }
}//end of Armour class


/*Author: Alessia Ruberto and Marco Capuano
 Purpose: The following subclasses define stats for their respective piece of armour.
 Inherits from: Armour
 */  
class Naked extends Armour{
  /*Constructor*/
  public Naked(){
    super("being naked", 1);
  }

}


class ProstheticAB extends Armour{
  /*Constructor*/
  public ProstheticAB(){
    super("the Prosthetic Arm Brace", 0.95);
  }

}


class BrokenLG extends Armour{
  /*Constructor*/
  public BrokenLG(){
    super("the Broken LG Wing Leggings", 0.90);
  }

}


class NotSoRandom extends Armour{
  /*Constructor*/
  public NotSoRandom(){
    super("the Not So Random Helmet", 0.85);
  }

}


class YTDislikeShield extends Armour{
  /*Constructor*/
  public YTDislikeShield(){
    super("the YouTube Dislike Shield", 0.8);
  }

}

class GrapheneAeroGel extends Armour{
  /*Constructor*/
  public GrapheneAeroGel(){
    super("the Graphene Aerogel Chestplate", 0.75);
  }

}