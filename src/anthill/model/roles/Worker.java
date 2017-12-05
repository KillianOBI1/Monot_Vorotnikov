package anthill.model.roles;

import anthill.model.Ant;
import anthill.model.Prey;
import anthill.model.states.Chrysalis;
import anthill.model.states.Egg;

import java.awt.Point;
import java.util.List;
import java.util.Random;

public class Worker extends Role {
  Double carry;
  
  public Worker() {
    super();
    position = new Point(115,115);
  }
  
  public void selfFeed(Ant a, double weight) {
    a.setFoodQtty(weight);
  }
  /**
   * Feed other Ant by id.
   * @param la List of ants
   * @param id id of the ant
   * @param weight food available for the ant
   */
  
  public void feedOther(List<Ant> la, int id, double weight) {
    Egg e = new Egg();
    Chrysalis c = new Chrysalis();
    if (!la.get(id).getState().equals(e) || !la.get(id).getState().equals(c)) {
      la.get(id).setFoodQtty(weight);
    }
  }
  
  public void clean() {
    //TODO
  }
  
  public void fight(Prey p) {
    //TODO
  }

  @Override
  public void move() {
    int x = this.position.x;
    int y = this.position.y;
    Random r = new Random();
    Boolean nextStepX = r.nextBoolean();
    Boolean nextStepY = r.nextBoolean();
    
    if (nextStepX == true && nextStepY == false) { //if x==true & y==false stepRight
      this.position = new Point(x += 10, y);
    } else if (!nextStepX && !nextStepY) { //if x==false & y==false stepLeft
      this.position = new Point(x -= 10, y);
    } else if (!nextStepX && nextStepY) { //if x==false & y==true stepDown
      this.position = new Point(x, y += 10);
    } else if (!nextStepX && !nextStepY) { //if x==false & y==false stepDown
      this.position = new Point(x, y -= 10);
    }
  }

  @Override
  public Point getPosition() {
    return this.position;
  }
  
  public void setPosition(int x, int y) {
    this.position = new Point(x,y);
  }
}
