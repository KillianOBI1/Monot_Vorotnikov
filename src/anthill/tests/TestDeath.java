package anthill.tests;

import anthill.model.Ant;
import anthill.model.Anthill;
import anthill.model.roles.Queen;
import anthill.model.states.Adult;

import org.junit.jupiter.api.Test;

class TestDeath {

  @Test
  void test() {
    Ant queen = new Ant();
    queen.state = new Adult(new Queen());
    Anthill ah = queen.getState().getRole().ifQueen(queen).createAnthill(queen);
    for (int i = 0 ; i < 10 ; i++) {
      Ant a = queen.getState().getRole().ifQueen(queen).createEgg(ah);
      ah.listAnt.add(a);
      ah.setEgg(1);
    }
    System.out.println(ah.listAnt.size());

    for (Ant e :ah.listAnt) {
      System.out.println(e.getDateEnd() + " " + e.getAntId());
    }
    
  }

}
