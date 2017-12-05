package anthill.model.roles;

import anthill.model.Ant;
import anthill.model.Anthill;
import java.awt.Point;

public class Queen extends Role {
  boolean isReign;
  boolean isPregnant;
  
  public Queen() {
    isReign = true;
    isPregnant = true;
  }
  
  /**
   * The Queen create an egg.
   * @return Egg an offspring
   */
  public Ant createEgg() {
    return new Ant();
  }
  
  public Anthill createAnthill(Ant a) {
    return new Anthill(a);
  }

  @Override
  public void move() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public Point getPosition() {
    // TODO Auto-generated method stub
    return null;
  }
}
