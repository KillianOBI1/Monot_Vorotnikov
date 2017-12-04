package anthill.model.states;

import anthill.model.roles.Role;

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
