package anthill.iface;

import anthill.model.Ant;
import anthill.model.Anthill;

public interface Visitor {
  
  void visit(Ant a);
  
  void visit(Anthill ah);

}
