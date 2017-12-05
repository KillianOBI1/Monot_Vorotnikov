package anthill.model.roles;

import anthill.model.Ant;
import anthill.model.Anthill;
import anthill.model.Prey;
import anthill.model.states.Chrysalis;
import anthill.model.states.Egg;

import java.util.List;

public class Worker extends Role {
  Prey carry;
  
  public Worker() {
    super();
  }
  
  public void selfFeed(Ant a) {
    a.setFoodQtty(this.carry.weight);
  }
  /**
   * Feed other Ant by id.
   * @param la List of ants
   * @param id id of the ant
   */
  
  public void feedOther(List<Ant> la, int id) {
    Egg e = new Egg();
    Chrysalis c = new Chrysalis();
    if (!la.get(id).getState().equals(e) || !la.get(id).getState().equals(c)) {
      if (la.get(id).differenceBetweenTodayMeal() < 1) {
        la.get(id).setFoodQtty(this.carry.weight);
      }
      
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
  
  public void depose(Anthill ah) {
    ah.meat.add(carry);
  }
  
  public void getFood(Anthill ah) {
    carry = ah.meat.get(ah.meat.size() - 1);
  }
}
