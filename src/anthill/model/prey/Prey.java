package anthill.model.prey;

import java.awt.Point;
import java.util.Date;
import java.util.Random;

import anthill.iface.ObservableWorld;
import anthill.view.World;

public class Prey extends PreyA implements ObservableWorld {
  public Double preyWeight;
  public Boolean isHunted;
  public Date dateDead;
  public Point preyPosition;
  private World wo;
  private Random rdm;
  
  /**
   * Prey constructor.
   */
  public Prey() {
    rdm = new Random();
    this.preyWeight = (double) rdm.nextInt(185);
    this.isHunted = false;
    this.dateDead = null;
    this.wo = null;
        
    int x = rdm.nextInt(595);
    int y = rdm.nextInt(595);
    x = (x - (x % 10)) + 5;
    y = (y - (y % 10)) + 5;
    this.preyPosition = new Point(x,y);
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
