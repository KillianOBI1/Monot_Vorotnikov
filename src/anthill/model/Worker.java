package anthill.model;

import java.util.List;

public class Worker extends Role {
  Double carry;
  
  public Worker() {
    super();
  }
  
  void selfFeed(Ant a, double weight) {
    a.setFoodQtty(weight);
  }
  void feedOther(List<Ant> la, int id, double weight) {
    Egg e = new Egg();
    Chrysalis c = new Chrysalis();
    if(!la.get(id).getState().getClass().equals(e.getClass())||!la.get(id).getState().getClass().equals(c.getClass())) {
      la.get(id).setFoodQtty(weight);
    }
  }
  
  void clean() {
    //TODO
  }
  
  void fight(Prey p) {
    //TODO
  }

  @Override
  public void move() {
    // TODO Auto-generated method stub
    
  }
}
