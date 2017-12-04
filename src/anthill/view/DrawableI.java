package anthill.view;

import java.awt.Graphics;
import java.awt.Rectangle;

public interface DrawableI {
  public void draw(Graphics g);
  
  public Rectangle getBounds();
}
