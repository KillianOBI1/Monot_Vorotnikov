package anthill.model;

public class Maggot extends State {
  
  String state;
  Maggot() {
    this.state = "Egg";
  }

  @Override
  public String getState() {
    return this.state;
  }

}
