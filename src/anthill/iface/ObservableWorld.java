package anthill.iface;

import anthill.view.World;

public interface ObservableWorld {
  void notifyToWorld();
  
  void registerObserver(World w);
}
