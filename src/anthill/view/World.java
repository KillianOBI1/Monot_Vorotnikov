package anthill.view;


import anthill.iface.ObserverWorld;
import anthill.model.Anthill;

import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;



public class World implements ObserverWorld {
  AntsWorld aw;
  Anthill ah;
  HashMap<Point,Boolean> map;
  int height;
  int width;
  
  /**
   * Constructeur du monde.
   * @param aw La vue
   * @param ah La fourmilière
   */
  public World(AntsWorld aw, Anthill ah) {
    this.aw = aw;
    this.ah = ah;
    this.map = new HashMap<Point,Boolean>(3016);
    this.height = 600;
    this.width = 600;
  }
  
  /**
   * Initialisation du hashmap.
   */
  public void init() {
    for (int i = 5 ; i < width ; i += 10) {
      for (int j = 5 ; j < height ; j += 10) {
        this.map.put(new Point(i,j), false);
        
      }
    }
    this.map.put(ah.getPosition(), true);
  }
  
  /**
   * Renvoie un boolean. Si la case a une pheromone elle renvoi true sinon false.
   * @param p la case a verifé
   * @return un boolean
   */
  public boolean getPheromonesWithPos(Point p) {
    try {
      return map.get(p);
    } catch (NullPointerException e) {
      e.printStackTrace();
      return false;
    }
    
  }
  
  public HashMap<Point,Boolean> getMap() {
    return map;
  }
  
  public void setMap(HashMap<Point,Boolean> m) {
    map.putAll(m);
  }
  
  @Override
  public void updatePosition(Point p) {
    map.put(p, true);
    aw.addSquare(new Square(p, new Dimension(5,5)));
  }
}
