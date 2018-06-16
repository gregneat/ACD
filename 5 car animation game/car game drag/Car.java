import java.awt.geom.*;
import java.awt.*;

public class Car
{

	private Rectangle2D.Double a;
	private Ellipse2D.Double b,c,d,e;
	
	public Car(int xx, int yy)
	{
		int ww =40;
		int hh=60;
		a = new Rectangle2D.Double(xx,yy,ww,hh);
		b = new Ellipse2D.Double(xx-10,yy,10,10);
		c = new Ellipse2D.Double(xx+ww,yy,10,10);
		d = new Ellipse2D.Double(xx-10,yy+hh-10,10,10);
		e = new Ellipse2D.Double(xx+ww,yy+hh-10,10,10);
	}
	
	public boolean contains(double x, double y)
	{
		if(a.contains(x,y))
		{
			return true;
		}
		return false;
	}
	
	public boolean contains(Rectangle2D.Double other)
	{
		if(a.contains(other))
		{
			return true;
		}
		return false;
	}
	
	public void setLocation(int x, int y)
	{
		a.setFrame(x,y,a.getWidth(),a.getHeight());
		b.setFrame(x-10,y,10,10);
		c.setFrame(x+a.getWidth(),y,10,10);
		d.setFrame(x-10,y+a.getHeight()-10,10,10);
		e.setFrame(x+a.getWidth(),y+a.getHeight()-10,10,10);
	}
	
	public void paint(Graphics2D g2)
	{
		g2.setColor(Color.BLUE);
		g2.fill(a);
		g2.setColor(Color.BLACK);
		g2.fill(b);g2.fill(c);
		g2.fill(d);g2.fill(e);
	}
	
	public double getX()
	{
		return a.getX();
	}
	
	public double getY()
	{
		return a.getY();
	}
}