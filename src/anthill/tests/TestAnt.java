package anthill.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import anthill.model.Ant;
import anthill.model.Anthill;
import anthill.model.roles.Queen;
import anthill.model.states.Adult;
import anthill.model.states.Egg;
import anthill.model.states.State;

public class TestAnt {
  
  Ant ant;
    
  @BeforeEach
  void setUp() throws Exception {
    ant = new Ant();
  }
  
  @Test
  void testAnt() {
    assertTrue(ant != null);
    assertTrue(ant.getState() instanceof Egg);
    assertFalse(ant.getState() instanceof Adult);
    
    ant.state = new Adult(new Queen());
    assertTrue(ant.getState() instanceof Adult);
    
//    Anthill ah = queen.getState().getRole().ifQueen(queen).createAnthill(queen);
//    Ant a = queen.getState().getRole().ifQueen(queen).createEgg(ah);
//    ah.listAnt.add(a);
//    Calendar cal = Calendar.getInstance();
//    cal.set(2017, 10, 05);
//    System.out.println(cal.getTime());
//        
//    a.setDateStart(cal.getTime());
//    a.notifyToObserverEvol(ah);
//    a.notifyToObserverEvol(ah);
//    a.notifyToObserverEvol(ah);
//    System.out.println(a.getState().getRole());
//    
//    State neW = new Adult(new Queen());
//    System.out.println(neW.getRole().getClass().getSimpleName());
//    queen.getState().getRole().ifQueen(queen);
//    System.out.println(a.getWeight());
  }
  
  @Test
  void testGetAntId() {   
    Ant newBye = new Ant();
    assertTrue(ant.getAntId() != newBye.getAntId());
    assertTrue(ant.getAntId() == ant.getAntId());
  }
  
  @Test
  void testAntWeight() {
    assertTrue(ant.getWeight() == 1.0);
    ant.setWeight(2.5);
    assertFalse(ant.getWeight() == 1.0);
    assertTrue(ant.getWeight() == 2.5);
  }
  
  @Test
  void testAntFood() {
    assertTrue(ant.getFoodQtty() == 0.0);
    ant.setFoodQtty(2.2);
    assertFalse(ant.getFoodQtty() == 0.0);
    assertTrue(ant.getFoodQtty() == 2.2);
  }
  
  @Test
  void testAntDates() {
    Calendar cal = Calendar.getInstance();
    cal.set(2017, 10, 05);
     
    ant.setDateStart(cal.getTime());
    assertTrue(ant.getDateStart().equals(cal.getTime()));
    
    Calendar cal2 = Calendar.getInstance();
    cal2.set(2018, 10, 05);

    assertFalse(ant.getDateStart().equals(cal2.getTime()));    
    assertTrue(ant.getDateEnd().after(ant.getDateStart()));
  }
  
}