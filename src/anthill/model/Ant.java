package anthill.model;

import anthill.iface.Observer;
import anthill.iface.Visitor;
import anthill.model.states.Egg;
import anthill.model.states.State;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;



public class Ant implements anthill.iface.Observable, anthill.iface.Visitable {
  private static int antCompt = 0;
  private int antId;
  private Date dateStart;
  private Date dateEnd;
  private int weight;
  private Double foodQtty;
  private Date dateMeal;
  public State state;
  
  /**
   * Ant constructor.
   */
  public Ant() {
    this.antId = this.antCompt;
    this.antCompt++;
    this.dateStart = new Date();
    this.dateEnd = whenIDie(antId);
    this.weight = 0;
    this.foodQtty = 0.0;
    this.state = new Egg();     
  }

    
  public void setWeight(int weight) {
    this.weight = weight;
  }
  
  public void setDateStart(Date d) {
    this.dateStart = d;
  }
  
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
  
  public int getWeight() {
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
  public void notifyToObserverEvol(Observer o, Anthill ah) {
    String stateF = "Egg";//First state
    String stateS = "Maggot";//Second state 
    String stateT = "Chrysalis";//Third state
    if (this.differenceBetweenBirthToday() >= 3 && getStateString().equals(stateF)) {
      o.updateEggToMaggot(ah,this.antId);
    } else if (this.differenceBetweenBirthToday() >= 13 && getStateString().equals(stateS)) {
      o.updateMaggotToChrysalis(ah,this.antId);
    } else if (this.differenceBetweenBirthToday() >= 30  && getStateString().equals(stateT)) {
      o.updateChrysalisToAdult(ah,this.antId);
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
   * @return The Darkest day of his life
   */
  public Date whenIDie(int id) {
    if (id != 1) {
      int min = 548;
      int max = 912;
      Random rand = new Random();
      int nbDay = rand.nextInt((max + 1) - min) + min;
      Calendar deathDate = Calendar.getInstance();
      deathDate.setTime(this.dateStart);
      deathDate.add(Calendar.DATE, nbDay);
      return deathDate.getTime();
    }
    int min = 1460;
    int max = 3650;
    Random rand = new Random();
    int nbDay = rand.nextInt((max + 1) - min) + min;
    Calendar deathDate = Calendar.getInstance();
    deathDate.setTime(this.dateStart);
    deathDate.add(Calendar.DATE, nbDay);
    return deathDate.getTime();
    
  }
  
  @Override
  public void notifyToObserverDeath(Observer o, Anthill ah) {
    if (this.differenceBetweenTodayDeath() <= 0 || this.differenceBetweenTodayMeal() >= 1) {
      o.updateDeath(this,ah);
    }
  }
  
  @Override
  public void notifyToObserverFood(Observer o) {
    if (this.getFoodQtty() >= this.getWeight()) {
      o.updateFood(this);
    }
  }


  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }
}