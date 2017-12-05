package anthill.visitor;

import anthill.model.Ant;
import anthill.model.Anthill;

public class Visitor implements anthill.iface.Visitor {

  
  public Visitor() {
    super();
  }
  
  @Override
  public void visit(Ant a) {
    String res = a.getAntId() + " ";
    res += a.getDateStart() + " ";
    res += a.getDateEnd() + " ";
    res += a.getStateString() + " ";
    res += a.getFoodQtty() + " ";
    res += a.getDateMeal() + " ";
    if (a.getStateString().equals("Adult")) {
      res += a.getState().getRole().getClass().getSimpleName();
    }
    System.out.println(res);
  }

  @Override
  public void visit(Anthill ah) {
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
