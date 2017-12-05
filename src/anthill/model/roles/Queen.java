package anthill.model.roles;

import anthill.model.Ant;
import anthill.model.Anthill;
import sun.util.calendar.LocalGregorianCalendar.Date;

@SuppressWarnings("unused")
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
  public Ant createEgg(Anthill ah) {
    ah.setEgg(1);
    return new Ant();
  }
  
  public Anthill createAnthill(Ant a) {
    return new Anthill(a);
  }

  @Override
  public void move() {
    // TODO Auto-generated method stub
    
  }
}
