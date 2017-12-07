package anthill.model.prey;

import java.awt.Point;

/**
 * Classe definissant le concept de proie.
 * @author Monot_Vorotnikov
 *
 */
public abstract class PreyA {
    
  public abstract Double getWeight();/*Renvoie le point de la proie*/
  
  public abstract void setHunted();/*Passe l'état de la proie en chassé*/
  
  public abstract Point getPosition();/*Obtiens la position de la proie*/
}
