package anthill.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Grid extends JPanel {
  
  private static final long serialVersionUID = 1L;
  private int grilleSize;
  
  /**
   * @param gsize - size of a grid cell. 
   */
  public Grid(int gsize) {
    this.grilleSize = gsize;
  }
  
  /**
   * @see javax.swing.JComponent#paint(java.awt.Graphics).
   */
  public void paint(Graphics g) {
    super.paint(g);
    Color c = g.getColor();
    g.setColor(Color.LIGHT_GRAY);
    
    for (int x = 0; x < this.getWidth(); x += this.grilleSize) {
      for (int y = 0; y < this.getHeight(); y += this.grilleSize) {
        g.drawLine(x, y, x, this.getHeight());
        g.drawLine(x, y, this.getWidth(), y);
      }
    }
    g.setColor(c);
  }

}
