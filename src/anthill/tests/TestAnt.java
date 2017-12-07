package anthill.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import anthill.model.Ant;
import anthill.model.roles.Queen;
import anthill.model.states.Adult;
import anthill.model.states.Egg;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    assertTrue(ant.getStateString().equals("Adult"));
    assertFalse(ant.getStateString().equals("Egg"));
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