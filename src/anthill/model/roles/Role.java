package anthill.model.roles;

import anthill.model.Ant;

public abstract class Role {
  public abstract void move();
  public Queen ifQueen(Ant a) {
    System.out.println(a.getState().getRole().getClass().getSimpleName());
    if(a.getState().getRole().getClass().getSimpleName().equals("Queen")) {
      System.out.println("Hail the queen");
      return (Queen) a.state.getRole();
    }
    return null;
  }
  
  public Worker ifWorker(Ant a) {
    if(a.getState().getRole().getClass().getSimpleName().equals("Worker")) {
      return (Worker) a.state.getRole();
    }
    return null;
  }
  
  public Soldier ifSoldier(Ant a) {
    if(a.getState().getRole().getClass().getSimpleName().equals("Soldier")) {
      return (Soldier) a.state.getRole();
    }
    return null;
  }
  
  public Prince ifPrince(Ant a) {
    if(a.getState().getRole().getClass().getSimpleName().equals("Prince")) {
      return (Prince) a.state.getRole();
    }
    return null;
  }
  
  public Princess ifPrincess(Ant a) {
    if(a.getState().getRole().getClass().getSimpleName().equals("Princess")) {
      return (Princess) a.state.getRole();
    }
    return null;
  }
}
