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
  
  /**
   * Constructeur du monde.
   * @param aw La vue
   * @param ah La fourmilière
   */
  public World(AntsWorld aw, Anthill ah) {
    this.aw = aw;
    this.ah = ah;
    this.map = new HashMap<Point,Boolean>(3016);
  }
  
  /**
   * Initialisation du hashmap.
   */
  public void init() {
    for (int i = 5 ; i < aw.getWidth() ; i += 10) {
      for (int j = 5 ; i < aw.getHeight() ; i += 10) {
        this.map.put(new Point(i,j), false);
        
      }
    }
    this.map.put(ah.getPosition(), true);
  }
  
  @Override
  public void updatePosition(Point p) {
    map.put(p, true);
    aw.addSquare(new Square(p, new Dimension(5,5)));
  }
}
