package anthill.model;

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
  public Ant createEgg() {
    return new Ant();
  }
  
  public Anthill createAnthill() {
    return new Anthill(this);
  }
  
  @Override
  public void move() {
    // TODO Auto-generated method stub
    
  }
}
