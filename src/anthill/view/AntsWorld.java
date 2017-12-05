package anthill.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class AntsWorld extends JPanel {
  
  private static final long serialVersionUID = 1L;
  private List<MovableDrawable> ants = new LinkedList<>();
  private List<MovableDrawable> antHills = new LinkedList<>();
  
  private int grilleSize;
  
  /**
   * Create the panel
   * @param gsize - set the size of a cells.
   */
  public AntsWorld(int gsize) {
    this.grilleSize = gsize;
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

  public void removeAnt(MovableDrawable d) {
    ants.remove(d);
  }
  
  public void removeAnthill(MovableDrawable d) {
    antHills.remove(d);
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
    for (Iterator<MovableDrawable> iter = antHills.iterator(); iter.hasNext();) {
      iter.next().draw(g);
    }
    
    for (Iterator<MovableDrawable> iter = ants.iterator(); iter.hasNext();) {
      iter.next().draw(g);
    }
  }
}
