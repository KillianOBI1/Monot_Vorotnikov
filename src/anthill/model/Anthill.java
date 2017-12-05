package anthill.model;

import java.util.ArrayList;
import java.util.List;

public class Anthill {
  public List<Ant> listAnt;
  int nbMaggot;
  int nbChrysalis;
  int nbEgg;
  int nbWorker;
  int nbPrince;
  int nbPrincess;
  int nbSoldier;
  
  /**
   * Anthill constructor.
   * @param queen the Queen the Ant queen create the anthill.
   */
  public Anthill(Ant queen) {
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
  
  public void setEgg() {
    nbEgg++;
  }
  
  public void setMaggot() {
    nbMaggot++;
  }
  
  public void setChrysalis() {
    nbChrysalis++;
  }
  
  public void setWorker() {
    nbWorker++;
  }
  
  public void setSoldier() {
    nbSoldier++;
  }
  
  public void setPrince() {
    nbPrince++;
  }
  
  public void setPrincess() {
    nbPrincess++;
  }
}