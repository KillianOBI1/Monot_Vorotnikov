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
  String s;
  
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
<<<<<<< HEAD
  }
  
  public String getStateString() {
    return this.state.getState();
  }
  
  public void changeState() {
      this.state = new Adult(new Worker());
  }
  
//  public Role getRole() {
//    this.state.g
//  }
  
//  private Date addDaysToBirthday(int nbDays) {
//    Calendar c = Calendar.getInstance(); 
//    c.setTime(this.dateStart);
//    c.add(Calendar.DATE, nbDays);
//    Date newDate = c.getTime();
//    return newDate;
//  }
=======
  } 
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> branch 'master' of https://github.com/KillianOBI1/Monot_Vorotnikov.git
=======
  
  
>>>>>>> branch 'master' of https://github.com/KillianOBI1/Monot_Vorotnikov.git
=======
  
  
>>>>>>> refs/remotes/origin/master
>>>>>>> refs/remotes/origin/Nikolai_branch
}
