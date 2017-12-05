package anthill.model.roles;

import java.awt.Point;

public class Princess extends Role {
  boolean  isEmbryonate;
  
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
