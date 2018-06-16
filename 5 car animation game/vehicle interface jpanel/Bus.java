import java.awt.geom.*;
import java.awt.*;

public class Bus implements Vehicle{

	private Rectangle2D.Double body;
	private Ellipse2D.Double wheel1,wheel2;
	
	public Bus(int xx, int yy)
	{
		body = new Rectangle2D.Double(xx,yy,100,40);
		wheel1 = new Ellipse2D.Double(xx,yy+40,15,15);
		wheel2 = new Ellipse2D.Double(xx+85,yy+40,15,15);
	}
	
	
	public void paint(Graphics2D g2)
	{
		g2.setColor(Color.YELLOW);
		g2.fill(body);
		g2.setColor(Color.BLACK);
		g2.fill(wheel1);
		g2.fill(wheel2);
	}
	
	public void drive(int x)
	{
		body.setFrame(body.getX()-x,body.getY(),100,40);
		wheel1.setFrame(wheel1.getX()-x,wheel1.getY(),15,15);
		wheel2.setFrame(wheel2.getX()-x,wheel2.getY(),15,15);
	}
	
	public Rectangle2D getBounds()
	{
		return body;
	}
}