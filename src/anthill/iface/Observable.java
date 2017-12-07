package anthill.iface;

import anthill.model.Anthill;

/**
 * L'observé.
 * @author Monot_Vorotnikov
 *
 */
public interface Observable {
  public void notifyToObserverEvol(Anthill ah);
  
  public void notifyToObserverDeath(Anthill ah);

  void notifyToObserverFood(Anthill ah);
}
