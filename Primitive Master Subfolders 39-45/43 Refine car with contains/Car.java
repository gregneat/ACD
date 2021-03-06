import java.awt.geom.*;
import java.awt.*;

public class Car{

	private Rectangle2D.Double body1,body2;
	private Ellipse2D.Double wheel1, wheel2;
	private String name;
	private Color color;
	private double speed;

	public Car()
	{
		int x = 0;
		int y = 100;
		body1 = new Rectangle2D.Double(x,y,60,20);
		body2 = new Rectangle2D.Double(x+10,y-20,40,20);
		wheel1 = new Ellipse2D.Double(x,y+20,15,15);
		wheel2 = new Ellipse2D.Double(x+45,y+20,15,15);
		name = "";
		color = Color.BLUE;
		speed = 2.0;
	}
	
	public Car(String n)
	{
		this();
		name = n;
	}
	
	public Car(double xx, double yy, String n)
	{
		this(n);
		setLocation(xx,yy);
	}
	
	public Car(double xx, double yy, String n, Color c)
	{
		this(xx,yy,n);
		color = c;
	}
	public Car(double xx, double yy, String n, Color c, double s)
	{
		this(xx,yy,n,c);
		speed = s;
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(color);
		g2.fill(body1);
		g2.fill(body2);
		g2.setColor(Color.WHITE);
		g2.fill(wheel1);
		g2.fill(wheel2);
		
		g.drawString(name,(int)body1.getX()+20,(int)body1.getY()+10);	
		
		String coords = "("+(int)getX()+","+(int)getY()+")";
		g.drawString(coords,(int)getX(),(int)getY()-30);
	}
	
	public void drive()
	{
		body1.setFrame(body1.getX()+speed,body1.getY(),60,20);
		body2.setFrame(body2.getX()+speed,body2.getY(),40,20);
		wheel1.setFrame(wheel1.getX()+speed,wheel1.getY(),15,15);
		wheel2.setFrame(wheel2.getX()+speed,wheel2.getY(),15,15);
	}
	public void setLocation(double x, double y)
	{
		body1.setFrame(x,y,60,20);
		body2.setFrame(x+10,y-20,40,20);
		wheel1.setFrame(x,y+20,15,15);
		wheel2.setFrame(x+45,y+20,15,15);
	}
	public void setColor(Color c)
	{
		color = c;
	}
	public boolean contains(double x, double y)
	{
		return body1.contains(x,y) || body2.contains(x,y) || 
			   wheel1.contains(x,y) || wheel2.contains(x,y);
	}
	public double getX()
	{
		return body1.getX();
	}
	public double getY()
	{
		return body1.getY();
	}
	public Color getColor()
	{
		return color;
	}
	public double getWidth()
	{
		return body1.getWidth();
	}
	public double getHeight()
	{
		return body1.getHeight()+body2.getHeight()+wheel1.getHeight();
	}
	public double getSpeed()
	{
		return speed;
	}
	public String getName()
	{
		return name;
	}
	public String stringColor()
	{
		return "Car color: Red- "+color.getRed()+" Green- "+color.getGreen()+" Blue- "+color.getBlue();
	}
	public String stringSpeed()
	{
		//assumes thread.sleep is set to 15 milliseconds
		//rounds to hundredths place
		double convertedSpeed = (int)(100*speed/0.015)/100.0;
		return "Car speed: "+convertedSpeed+" pixels per second";
	}
	public String toString()
	{
		return "Car name: "+getName()+"\n"+stringColor()+"\n"+stringSpeed()+"\n";
	}
}