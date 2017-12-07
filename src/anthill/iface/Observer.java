package anthill.iface;

import anthill.model.Ant;
import anthill.model.Anthill;

import java.awt.Point;

/**
 * Ici on defini l'oberver en terme d'evolution(la fourmilière) .
 * @author yallay
 *
 */
public interface Observer {
  public void updateEggToMaggot(Anthill ah, int id);/*Oeuf=>Larve*/
  
  public void updateMaggotToChrysalis(Anthill ah, int id);/*Larve => Nymphe*/
  
  public void updateChrysalisToAdult(Anthill ah, int id); /*Nymphe => Adulte*/
  
  public void updateDeath(Ant dead, Anthill ah);/*Fait disparaitre la fourmi*/
  
  public void updateFood(Ant feeded);/*Met a jour la date du dernier repas de la fourmi*/
  
  public void updatePosition(Anthill ah,Point p);/*Met a jour la position non utilisé*/
}
