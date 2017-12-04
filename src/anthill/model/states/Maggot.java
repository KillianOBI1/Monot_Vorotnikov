package anthill.model.states;

import anthill.model.roles.Role;

public class Maggot extends State {
  
  String state;
  
  public Maggot() {
    this.state = "Maggot";
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
