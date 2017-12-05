package anthill.model;

import anthill.iface.Observer;
import anthill.model.states.Egg;
import anthill.model.states.State;

import java.util.Calendar;
import java.util.Date;



public class Ant implements anthill.iface.Observable {
  private int antId = 0;
  private Date dateStart;
  private Date dateEnd;
  private int weight;
  private Double foodQtty;
  private Double lastMeal;
  private Date dateMeal;
  public State state;
  
  /**
   * Ant constructor.
   */
  public Ant() {
    this.antId++;
    this.dateStart = new Date();
    this.dateEnd = new Date();
    this.weight = 0;
    this.foodQtty = 0.0;
    this.lastMeal = 0.0;
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
  
  public void setLastMeal(Double lastMeal) {
    this.lastMeal = lastMeal;
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
  
  public Double getLastMeal() {
    return this.lastMeal;
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
  public void notifyToObserver(Observer o, Anthill ah) {
    String stateF = "Egg";//First state
    String stateS = "Maggot";//Second state 
    String stateT = "Chrysalis";//Third state
    if (this.differenceBetweenBirthToday() >= 3 && getStateString().equals(stateF)) {
      o.updateEggToMaggot(this);
    } else if (this.differenceBetweenBirthToday() >= 13 && getStateString().equals(stateS)) {
      o.updateMaggotToChrysalis(this);
    } else if (this.differenceBetweenBirthToday() >= 30  && getStateString().equals(stateT)) {
      o.updateChrysalisToAdult(this, ah);
    }
  }
  /**
   * Add nbDays to the birth date.
   * @param nbDays to add
   * @return the new date
   */
  
  public Date addDaysToBirthday(int nbDays) {
    Calendar c = Calendar.getInstance(); 
    c.setTime(this.dateStart);
    c.add(Calendar.DATE, nbDays);
    Date newDate = c.getTime();
    return newDate;
  }
  
  public long differenceBetweenBirthToday() {
    Date d1 = new Date();
    return ((d1.getTime() - this.dateStart.getTime()) / (1000 * 60 * 60 * 24));
  }
  
}