package anthill.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import anthill.model.prey.Prey;
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
    System.out.println(prey.getWeight()/10);
    System.out.println(prey.getPosition());
  }

}
