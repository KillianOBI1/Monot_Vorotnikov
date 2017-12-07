package anthill.model.states;

import anthill.model.roles.Role;

/**
 * Classe Concrete de la classe State. Elle représente l'oeuf.
 * @author Monot_Vorotnikov
 *
 */

public class Egg extends State {
  String state;
  
  public Egg() {
    this.state = "Egg";
  }
  
  @Override
  public String getState() {
    return this.state;
  }

  @Override
  public Role getRole() {
    return null;
  }
}
