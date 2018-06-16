import java.awt.*;
import java.awt.geom.*;

public abstract class Vehicle
{
	//must be implemented in the subclasses
	public abstract void drive(int x);
	public abstract Rectangle2D getBounds();
	public abstract void paint(Graphics2D g2);
}