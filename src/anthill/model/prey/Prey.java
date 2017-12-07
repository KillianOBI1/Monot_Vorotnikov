package anthill.model.prey;

import anthill.iface.ObservableWorld;
import anthill.view.World;

import java.awt.Point;
import java.util.Date;
import java.util.Random;

/**
 * Classe qui utlise le concept de proie.
 * @author Monot_Vorotnikov
 *
 */

public class Prey extends PreyA implements ObservableWorld {
  public Double preyWeight;
  public Boolean isHunted; /*Chassé ou non chassé*/
  public Date dateDead; /*Quand elle est morte*/
  public Point preyPosition; 
  private World wo;/*Le monde dans lequel elle évolue*/
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
    /*Elle enregistre son observateur*/
    wo = w;
  }

  @Override
  public void notifyToWorld() {
    wo.updatePrey(this.preyPosition);
  }
  
}
