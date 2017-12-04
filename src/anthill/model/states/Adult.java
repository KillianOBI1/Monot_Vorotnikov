package anthill.model.states;

import anthill.model.roles.Role;

public class Adult extends State {

  Role role;
  
  String state;
  
  public Adult(Role role) {
    this.state = "Adult";
    this.role = role;
  }

  @Override
  public String getState() {
    return this.state;
  }
  
  public Role getRole() {
    return this.role;
  }

}
