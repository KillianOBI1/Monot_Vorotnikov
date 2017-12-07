package anthill.tests;

import static org.junit.Assert.assertTrue;

import anthill.model.Ant;
import anthill.model.Anthill;
import anthill.model.roles.Queen;
import anthill.model.states.Adult;
import anthill.model.states.Egg;
import anthill.model.states.State;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestAnt {
  
  Ant queen;
  
  @BeforeEach
  void setUp() throws Exception {
    queen = new Ant();
  }
  
  @Test
  void test() {
//    assertTrue(queen.getState().equals(new Egg()));
    System.out.println(queen.getState().equals(new Egg()));
    System.out.println(queen.getStateString());
    queen.state = new Adult(new Queen());

    Anthill ah = queen.getState().getRole().ifQueen(queen).createAnthill(queen);
    Ant a = queen.getState().getRole().ifQueen(queen).createEgg(ah);
    ah.listAnt.add(a);
    Calendar cal = Calendar.getInstance();
    cal.set(2017, 10, 05);
    System.out.println(cal.getTime());
        
    a.setDateStart(cal.getTime());
    a.notifyToObserverEvol(ah);
    a.notifyToObserverEvol(ah);
    a.notifyToObserverEvol(ah);
    System.out.println(a.getState().getRole());
    
    State neW = new Adult(new Queen());
    System.out.println(neW.getRole().getClass().getSimpleName());
    queen.getState().getRole().ifQueen(queen);
    System.out.println(a.getWeight());
  }
}