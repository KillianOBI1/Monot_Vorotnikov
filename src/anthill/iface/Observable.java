package anthill.iface;

import anthill.model.Anthill;

public interface Observable {
  public void notifyToObserverEvol(Observer o, Anthill ah);
  
  public void notifyToObserverDeath(Observer o, Anthill ah);
}
