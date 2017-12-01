package anthill.model;

public class Adult extends State {
  Role r;
  
  Adult(){
    super();
  }
  
  @Override
  public void changeState() {
    // TODO Auto-generated method stub
    
  }
  Role getRole() {
    return r;
  }

}
