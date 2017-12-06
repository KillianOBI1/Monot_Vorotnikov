package anthill.iface;

import java.awt.Point;

import anthill.view.World;

public interface ObservableWorld {
  void notifyToWorld();
  
  void registerObserver(World w);
}
