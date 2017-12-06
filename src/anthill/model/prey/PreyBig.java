package anthill.model.prey;

import java.awt.Point;
import java.util.Date;

import anthill.iface.ObservableWorld;
import anthill.view.World;

public class PreyBig extends Prey implements ObservableWorld {
  public Double preyWeight;
  public Boolean isHunted;
  public Date dateDead;
  public Point preyPosition;
  private World wo;
  
  /**
   * Prey constructor.
   */
  public PreyBig() {
    this.preyWeight = 180.0;
    this.isHunted = false;
    this.dateDead = null;
    this.preyPosition = new Point();
    this.wo = null;
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
  public void registerObserver(World w) {
    wo = w;
  }

  @Override
  public void notifyToWorld() {
    wo.updatePrey(this.preyPosition);
  }
  
}
