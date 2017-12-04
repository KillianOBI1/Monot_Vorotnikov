package anthill.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class GraphicElement implements MovableDrawable {
  protected Rectangle bounds;
  
  /**
   * @param pos - position of element
   * @param dim - element size.
   */
  public GraphicElement(Point pos, Dimension dim) {
    this.bounds = new Rectangle(dim);
    setPosition(pos);
  }
  
  public abstract void draw(Graphics g) ;
  
  public Rectangle getBounds() {
    return (Rectangle) bounds.clone();
  }

  /**
   * @return position .
   */
  public Point getPosition() {
    Point p = bounds.getLocation();
    p.x = (p.x + bounds.width / 2);
    p.y = (p.y + bounds.width / 2);
    return p;
  }

  
  public void setPosition(Point p) {
    bounds.x = (p.x - bounds.width / 2);
    bounds.y = (p.y - bounds.height / 2);
  }

}
