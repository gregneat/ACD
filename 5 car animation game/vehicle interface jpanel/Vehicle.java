import java.awt.*;
import java.awt.geom.*;

public interface Vehicle
{
	public void drive(int x);
	public Rectangle2D getBounds();
	public void paint(Graphics2D g2);
}