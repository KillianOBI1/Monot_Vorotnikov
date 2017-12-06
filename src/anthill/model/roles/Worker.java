package anthill.model.roles;

import anthill.iface.ObservableWorld;
import anthill.model.Ant;
import anthill.model.Anthill;
import anthill.model.prey.Prey;
import anthill.model.states.Chrysalis;
import anthill.model.states.Egg;
import anthill.view.World;


import java.awt.Point;
import java.util.List;
import java.util.Random;


import anthill.model.Ant;
import anthill.model.Anthill;
import anthill.model.prey.Prey;
import anthill.model.states.Chrysalis;
import anthill.model.states.Egg;

public class Worker extends Role implements ObservableWorld {
  Prey carry;
  World wo;
  
  /**
   * Worker constuctor.
   * @param p the point of origin
   */
  public Worker(Point p) {
    super();
    position = p;
    wo = null;
  }
  
  /**
   * the worker feed herself.
   * @param a the ant herself
   */
  public void selfFeed(Ant a) {
    if (a.differenceBetweenTodayMeal() < 1 && carry != null) {
      a.setFoodQtty(this.carry.getWeight());
    }
  }
  
  /**
   * Feed other Ant by id
   * @param la List of ants
   * @param id id of the ant .
   */  
  public void feedOther(List<Ant> la, int id) {
    Egg e = new Egg();
    Chrysalis c = new Chrysalis();
    if (!la.get(id).getState().equals(e) || !la.get(id).getState().equals(c)) {
      if (la.get(id).differenceBetweenTodayMeal() < 1 && carry != null) {
        la.get(id).setFoodQtty(this.carry.getWeight());
        carry = null;
      }
      
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
    this.notifyToWorld();
    if (nextStepX && !nextStepY && (x < 575)) { //if x==true & y==false stepRight
      this.position = new Point(x += 10, y);
    } else if (!nextStepX && !nextStepY && (x > 5)) { //if x==false & y==false stepLeft
      this.position = new Point(x -= 10, y);
    } else if (!nextStepX && nextStepY && (y < 520)) { //if x==false & y==true stepDown
      this.position = new Point(x, y += 10);
    } else if (!nextStepX && !nextStepY && (y > 5)) { //if x==false & y==false stepDown
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
  
  public void depose(Anthill ah) {
    ah.meat.add(carry);
  }
  
  public void getFood(Anthill ah) {
    carry = ah.meat.get(ah.meat.size() - 1);
  }
  
  @Override
  public void registerObserver(World w) {
    wo = w;
  }

  @Override
  public void notifyToWorld() {
    wo.updatePosition(this.position);
  }
}
