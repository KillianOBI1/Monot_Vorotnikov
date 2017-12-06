package anthill.model.prey;

import java.awt.Point;
import java.util.Date;

public class PreyBig extends Prey {
  public Double preyWeight;
  public Boolean isHunted;
  public Date dateDead;
  public Point preyPosition;
  
  /**
   * Prey constructor.
   */
  public PreyBig(Point p) {
    this.preyWeight = 60.0;
    this.isHunted = false;
    this.dateDead = null;
    this.preyPosition = p;
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

  
}
