package anthill.tests;

import anthill.model.Ant;

import anthill.model.Anthill;
import anthill.model.roles.Queen;
import anthill.model.states.Adult;
import anthill.model.states.State;
import anthill.observer.Observer;
import java.util.Calendar;

public class TestAnt {
  
  /**
   * Test the queen.
   * @param args arg
   */
  public static void main(String... args) {
    Ant queen = new Ant();
    System.out.println(queen.getState());
    System.out.println(queen.getStateString());
    queen.state = new Adult(new Queen());

    Anthill ah = queen.getState().getRole().ifQueen(queen).createAnthill(queen);
    Ant a = queen.getState().getRole().ifQueen(queen).createEgg(ah);
    ah.listAnt.add(a);
    Calendar cal = Calendar.getInstance();
    cal.set(2017, 10, 05);
    System.out.println(cal.getTime());
    
    Observer o = new Observer();
    
    a.setDateStart(cal.getTime());
    a.notifyToObserverEvol(o, ah);
    a.notifyToObserverEvol(o, ah);
    a.notifyToObserverEvol(o, ah);
    System.out.println(a.getState().getRole());
    
    State neW = new Adult(new Queen());
    System.out.println(neW.getRole().getClass().getSimpleName());
    queen.getState().getRole().ifQueen(queen);
    System.out.println(a.getWeight());
  }
}