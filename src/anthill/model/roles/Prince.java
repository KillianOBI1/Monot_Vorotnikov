package anthill.model.roles;

import anthill.model.Ant;

import java.awt.Point;

/**
 * Classe qui utilise le concept de role. 
 * Cette classe représente l'individu sexé male.
 * @author yallay
 *
 */

public class Prince extends Role {
  
  public Prince(Point p) {
    super();
    position = p;
  }
  
  public void fly() {
    //TODO
  }
  
  /**
   * Allow the prince to embryonate the queen or the princess.
   * @param a the ant who will get pregnant
   */
  public void embryonate(Ant a) {
    if (a.getState().getRole().ifPrincess(a) != null) {
      a.getState().getRole().ifPrincess(a).isEmbryonate = true;
    } else if (a.getState().getRole().ifQueen(a) != null) {
      a.getState().getRole().ifQueen(a).isPregnant = true;
    }
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
