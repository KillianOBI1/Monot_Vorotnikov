package anthill.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class AntsWorld extends JPanel {
  
  private static final long serialVersionUID = 1L;
  /*Liste des représentation graphique des fourmi*/
  private List<MovableDrawable> ants = new LinkedList<>();
  /*Liste des représentation graphique des fourmilière*/
  private List<MovableDrawable> antHills = new LinkedList<>();
  /*Liste des représentation graphique des carrés où seront dessiné des phéromones*/
  private List<MovableDrawable> square = new LinkedList<>();
  /*Liste des représentation graphique des proies*/
  private List<MovableDrawable> preys = new LinkedList<>();
  
  private int grilleSize;
  
  /**
   * Create the panel
   * @param gsize - set the size of a cells.
   */
  public AntsWorld(int gsize) {
    this.grilleSize = gsize;
  }
  
  public AntsWorld getAw() {
    return this;
  }
  
  public List<MovableDrawable> contents() {
    return ants;
  }
 
  public void addAnt(MovableDrawable d) {
    ants.add(d);
  }
  
  public void addAnthill(MovableDrawable d) {
    antHills.add(d);
  }
  
  public void addPrey(MovableDrawable d) {
    preys.add(d);
  }

  public void removeAnt(MovableDrawable d) {
    ants.remove(d);
  }
  
  public void removeAnthill(MovableDrawable d) {
    antHills.remove(d);
  }
  
  public void removePrey(MovableDrawable d) {
    preys.remove(d);
  }
  
  public void addSquare(MovableDrawable d) {
    square.add(d);
  }
  
  public void removeSquare(MovableDrawable d) {
    square.remove(d);
  }
  
  /**
   * @see javax.swing.JComponent#paint(java.awt.Graphics)
   */
  public void paint(Graphics g) {
    super.paint(g);
    
    Color c = g.getColor();
    g.setColor(Color.LIGHT_GRAY);
    
    // set the grid 
    for (int x = 0; x < this.getWidth(); x += this.grilleSize) {
      for (int y = 0; y < this.getHeight(); y += this.grilleSize) {
        g.drawLine(x, y, x, this.getHeight());
        g.drawLine(x, y, this.getWidth(), y);
      }
    }
    
    g.setColor(c);
    //Dessin de la fourmilière
    for (Iterator<MovableDrawable> iter = antHills.iterator(); iter.hasNext();) {
      iter.next().draw(g);
    }
    //dessin des fourmis
    for (Iterator<MovableDrawable> iter = ants.iterator(); iter.hasNext();) {
      iter.next().draw(g);
    }
    //Dessin des phéromones
    List<MovableDrawable> contens = new LinkedList<>();
    for (int i = 0; i < square.size(); i++) {
      contens.add(square.get(i));
    }
    
    for (Iterator<MovableDrawable> iter = contens.iterator(); iter.hasNext();) { 
      try {
        iter.next().draw(g);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    //Dessin des proies
    for (Iterator<MovableDrawable> iter = preys.iterator(); iter.hasNext();) { 
      iter.next().draw(g);
    }
  }

}
  
  

