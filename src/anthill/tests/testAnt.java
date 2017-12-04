package anthill.tests;

import anthill.model.Ant;
import anthill.model.roles.Queen;
import anthill.model.states.Adult;
import anthill.model.states.State;

public class testAnt {
  
  public static void main(String... args) {

    Ant queen = new Ant();
    System.out.println(queen.getState());
    System.out.println(queen.getStateString());
    queen.state = new Adult(new Queen());
    State s = queen.getState();
    System.out.println(s);
    System.out.println(queen.getDateStart());
    System.out.println(queen.addDaysToBirthday(3));
    System.out.println(queen.addDaysToBirthday(13));
    System.out.println(queen.addDaysToBirthday(30));
    State neW = new Adult(new Queen());
    System.out.println(neW.getRole().getClass().getSimpleName());
    queen.getState().getRole().ifQueen(queen);
  }
}
