package anthill.observer;

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

import java.util.Random;
import java.awt.Point;
import java.util.Date;

/**
 * Observer: elle est enregistrer dans la fourmilière.
 * La fourmilière est par conséquent un observer.
 * @author Monot_Vorotnikov
 *
 */

public class Observer implements anthill.iface.Observer {
  final double quotaWorker = 0.7; // 70% d'ouvrier
  final double quotaSoldier = 0.20; // 20% de soldat
  final double quotaPrince = 0.05; // 5% de prince
  final double quotaPrincess = 0.05; // 5% de princesse
  int totalPop = 1; // La reine est de base compter dans la population
  protected Random random; 
  
  public Observer() {
    super();
  }
  
  @Override
  public void updateEggToMaggot(Anthill ah, int id) {
    /*L'oeuf devient une larve*/
    ah.listAnt.get(id).state = new Maggot();
    this.random = new Random();
    Double weight = 6 + random.nextDouble() * 1.7;//poids determiné aléatoirement
    ah.listAnt.get(id).setWeight(weight);
    ah.setMaggot(1);// ajout d'une larve au compteur de larve
    ah.setEgg(-1); // on enleve l'oeuf du compteur
  }

  @Override
  public void updateMaggotToChrysalis(Anthill ah, int id) {
    /*La larve devient une Nymphe*/
    ah.listAnt.get(id).state = new Chrysalis();
    ah.setMaggot(-1);
    ah.setChrysalis(1);
  }

  @Override
  public void updateChrysalisToAdult(Anthill ah, int id) {
    /*La nymphe devient un Adult*/
    if (ah.listAnt.get(id).getState().getRole() == null) {
      Role r;
      ah.setChrysalis(-1);
      /*
       * Ici on defini le role suivant les quotas. Ordre de priorité.
       * Ouvrier
       * Si le quota d'ouvrier est rempli
       * Prince
       * Si la quota de prince est rempli
       * Soldat
       * Si le quota de soldat est rempli
       * Princesse 
       */
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
      /*Mise a jour de l'état de la fourmi et ajout de son role*/
      ah.listAnt.get(id).state = new Adult(r);
    }
   
  }

  @Override
  public void updateDeath(Ant dead, Anthill ah) {
    /*Mise a jour de la fourmilière en cas de mort*/
    totalPop --;//On decremente la population
    if (dead.getStateString().equals("Adult")) {
      String role = dead.getState().getRole().getClass().getSimpleName();
      /*
       * Suivant son role on decremente la catégorie concerné.
       */
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
    ah.listAnt.remove(dead.getAntId());//la fourmi est retiré des actifs.
  }

  @Override
  public void updateFood(Ant feeded) {
    feeded.setDateMeal(new Date());
  }
  
  @Override
  public void updatePosition(Anthill ah,Point p) {
    
  }
}