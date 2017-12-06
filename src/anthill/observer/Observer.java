package anthill.observer;

import java.util.Date;

import anthill.model.Ant;
import anthill.model.Anthill;
import anthill.model.roles.Prince;
import anthill.model.roles.Princess;
import anthill.model.roles.Role;
import anthill.model.roles.Soldier;
import anthill.model.roles.Worker;
import anthill.model.states.Adult;
import anthill.model.states.Chrysalis;
import anthill.model.states.Maggot;



public class Observer implements anthill.iface.Observer {
  final double quotaWorker = 0.7;
  final double quotaSoldier = 0.20;
  final double quotaPrince = 0.05;
  final double quotaPrincess = 0.05;
  int totalPop = 1;
  
  public Observer() {
    super();
  }
  
  @Override
  public void updateEggToMaggot(Anthill ah, int id) {
    if (ah.listAnt.get(id).getStateString().equals("Egg")) {
      ah.listAnt.get(id).state = new Maggot();
      ah.setMaggot(1);
      ah.setEgg(-1);
    }
  }

  @Override
  public void updateMaggotToChrysalis(Anthill ah, int id) {
    if (ah.listAnt.get(id).getStateString().equals("Maggot")) {
      ah.listAnt.get(id).state = new Chrysalis();
      ah.setMaggot(-1);
      ah.setChrysalis(1);
    }
  }

  @Override
  public void updateChrysalisToAdult(Anthill ah, int id) {
    if (ah.listAnt.get(id).getState().getRole() == null && ah.listAnt.get(id).getStateString().equals("Chrysalis")) {
      Role r;
      ah.setChrysalis(-1);
      if (((double)ah.getNbWorker() / (double)totalPop) < quotaWorker) {
        r = new Worker(ah.getPosition());
        ah.setWorker(1);  
      } else if (((double)ah.getNbPrince() / (double)totalPop) < quotaPrince) {
        r = new Prince(ah.getPosition());
        ah.setPrince(1);
      } else if (((double)ah.getNbSoldier() / (double)totalPop) < quotaSoldier) {
        r = new Soldier(ah.getPosition());
        ah.setSoldier(1);
      } else {
        r = new Princess(ah.getPosition());
        ah.setPrincess(1);
      }
      totalPop ++;
      ah.listAnt.get(id).state = new Adult(r);
    }
   
  }

  @Override
  public void updateDeath(Ant dead, Anthill ah) {
    totalPop --;
    if (dead.getStateString().equals("Adult")) {
      String role = dead.getState().getRole().getClass().getSimpleName();
      switch (role) {
        case "Queen":
          break;
        case "Worker":
          ah.setWorker(-1);
          break;
        case "Soldier":
          ah.setSoldier(-1);
          break;
        case "Prince":
          ah.setPrince(-1);
          break;
        case "Princess":
          ah.setPrincess(-1);
          break;
        default:
          break;
      }
    } else {
      ah.setMaggot(-1);
    }
    ah.listAnt.remove(dead.getAntId());
  }

  @Override
  public void updateFood(Ant feeded) {
    feeded.setDateMeal(new Date());
  }
}