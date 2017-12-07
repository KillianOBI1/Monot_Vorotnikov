package anthill.model.states;

import anthill.model.roles.Role;

/**
 * Classe Abstraite. Elle les 4 états possible d'une fourmi.
 * @author Mont_Vorotnikov
 *
 */
public abstract class State {
  public abstract String getState();
  
  public abstract Role getRole();
}
