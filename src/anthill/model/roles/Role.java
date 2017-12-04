package anthill.model.roles;

import anthill.model.Ant;

public abstract class Role {
  public abstract void move();
  
  /**
   * Verify if the ant is a queen and makes the function role accessible or not.
   * @param a the ant
   * @return A queen or null
   */
  public Queen ifQueen(Ant a) {
    System.out.println(a.getState().getRole().getClass().getSimpleName());
    if (a.getState().getRole().getClass().getSimpleName().equals("Queen")) {
      System.out.println("Hail the queen");
      return (Queen) a.state.getRole();
    }
    return null;
  }
  
  /**
   * Verify if the ant is a worker and makes the function role accessible or not.
   * @param a the ant
   * @return A worker or null
   */
  public Worker ifWorker(Ant a) {
    if (a.getState().getRole().getClass().getSimpleName().equals("Worker")) {
      return (Worker) a.state.getRole();
    }
    return null;
  }
  
  /**
   * Verify if the ant is a soldier and makes the function role accessible or not.
   * @param a the ant
   * @return A soldier or null
   */
  public Soldier ifSoldier(Ant a) {
    if (a.getState().getRole().getClass().getSimpleName().equals("Soldier")) {
      return (Soldier) a.state.getRole();
    }
    return null;
  }
  
  /**
   * Verify if the ant is a prince and makes the function role accessible or not.
   * @param a the ant
   * @return A prince or null
   */
  public Prince ifPrince(Ant a) {
    if (a.getState().getRole().getClass().getSimpleName().equals("Prince")) {
      return (Prince) a.state.getRole();
    }
    return null;
  }
  
  /**
   * Verify if the ant is a princesss and makes the function role accessible or not.
   * @param a the ant
   * @return A prince or null
   */
  public Princess ifPrincess(Ant a) {
    if (a.getState().getRole().getClass().getSimpleName().equals("Princess")) {
      return (Princess) a.state.getRole();
    }
    return null;
  }
}
