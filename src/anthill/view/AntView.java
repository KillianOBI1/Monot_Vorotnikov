package anthill.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class AntView extends GraphicElement {

  public AntView(Point pos, Dimension dim) {
    super(pos, dim);
  }

  @Override
  public void draw(Graphics g) {
    g.setColor(Color.GRAY);
    g.fillOval(bounds.x,bounds.y,bounds.height,bounds.width);
  }
  
}
