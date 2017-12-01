package anthill.model;

import java.util.Date;

public class Ant {
  private int antId = 0;
  private Date dateStart;
  private Date dateEnd;
  private int weight;
  private Double foodQtty;
  private Double lastMeal;
  private Date dateMeal;
  public State state;
  
  Ant() {
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
  
  
}
