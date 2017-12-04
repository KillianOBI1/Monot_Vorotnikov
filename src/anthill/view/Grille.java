package anthill.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Grille extends JPanel {
  
  private static final long serialVersionUID = 1L;

  /**
   * @see javax.swing.JComponent#paint(java.awt.Graphics).
   */
  public void paint(Graphics g) {
    super.paint(g);
    Color c = g.getColor();
    g.setColor(Color.LIGHT_GRAY);
    
    for (int x = 0; x < this.getWidth(); x += 10) {
      for (int y = 0; y < this.getHeight(); y += 10) {
        g.drawLine(x, y, x, this.getHeight());
        g.drawLine(x, y, this.getWidth(), y);
      }
    }
    g.setColor(c);
  }

}
