package anthill.view;


import anthill.iface.ObserverWorld;
import anthill.model.Anthill;

import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;
import java.util.Random;



public class World implements ObserverWorld {
  AntsWorld aw;
  Anthill ah;
  HashMap<Point,Boolean> map;
  HashMap<Point,Boolean> praysMap;
  private Random r;
  
  /**
   * Constructeur du monde.
   * @param aw La vue
   * @param ah La fourmilière
   */
  public World(AntsWorld aw, Anthill ah) {
    this.aw = aw;
    this.ah = ah;
    this.map = new HashMap<Point,Boolean>(3016);
    this.praysMap = new HashMap<Point,Boolean>(3016);
    this.r = new Random();
  }
  
  /**
   * Initialisation du hashmap.
   */
  public void init() {
    for (int i = 5 ; i < aw.getWidth() ; i += 10) {
      for (int j = 5 ; i < aw.getHeight() ; i += 10) {
        this.map.put(new Point(i,j), false);
        this.praysMap.put(new Point(i,j), false);
      }
    }
    this.map.put(ah.getPosition(), true);
    this.praysMap.put(ah.getPosition(), true);
  }
  
  /**
   * randomly generate the set of preys on the map .
   */
  public void setPreys() {
    int numberOfPreys = r.nextInt(20) + 5;
    for (int i = 0; i < numberOfPreys;i++) {
      int x = r.nextInt(595);
      int y = r.nextInt(595);
      x = (x - (x % 10)) + 5;
      y = (y - (y % 10)) + 5;

      Point p = new Point(x,y);
      praysMap.put(p, true);
      aw.addPrey(new PreyView(p, new Dimension(12,12)));
    }
  }
  
  @Override
  public void update(Point p) {
    map.put(p, true);
    aw.addSquare(new Square(p, new Dimension(5,5)));
  }
  
  public void updatePrey(Point p) {
    map.put(p, true);
    aw.addPrey(new PreyView(p, new Dimension(12,12)));
  }
}
