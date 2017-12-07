package anthill.visitor;

import anthill.model.Ant;
import anthill.model.Anthill;

/**
 * Classe visiteur.
 * @author Monot_Vorotnikov
 *
 */
public class Visitor implements anthill.iface.Visitor {

  
  public Visitor() {
    super();
  }
  
  @Override
  public void visit(Ant a) {
    /*
     * On visite la fourmi
     */
    String res = a.getAntId() + " ";
    res += a.getDateStart() + " ";
    res += a.getDateEnd() + " ";
    res += a.getStateString() + " ";
    res += a.getFoodQtty() + " ";
    res += a.getDateMeal() + " ";
    if (a.getStateString().equals("Adult")) {
      res += a.getState().getRole().getClass().getSimpleName() + " ";
    }
    res += a.getState().getRole().getPosition();
    System.out.println(res);
  }

  @Override
  public void visit(Anthill ah) {
    /*
     * On visite les fourmis et la fourmilière. 
     */
    for (Ant a : ah.listAnt) {
      visit(a);
    }
    System.out.println("Number of prince: " + ah.getNbPrince());
    System.out.println("Number de princess: " + ah.getNbPrincess());
    System.out.println("Number of soldier: " + ah.getNbSoldier());
    System.out.println("Number of worker: " + ah.getNbWorker());
    System.out.println("Number of egg: " + ah.getEgg());
    System.out.println("Number of maggot" + ah.getMaggot()); 
    System.out.println("Number of Chrysalis" + ah.getChrysalis());
  }

}
