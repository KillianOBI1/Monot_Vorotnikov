package anthill.iface;

import anthill.view.World;

/**
 * Element observable dans le monde graphique. 
 * @author yallay
 *
 */
public interface ObservableWorld {
  void notifyToWorld();
  
  void registerObserver(World w);
}
