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
    la.get(id).setFoodQtty(weight);
  }
  
  void clean() {
    //TODO
  }
  
  void fight(Prey p) {
    //TODO
  }
}
