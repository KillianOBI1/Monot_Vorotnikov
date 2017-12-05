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
  public void updateEggToMaggot(Ant egg) {
    if (egg.getStateString().equals("Egg")) {
      egg.state = new Maggot();
    }
  }

  @Override
  public void updateMaggotToChrysalis(Ant maggot) {
    if (maggot.getStateString().equals("Maggot")) {
      maggot.state = new Chrysalis();
    }
  }

  @Override
  public void updateChrysalisToAdult(Ant chrysalis, Anthill ah) {
    if (chrysalis.getState().getRole() == null && chrysalis.getStateString().equals("Chrysalis")) {
      Role r;
      if (((double)ah.getNbWorker() / (double)totalPop) < quotaWorker) {
        r = new Worker();
        ah.setWorker();
      } else if (((double)ah.getNbPrince() / (double)totalPop) < quotaPrince) {
        r = new Prince();
        ah.setPrince();
      } else if (((double)ah.getNbSoldier() / (double)totalPop) < quotaSoldier) {
        r = new Soldier();
        ah.setSoldier();
      } else {
        r = new Princess();
        ah.setPrincess();
      }
      totalPop ++;
      chrysalis.state = new Adult(r);
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
          //ah.nbWorker--;
          break;
        case "Soldier":
          //ah.nbSoldier--;
          break;
        case "Prince":
          //ah.nbPrince--;
          break;
        case "Princess":
          //ah.nbPrincess--;
          break;
        default:
          break;
      }
    } else {
      //ah.nbMaggot--;
    }
    ah.listAnt.remove(dead.getAntId());
  }

  @Override
  public void updateFood(Ant feeded) {
    if (feeded.getFoodQtty() >= feeded.getWeight()) {
      feeded.setDateMeal(new Date());
    }
  }
}