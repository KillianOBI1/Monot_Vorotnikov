package anthill.iface;

import java.awt.Point;

public interface ObserverWorld {
  void update(Point p);
  /*Le monde mets a jour son hashmap et y place une phéromone(boolean true) à la clé point*/
}
