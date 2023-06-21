/*Author: Alessia Ruberto & Marco Capuano
 Purpose: This class defines a weapon object by setting the weapon name and damage multiplier.
 Inherits from: none.
 */  
public class Weapons{

  String name;
  double damageMultiplier;

  /*Constructor*/
  public Weapons(String name1, double damageMultiplier1){
    name = name1;
    damageMultiplier = damageMultiplier1;
  }
}//end of Weapons class


/*Author: Alessia Ruberto and Marco Capuano
 Purpose: The following subclasses define stats for their respective weapon.
 Inherits from: Weapons
 */  
class Fists extends Weapons{
  /*Constructor*/
  public Fists(){
    super("fists", 1);
  }
}

class DuckySword extends Weapons{
  /*Constructor*/
  public DuckySword(){
    super("the Ducky Sword", 1.2);
  }
}

class BlockChain extends Weapons{
  /*Constructor*/
  public BlockChain(){
    super("the Block Chain", 1.3);
  }
}

class GonzalezSword extends Weapons{
  public GonzalezSword(){
    /*Constructor*/
    super("the Gonzalez Sword", 1.5);
  }
}