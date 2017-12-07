package anthill.model.roles;

import anthill.iface.ObservableWorld;
import anthill.model.Ant;
import anthill.model.Anthill;
import anthill.model.prey.PreyA;
import anthill.model.states.Chrysalis;
import anthill.model.states.Egg;
import anthill.view.World;

import java.awt.Point;
import java.util.List;
import java.util.Random;

/**
 * Defini le role concret d'ouvrier.
 * @author Monot_Vorotnikov
 *
 */

public class Worker extends Role implements ObservableWorld {
  PreyA carry;/*La proie qu'elle porte*/
  World wo;/*Le monde dans lequel elle vit. World est son observer*/
  
  /**
   * Worker constuctor.
   * @param p the point of origin
   */
  public Worker(Point p) {
    super();
    position = p;
    wo = null;
  }
  
  /**
   * the worker feed herself.L'ouvière peut se nourri elle-même.
   * @param a the ant herself
   */
  public void selfFeed(Ant a) {
    if (a.differenceBetweenTodayMeal() < 1 && carry != null) {
      a.setFoodQtty(this.carry.getWeight());
    }
  }
  
  /**
   * Feed other Ant by id
   * @param la List of ants
   * @param id id of the ant .
   */  
  public void feedOther(List<Ant> la, int id) {
    Egg e = new Egg();
    Chrysalis c = new Chrysalis();
    if (!la.get(id).getState().equals(e) || !la.get(id).getState().equals(c)) {
      if (la.get(id).differenceBetweenTodayMeal() < 1 && carry != null) {
        la.get(id).setFoodQtty(this.carry.getWeight());
        carry = null;
      }
      
    }
  }
  
  public void clean() {
    //TODO
  }
  
  public void fight(PreyA p) {
    //TODO
  }

  @Override
  public void move() {
    /*La methode qui gére le déplacement des fourmis par phéromone*/
    int x = this.position.x;
    int y = this.position.y;
    
    
    /*
     * Si la fourmi est au bord de l'écran 
     * je force le movement vers un point cardinal suivant sa situation.
     */
    if (x <= 5) {
      this.position = new Point(x + 10, y);
      return;
    } else if (y <= 5) {
      this.position = new Point(x, y + 10);
      return;
    }
    /*Ici je défini la probabilité de base de chaque points cardinaux.
     * la fourmi de base a 1/4 d'aler au nord au sud ...
     */
    int northPc = 25; 
    int eastPc = 25;
    int southPc = 25;
    @SuppressWarnings("unused")
    int westPc = 25;
    /*
     * Je recupère le contenu des cases(Nord,Sud,Ouest,Est) du monde dans le hashmap de World
     */
    boolean north = this.wo.getPheromonesWithPos(new Point(x,y - 10));
    if (north) { //Si Nord est vrai on augmente sa probabilité et on diminue les autres.
      northPc += 15;
      eastPc -= 5;
      southPc -= 5;
      westPc -= 5;
    }
    boolean east = this.wo.getPheromonesWithPos(new Point(x + 10,y));
    if (east) {
      northPc -= 5;
      eastPc += 15;
      southPc -= 5;
      westPc -= 5;
    }
    boolean south = this.wo.getPheromonesWithPos(new Point(x,y + 10));
    if (south) {
      northPc -= 5;
      eastPc -= 5;
      southPc += 15;
      westPc -= 5;
    }
    boolean west = this.wo.getPheromonesWithPos(new Point(x - 10,y));
    if (west) {
      northPc -= 5;
      eastPc -= 5;
      southPc -= 5;
      westPc += 15;
    }
    /*
     * Ici je crée les bornes d'intervals a partir des probabilités
     * Ex : Est = Ouest = Sud = Nord = 25. 
     * après ces lignes 
     * Nord = 25 Est = Nord + Est = 50 Sud = Est + Sud = 75 Ouest = Ouest + Sud = 100
     * 
     */
    eastPc += northPc; 
    southPc += eastPc;
    westPc += southPc;
    Random r = new Random();
    int chance = r.nextInt(100);/*Random entre 1 et 100 compris*/
    /*
     * Ici je determine les intervals(condition du if)
     * je determine le mouvement suivant la valeur de chance.
     * Si on reprends notre exemple plus haut
     * 0 < Chance < North => move north
     * North < Chance < East => move East
     * East < Chance < South => move South
     * South < Chance < West => move West
     */
    if (chance < northPc) {
      this.position = new Point(x, y - 10); //Cap au nord!
    } else if (northPc < chance && chance < eastPc) {
      this.position = new Point(x + 10, y); //Cap a l'Est!
    } else if (eastPc < chance && chance < southPc) {
      this.position = new Point(x, y + 10); //Cap au Sud!
    } else {
      this.position = new Point(x - 10,y);  //Cap a l'Ouest!
    }
    this.notifyToWorld();
    /*J'annonce au monde mon mouvement et je pose une phéromone*/
  }

  /**
   * RandomizePosition. Ancienne version de mouvement basé sur l'aléatoire.
   * On la garde comme solution de secours.
   */
  public void randPosition() {
    int x = this.position.x;
    int y = this.position.y;
    Random r = new Random();
    Boolean nextStepX = r.nextBoolean();
    Boolean nextStepY = r.nextBoolean();
    this.notifyToWorld();
    if (nextStepX && !nextStepY && (x < 575)) { //if x==true & y==false stepRight
      this.position = new Point(x += 10, y);
    } else if (!nextStepX && !nextStepY && (x > 5)) { //if x==false & y==false stepLeft
      this.position = new Point(x -= 10, y);
    } else if (!nextStepX && nextStepY && (y < 520)) { //if x==false & y==true stepDown
      this.position = new Point(x, y += 10);
    } else if (!nextStepX && !nextStepY && (y > 5)) { //if x==false & y==false stepDown
      this.position = new Point(x, y -= 10);
    }
  }
  
  @Override
  public Point getPosition() {
    return this.position;
  }
  
  public void setPosition(int x, int y) {
    this.position = new Point(x,y);
  }
  
  public void depose(Anthill ah) {
    ah.meat.add(carry);
  }
  
  public void getFood(Anthill ah) {
    carry = ah.meat.get(ah.meat.size() - 1);
  }
  
  @Override
  public void registerObserver(World w) {
    wo = w;
    wo.setMap(w.getMap());
  }

  @Override
  public void notifyToWorld() {
    wo.update(this.position);
  }
}
