package anthill.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import anthill.model.prey.Prey;
import java.awt.Point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TestPrey {
  
  Prey prey;
  
  @BeforeEach
  void setUp() throws Exception {
    prey = new Prey();
  }

  @Test
  void test() {
    assertTrue(prey.getWeight() != 0.0);
    Point p = new Point(0,0);
    assertFalse(prey.preyPosition.equals(p));
    assertTrue(prey.isHunted == false);
    prey.setHunted();
    assertTrue(prey.isHunted == true);
  }

}
