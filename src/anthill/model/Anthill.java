package anthill.model;

import anthill.iface.Visitor;
import anthill.model.prey.PreyA;
import anthill.observer.Observer;

import java.awt.Point;

import java.util.ArrayList;
import java.util.List;



/**
 * la fourmilière.
 * @author Monot_Vorotnikov
 *
 */
public class Anthill implements anthill.iface.Visitable {
  public List<Ant> listAnt;/*Liste des fourmi*/
  public List<PreyA> meat;/*List de nourriture*/
  int nbMaggot;
  int nbChrysalis;
  int nbEgg;
  int nbWorker;
  int nbPrince;
  int nbPrincess;
  int nbSoldier;
  Point position;/*Position de la fourmilière*/
  public Observer ob;/*Chaque fourmilière a son observer et son visiteur unique*/
  public anthill.visitor.Visitor vi;
  
  /**
   * Anthill constructor.
   * @param queen the Queen  create the anthill.
   */
  public Anthill(Ant queen) {
    position = queen.state.getRole().getPosition();
    nbMaggot = 0;
    nbChrysalis = 0;
    nbEgg = 0;
    nbWorker = 0;
    nbSoldier = 0;
    nbPrince = 0;
    nbPrincess = 0;
    listAnt = new ArrayList<Ant>();
    listAnt.add(queen);
    ob = new Observer();
    vi = new anthill.visitor.Visitor();
  }
  
  /**
   * Initial ant way of life.
   */
  public void initEvol() {
    
    for (Ant e : listAnt) {
      e.notifyToObserverEvol(this);
      e.notifyToObserverDeath(this);
      e.notifyToObserverFood(this);
    }
  }
  
  public Point getPosition() {
    return this.position;
  }
  
  public int getNbWorker() {
    return this.nbWorker;
  }
  
  public int getNbSoldier() {
    return this.nbSoldier;
  }
  
  public int getNbPrince() {
    return this.nbPrince;
  }
  
  public int getNbPrincess() {
    return this.nbPrincess;
  }
  
  public int getEgg() {
    return this.nbEgg;
  }
  
  public int getMaggot() {
    return this.nbMaggot;
  }
  
  public int getChrysalis() {
    return this.nbChrysalis;
  }
  
  public void setEgg(int i) {
    nbEgg += i;
  }
  
  public void setMaggot(int i) {
    nbMaggot += i;
  }
  
  public void setChrysalis(int i) {
    nbChrysalis += i;
  }
  
  public void setWorker(int i) {
    nbWorker += i;
  }
  
  public void setSoldier(int i) {
    nbSoldier += i;
  }
  
  public void setPrince(int i) {
    nbPrince += i;
  }
  
  public void setPrincess(int i) {
    nbPrincess += i;
  }

  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }
}