package anthill.model;

public class Chrysalis extends State {

  String state;
  Chrysalis() {
    this.state = "Egg";
  }

  @Override
  public String getState() {
    return this.state;
  }

}
