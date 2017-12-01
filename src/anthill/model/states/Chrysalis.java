package anthill.model.states;

import anthill.model.roles.Role;

public class Chrysalis extends State {

  String state;
  public Chrysalis() {
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
