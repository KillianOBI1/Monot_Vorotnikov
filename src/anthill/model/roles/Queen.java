package anthill.model.roles;

import anthill.model.Ant;
import anthill.model.Anthill;
import java.awt.Point;
import java.util.Random;

public class Queen extends Role {
  boolean isReign;
  boolean isPregnant;
  
  /**
   * Constructeur de la queen.
   */
  public Queen() {
    isReign = true;
    isPregnant = true;
    int min = 520;
    int max = 575;
    Random rand = new Random();
    int x = (rand.nextInt((max + 1) - 0) + 0) % 5 * 100 + 5;
    int y = (rand.nextInt((min + 1) - 0) + 0) % 5 * 100 + 5;
    position = new Point(x,y);
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

  @Override
  public Point getPosition() {
    return this.position;
  }
}
