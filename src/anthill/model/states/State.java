package anthill.model.states;

import anthill.model.roles.Role;

public abstract class State {
  public abstract String getState();
  
  public abstract Role getRole();
}
