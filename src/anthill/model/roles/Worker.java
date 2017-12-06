package anthill.model.roles;

import java.awt.Point;
import java.util.List;
import java.util.Random;

import anthill.iface.ObservableWorld;
import anthill.model.Ant;
import anthill.model.Anthill;
import anthill.model.prey.PreyA;
import anthill.model.states.Chrysalis;
import anthill.model.states.Egg;
import anthill.view.World;

public class Worker extends Role implements ObservableWorld {
  PreyA carry;
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
  
  public void fight(PreyA p) {
    //TODO
  }

  @Override
  public void move() {
    int x = this.position.x;
    int y = this.position.y;
    int northPc = 25;
    int eastPc = 25;
    int southPc = 25;
    int westPc = 25;
    boolean north = this.wo.getPheromonesWithPos(new Point(x,y - 10));
    boolean east = this.wo.getPheromonesWithPos(new Point(x + 10,y));
    boolean south = this.wo.getPheromonesWithPos(new Point(x,y + 10));
    boolean west = this.wo.getPheromonesWithPos(new Point(x - 10,y));
    if (north) {
      northPc += 15;
      eastPc -= 5;
      southPc -= 5;
      westPc -= 5;
    }
    if (east) {
      northPc -= 5;
      eastPc += 15;
      southPc -= 5;
      westPc -= 5;
    }
    if (south) {
      northPc -= 5;
      eastPc -= 5;
      southPc += 15;
      westPc -= 5;
    }
    if (west) {
      northPc -= 5;
      eastPc -= 5;
      southPc -= 5;
      westPc += 15;
    }
    System.out.println(northPc + " " + eastPc + " " + southPc + " " + westPc);
    eastPc += northPc;
    southPc += eastPc;
    westPc += southPc;
    Random r = new Random();
    int chance = r.nextInt(100);
    System.out.println(northPc + " " + eastPc + " " + southPc + " " + westPc + " " + chance);
    if (chance < northPc) {
      this.position = new Point(x, y - 10); 
      System.out.println("NORTH");//move north
    } else if (northPc < chance && chance < eastPc) {
      this.position = new Point(x + 10, y); //move east
      System.out.println("EAST");
    } else if (eastPc < chance && chance < southPc) {
      this.position = new Point(x, y + 10); //move south
      System.out.println("SOUTH");
    } else {
      this.position = new Point(x - 10,y);  //move west
      System.out.println("WEST");
    }
    this.notifyToWorld();
  }

  /**
   * RandomizePosition.
   */
  public void randPosition() {
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
    wo.setMap(w.getMap());
  }

  @Override
  public void notifyToWorld() {
    wo.update(this.position);
  }
}
