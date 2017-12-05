package anthill.iface;

import anthill.model.Anthill;

public interface Observable {
  public void notifyToObserver(Observer o, Anthill ah);
}
