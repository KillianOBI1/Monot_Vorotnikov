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
  
>>>>>>> refs/remotes/origin/master
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
