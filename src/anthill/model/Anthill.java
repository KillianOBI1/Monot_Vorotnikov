package anthill.model;

import java.util.ArrayList;
import java.util.List;

public class Anthill {
  List<Ant> listAnt;
  int nbMaggot;
  int nbChrysalis;
  int nbEgg;
  int nbWorker;
  int nbPrince;
  int nbPrincess;
  
  /**
   * Anthill constructor.
   * @param q the Queen the Ant queen create the anthill.
   */
  public Anthill(Ant queen) {
    nbMaggot = 0;
    nbChrysalis = 0;
    nbEgg = 0;
    nbWorker = 0;
    nbPrince = 0;
    nbPrincess = 0;
    listAnt = new ArrayList<Ant>();
    listAnt.add(queen);
  }
  
  
  
}
