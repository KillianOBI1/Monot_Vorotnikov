package anthill.model.roles;

import anthill.model.Ant;

public class Prince extends Role {
  
  public Prince() {
    super();
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
}
