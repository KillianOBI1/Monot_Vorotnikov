package anthill.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class AntsWorld extends JPanel {
  
  private static final long serialVersionUID = 1L;
  private List<MovableDrawable> drawables = new LinkedList<>();

  private int grilleSize;
  
  /**
   * Create the panel
   * @param gsize - set the size of a cells.
   */
  public AntsWorld(int gsize) {
    this.grilleSize = gsize;
  }
  
  public List<MovableDrawable> contents() {
    return drawables;
  }
 
  public void add(MovableDrawable d) {
    drawables.add(d);
  }

  public void remove(MovableDrawable d) {
    drawables.remove(d);
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
    for (Iterator<MovableDrawable> iter = drawables.iterator(); iter.hasNext();) {
      iter.next().draw(g);
    }
  }
}
