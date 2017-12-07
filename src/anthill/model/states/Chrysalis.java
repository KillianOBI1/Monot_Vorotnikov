package anthill.model.states;

import anthill.model.roles.Role;

/**
 * Classe concrete de Sate elle représente la Nymphe.
 * @author Monot_Vorotnikov
 *
 */

public class Chrysalis extends State {

  String state;
  
  public Chrysalis() {
    this.state = "Chrysalis";
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
