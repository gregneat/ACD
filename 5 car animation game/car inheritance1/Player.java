import java.awt.geom.*;
import java.awt.*;

public class Player{

	private Ellipse2D.Double face, eye1, eye2;
	private Line2D.Double mouth;
	
	public Player(int xx, int yy)
	{
		face = new Ellipse2D.Double(xx,yy,40,40);
		eye1 = new Ellipse2D.Double(xx+5,yy+10,10,10);
		eye2 = new Ellipse2D.Double(xx+25,yy+10,10,10);
		mouth = new Line2D.Double(xx+10,yy+30,xx+30,yy+30);
	}
	
	
	public void paint(Graphics2D g2)
	{
		g2.setColor(Color.BLUE);
		g2.fill(face);
		g2.setColor(Color.YELLOW);
		g2.fill(eye1);
		g2.fill(eye2);
		g2.draw(mouth);
	}
	
	public boolean crash(Vehicle v)
	{
		if(face.intersects(v.getBounds()))
		{
			return true;
		}
		return false;
	}
	
	public void setLocation(double x, double y)
	{
		face.setFrame(x,y,40,40);
		eye1.setFrame(x+5,y+10,10,10);
		eye2.setFrame(x+25,y+10,10,10);
		mouth.setLine(x+10,y+30,x+30,y+30);
	}
	
	public double getX()
	{
		return face.getX();
	}
	
	public double getY()
	{
		return face.getY();
	}
	
}