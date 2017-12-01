package anthill.tests;

import anthill.model.Ant;

public class testAnt {
  public static void main(String... args) {
    Ant newAnt = new Ant();
    System.out.println(newAnt.getState());
    System.out.println(newAnt.getStateString());
  }
}
