import java.awt.*;
import java.awt.geom.*;

public class Edan
{
	/*there is a regular retangle but no regular ellipse so I thought it was better to stay consistent
	with the 2D.Double part at the end of each shape*/
	Ellipse2D.Double a;
	Rectangle2D.Double b;
	
	public Edan(int x,int y)
	{
		a = new Ellipse2D.Double(x,y,50,50);
		b = new Rectangle2D.Double(x,y+50,50,100);	
	}
  
  
	public void paint(Graphics g)
	{
		//must use graphics2D for shapes
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLUE);
		g2.fill(a);
		g2.setColor(Color.RED);
		g2.fill(b);
	}
	
	public void setLocation(double c, double d)
	{
		//setFrame() sets the location and size of shapes
		//I could not find a method that just sets location
		a.setFrame(c,d,50,50);
		b.setFrame(c,d+50,50,100);
	}

	public boolean contains(double x, double y)
	{
		if(a.contains(x,y)||b.contains(x,y))
		{
			return true;
		}
		return false;
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

