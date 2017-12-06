package anthill.tests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import anthill.model.Ant;
import anthill.model.Anthill;
import anthill.model.roles.Queen;
import anthill.model.states.Adult;
import anthill.observer.Observer;



class TestEvolution {

  @Test
  void test() {
    Ant queen = new Ant();
    
    queen.state = new Adult(new Queen());
    Anthill ah = queen.getState().getRole().ifQueen(queen).createAnthill(queen);
    for (int i = 0 ; i < 100 ; i++) {
      Ant a = queen.getState().getRole().ifQueen(queen).createEgg(ah);
      ah.listAnt.add(a);
      ah.setEgg(1);
    }
    System.out.println(ah.listAnt.size());
    Observer o = new Observer();
    for (Ant a : ah.listAnt) {
      o.updateEggToMaggot(ah,a.getAntId());
      o.updateMaggotToChrysalis(ah,a.getAntId());
      o.updateChrysalisToAdult(ah,a.getAntId());
      System.out.println(a.getAntId() + " " + a.getState().getRole().toString(a));
    }
    assertTrue(ah.getNbWorker() == 70);
    assertTrue(ah.getNbPrince() == 5);
    assertTrue(ah.getNbSoldier() == 20);
    assertTrue(ah.getNbPrincess() == 5);
    assertTrue((ah.getNbPrince() + ah.getNbPrincess() + ah.getNbSoldier() + ah.getNbWorker() + 1) == 101);
  }

}
