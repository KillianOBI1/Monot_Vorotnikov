package anthill.iface;

import java.awt.Point;

import anthill.view.World;

public interface ObservableWorld {
  void notifyToWorld(Point p);
  
  void registerObserver(World w);
}
