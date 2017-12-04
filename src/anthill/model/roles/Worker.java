package anthill.model.roles;

import java.util.List;

import anthill.model.Ant;
import anthill.model.Prey;
import anthill.model.states.Chrysalis;
import anthill.model.states.Egg;

public class Worker extends Role {
  Double carry;
  
  public Worker() {
    super();
  }
  
  public void selfFeed(Ant a, double weight) {
    a.setFoodQtty(weight);
  }
  /**
   * Feed other Ant by id.
   * @param la List of ants
   * @param id id of the ant
   * @param weight food avaible for the ant
   */
  
  public void feedOther(List<Ant> la, int id, double weight) {
    Egg e = new Egg();
    Chrysalis c = new Chrysalis();
    if (!la.get(id).getState().equals(e) || !la.get(id).getState().equals(c)) {
      la.get(id).setFoodQtty(weight);
    }
  }
  
  public void clean() {
    //TODO
  }
  
  public void fight(Prey p) {
    //TODO
  }

  @Override
  public void move() {
    // TODO Auto-generated method stub
    
  }
}
