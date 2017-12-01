package anthill.model;

public class Adult extends State {
  Role role;
  
  String state;
  Adult() {
    this.state = "Egg";
  }

  @Override
  public String getState() {
    return this.state;
  }

}
