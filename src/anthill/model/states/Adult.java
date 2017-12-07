package anthill.model.states;

import anthill.model.roles.Role;

/**
 * Adult herite de State et elle possède un rôle attribué par l'observer de la fourmilière.
 * @author Monot_Vorotnikov
 *
 */
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
