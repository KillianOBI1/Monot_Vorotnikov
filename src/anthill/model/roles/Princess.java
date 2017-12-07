package anthill.model.roles;

import java.awt.Point;

/**
 * Cette classe est un role concret. Elle défini la princesse individu sexé femelle.
 * @author Monot_Vorotnikov
 *
 */
public class Princess extends Role {
  boolean  isEmbryonate;/*Si elle est fécondé ou pas*/
  
  public Princess(Point p) {
    isEmbryonate = false;
    position = p;
  }
  
  public void fly() {
    
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
