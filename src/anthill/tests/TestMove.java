package anthill.tests;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import anthill.model.Ant;
import anthill.model.Anthill;
import anthill.model.roles.Queen;
import anthill.model.roles.Worker;
import anthill.model.states.Adult;
import anthill.observer.Observer;

class TestMove {

  @Test
  void test() {
    Ant queen = new Ant();
    queen.state = new Adult(new Queen());
    Anthill ah = new Anthill(queen);

    Ant a = queen.getState().getRole().ifQueen(queen).createEgg();
    ah.listAnt.add(a);
    ah.setEgg();
      
    System.out.println(ah.listAnt.size());
        
    Calendar cal = Calendar.getInstance();
    cal.set(2017, 10, 05);
    System.out.println(cal.getTime());
    a.setDateStart(cal.getTime());
    Observer o = new Observer();
    a.notifyToObserverEvol(o, ah);
    a.notifyToObserverEvol(o, ah);
    a.notifyToObserverEvol(o, ah);
    for (Ant e :ah.listAnt) {
      System.out.println(e.getDateEnd() + " " + e.getAntId() + " " + e.getState().getRole());
    }
    
    Worker worker1 = (Worker) ah.listAnt.get(1).getState().getRole();
    System.out.println(worker1.getPosition());
    worker1.move();
    System.out.println(worker1.getPosition());
  }

}
