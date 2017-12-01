package anthill.model;

public class Egg extends State {
  String state;
  Egg() {
    this.state = "Egg";
  }
  
  @Override
  public String getState() {
    return this.state;
  }
}
