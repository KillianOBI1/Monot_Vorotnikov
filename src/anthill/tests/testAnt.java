package anthill.tests;

import anthill.model.Ant;
import anthill.model.roles.Queen;
import anthill.model.states.Adult;
import anthill.model.states.State;

public class testAnt {
  public static void main(String... args) {
    Ant newAnt = new Ant();
    System.out.println(newAnt.getState());
    System.out.println(newAnt.getStateString());
    State s = newAnt.getState();
    System.out.println(s);
    State neW = new Adult(new Queen());
  }
}
