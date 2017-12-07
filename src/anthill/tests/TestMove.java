package anthill.tests;

import anthill.model.Ant;
import anthill.model.Anthill;
import anthill.model.roles.Queen;
import anthill.model.roles.Worker;
import anthill.model.states.Adult;

import java.awt.Point;
import java.util.Calendar;
import org.junit.jupiter.api.Test;

class TestMove {

  @Test
  void test() {
    Ant queen = new Ant();
    queen.state = new Adult(new Queen());
    Anthill ah = new Anthill(queen);

    Ant a = queen.getState().getRole().ifQueen(queen).createEgg(ah);
    ah.listAnt.add(a);
    ah.setEgg(1);
        
    Calendar cal = Calendar.getInstance();
    cal.set(2017, 10, 05);
    System.out.println(cal.getTime());
    a.setDateStart(cal.getTime());

    a.notifyToObserverEvol(ah);
    a.notifyToObserverEvol(ah);
    a.notifyToObserverEvol(ah);
    
    Worker worker1 = (Worker) ah.listAnt.get(1).getState().getRole();
    Point p = worker1.getPosition();
    System.out.println(p);
    
    worker1.move();
    System.out.println(worker1.getPosition());
  
  }

}
