package anthill.model.prey;

import java.awt.Point;

public abstract class Prey {
    
  public abstract Double getWeight();
  
  public abstract void setHunted();
  
  public abstract Point getPosition();
}
