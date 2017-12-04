package anthill.view;

import java.awt.Point;

public interface MovableDrawable extends DrawableI {
  void setPosition(Point p);
  
  Point getPosition();
}
