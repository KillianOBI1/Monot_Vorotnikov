package anthill.model.states;

import anthill.model.roles.Role;

public class Maggot extends State {
  
  String state;
  Maggot() {
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
