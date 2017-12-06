package anthill.model.prey;

import java.awt.Point;
import java.util.Date;

import anthill.iface.ObserverWorld;

public class PreyBig extends Prey implements ObserverWorld {
  public Double preyWeight;
  public Boolean isHunted;
  public Date dateDead;
  public Point preyPosition;
  
  /**
   * Prey constructor.
   */
  public PreyBig() {
    this.preyWeight = 180.0;
    this.isHunted = false;
    this.dateDead = null;
    this.preyPosition = new Point();
  }

  @Override
  public Double getWeight() {
    return this.preyWeight;
  }
  
  @Override
  public Point getPosition() {
    return this.preyPosition;
  }
  
  @Override
  public void setHunted() {
    this.isHunted = true;
  }

  @Override
  public void updatePosition(Point p) {
    this.preyPosition = p;    
  }

  
}
