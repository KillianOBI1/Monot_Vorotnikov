package anthill.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import anthill.iface.Visitor;
import anthill.model.prey.Prey;

public class Anthill implements anthill.iface.Visitable {
  public List<Ant> listAnt;
  public List<Prey> meat;
  int nbMaggot;
  int nbChrysalis;
  int nbEgg;
  int nbWorker;
  int nbPrince;
  int nbPrincess;
  int nbSoldier;
  Point position;
  
  /**
   * Anthill constructor.
   * @param queen the Queen the Ant queen create the anthill.
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