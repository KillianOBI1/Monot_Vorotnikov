package anthill.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import anthill.model.Ant;
import anthill.model.Anthill;
import anthill.model.roles.Queen;
import anthill.model.states.Adult;
import anthill.observer.Observer;

class TestDeath {

  @Test
  void test() {
    Ant queen = new Ant();
    queen.state = new Adult(new Queen());
    Anthill ah = queen.getState().getRole().ifQueen(queen).createAnthill(queen);
    for (int i = 0 ; i < 100 ; i++) {
      Ant a = queen.getState().getRole().ifQueen(queen).createEgg();
      ah.listAnt.add(a);
      ah.setEgg();
    }
    System.out.println(ah.listAnt.size());
    Observer o = new Observer();
    for (Ant e :ah.listAnt) {
      System.out.println(e.getDateEnd() + " " + e.getAntId());
    }
  }

}
