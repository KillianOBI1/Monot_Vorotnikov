package anthill.iface;

import anthill.model.Ant;
import anthill.model.Anthill;

public interface Observer {
  public void updateEggToMaggot(Anthill ah, int id);
  
  public void updateMaggotToChrysalis(Anthill ah, int id);
  
  public void updateChrysalisToAdult(Anthill ah, int id);
  
  public void updateDeath(Ant dead, Anthill ah);
  
  public void updateFood(Ant feeded);
  
}
