package anthill.model;

import anthill.iface.Visitor;
import anthill.model.states.Egg;
import anthill.model.states.State;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;


/**
  * 
  * @author Monot_Vorotnikov
  * Classe Ant(Fourmi).
  */


public class Ant implements anthill.iface.Observable, anthill.iface.Visitable {
  private static int antCompt = 0; /* compteur de fourmi*/
  private int antId; /* Son Id */
  private Date dateStart; /* date de naissance */
  private Date dateEnd; /* date de mort */
  private Double weight; /* son poids */
  private Double foodQtty; /* la quantité de nouriture qu'il a mangé depuis son dernier repas */
  private Date dateMeal; /* la dernière fois qu'il a mangé a sa faim */
  public State state; /* son état */
  
  /**
   * Ant constructor.
   */
  public Ant() {
    this.antId = this.antCompt; 
    this.antCompt++;
    this.dateStart = new Date();
    this.dateEnd = whenIDie(antId);
    this.weight = 1.0;
    this.foodQtty = 0.0;
    this.state = new Egg(); /* chaque fourmi crée devient un oeuf automatiquement */
  }

    
  public void setWeight(Double weight) {
    this.weight = weight;
  }
  
  public void setDateStart(Date d) {
    this.dateStart = d;
  }
  /**
   * Cette fonction permet de nourrir la fourmi.
   * @param amountOfFood la quantité de nourriture
   */
  public void setFoodQtty(Double amountOfFood) {
    this.foodQtty += amountOfFood;
  }
  
  public void setDateMeal(Date dateMeal) {
    this.dateMeal = dateMeal;
  }

  public int getAntId() {
    return this.antId;
  }
    
  public Date getDateStart() {
    return this.dateStart;
  }

  public Date getDateEnd() {
    return this.dateEnd;
  }
  
  public Double getWeight() {
    return this.weight;
  }
  
  public Double getFoodQtty() {
    return this.foodQtty;
  }
  
  public Date getDateMeal() {
    return this.dateMeal;
  }
  
  public State getState() {
    return this.state;
  }
  
  public String getStateString() {
    return this.state.getState();
  }

  @Override
  public void notifyToObserverEvol(Anthill ah) {
    /*La fourmi notifie a son observateur qu'il va évolué*/
    String stateF = "Egg";//First state oeuf
    String stateS = "Maggot";//Second state larve
    String stateT = "Chrysalis";//Third state nymphe
    if (this.differenceBetweenBirthToday() >= 3 && getStateString().equals(stateF)) { 
      /*Si la différence entre la date de naissance et la date actuelle est de trois oeuf=>Larve*/
      ah.ob.updateEggToMaggot(ah,this.antId);//appelle de l'observer pour mise a jour
    } else if (this.differenceBetweenBirthToday() >= 13 && getStateString().equals(stateS)) {
      /* Si la différence est de 13 la larve devient une nymphe*/
      ah.ob.updateMaggotToChrysalis(ah,this.antId);
    } else if (this.differenceBetweenBirthToday() >= 30  && getStateString().equals(stateT)) {
      /* si la différence est de 30 la nymphe devient une fourmi*/
      ah.ob.updateChrysalisToAdult(ah,this.antId);
    }
  }
  /**
   * Add nbDays to the birth https://openclassrooms.com/forum/sujet/compteur-d-instancesdate.
   * @param nbDays to add
   * @return the new date
   */
  
  public Date addDaysToBirthday(int nbDays) {
    Calendar c = Calendar.getInstance(); 
    c.setTime(this.dateStart);
    c.add(Calendar.DATE, nbDays);
    return c.getTime();
  }
  
  public long differenceBetweenBirthToday() {
    Date d1 = new Date();
    return ((d1.getTime() - this.dateStart.getTime()) / (1000 * 60 * 60 * 24));
  }
  
  public long differenceBetweenTodayDeath() {
    Date d1 = new Date();
    return ((this.dateEnd.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
  }
  
  public long differenceBetweenTodayMeal() {
    Date d2 = new Date();
    return ((d2.getTime() - this.dateMeal.getTime()) / (1000 * 60 * 60 * 24));
  }
  
  /**
   * Define when the ant die.
   * @return The date when he will die
   */
  public Date whenIDie(int id) {
    if (id != 1) {/*pour la fourmi*/
      int min = 548;/*1,5 année*/
      int max = 912;/* 2,5 année*/
      Random rand = new Random();
      int nbDay = rand.nextInt((max + 1) - min) + min;
      Calendar deathDate = Calendar.getInstance();
      deathDate.setTime(this.dateStart);
      deathDate.add(Calendar.DATE, nbDay);
      return deathDate.getTime();
    }
    /*pour la reine*/
    int min = 1460;/*4 année*/
    int max = 3650;/*10 année*/
    Random rand = new Random();
    int nbDay = rand.nextInt((max + 1) - min) + min;
    Calendar deathDate = Calendar.getInstance();
    deathDate.setTime(this.dateStart);
    deathDate.add(Calendar.DATE, nbDay);
    return deathDate.getTime();
    
  }
  
  @Override
  public void notifyToObserverDeath(Anthill ah) {
    /*si elle a atteins sa date de mort ou si elle a pas manger depuis 1 jour elle meurt*/
    if (this.differenceBetweenTodayDeath() <= 0 || this.differenceBetweenTodayMeal() >= 1) {
      ah.ob.updateDeath(this,ah);
    }
  }
  
  @Override
  public void notifyToObserverFood(Anthill ah) {
    /*Si elle a mangé a sa faim elle mets a jour sa date du dernier repas*/
    if (this.getFoodQtty() >= this.getWeight()) {
      ah.ob.updateFood(this);
    }
  }


  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }
}