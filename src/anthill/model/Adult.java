package anthill.model;

public class Adult extends State {
<<<<<<< HEAD
  Role role;
  
  String state;
  public Adult(Role role) {
    this.state = "Egg";
    this.role = role;
  }

=======
  Role r;
  
  Adult(){
    super();
  }
  
>>>>>>> branch 'master' of https://github.com/KillianOBI1/Monot_Vorotnikov.git
  @Override
  public String getState() {
    return this.state;
  }
  
  public Role getRole() {
    return this.role;
  }
  Role getRole() {
    return r;
  }

}
