import java.awt.geom.*;
import java.awt.*;
import java.awt.Font;

public class Car
{
	//private variables
	private Rectangle2D.Double body, head;
	private Ellipse2D.Double leftWheel, rightWheel;
	private String name;
	private Color color;
	private double speed;
	
	//constructors
	public Car()
	{
		int x = 0;
		int y = 100;
		body = new Rectangle2D.Double(x,y,30,10);
		head = new Rectangle2D.Double(x+5,y-10,20,10);
		leftWheel = new Ellipse2D.Double(x,y+10,7.5,7.5);
		rightWheel = new Ellipse2D.Double(x+22.5,y+10,7.5,7.5);
		name = "";
		color = Color.BLUE;
		speed = 2;
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
	
	//draws car
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(color);
		g2.fill(body);
		g2.fill(head);
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 8));
		g.drawString(name,(int)head.getX(),(int)body.getY()+5);
		g2.fill(leftWheel);
		g2.fill(rightWheel);
		String coords = "("+(int)getX()+","+(int)getY()+")";
		g.drawString(coords,(int)getX(),(int)getY()-15);	
	}
	
	//moves car
	public void drive()
	{
		body.setFrame(body.getX()+speed,body.getY(),30,10);
		head.setFrame(head.getX()+speed,head.getY(),20,10);
		leftWheel.setFrame(leftWheel.getX()+speed,leftWheel.getY(),7.5,7.5);
		rightWheel.setFrame(rightWheel.getX()+speed,rightWheel.getY(),7.5,7.5);
	}
	
	//set methods
	public void setLocation(double x, double y)
	{
		body.setFrame(x,y,30,10);
		head.setFrame(x+5,y-10,20,10);
		leftWheel.setFrame(x,y+10,7.5,7.5);
		rightWheel.setFrame(x+22.5,y+10,7.5,7.5);
	}
	public void setColor(Color c)
	{
		color = c;
	}
	public void changeSpeed(double s)
	{
		speed = s;
	}
	public void setName(String first)
	{
		name = first;
	}
	
	//accessor methods
	public boolean contains(double x, double y)
	{
		return body.contains(x,y) || head.contains(x,y) || 
			   leftWheel.contains(x,y) || rightWheel.contains(x,y);
	}
	public double getX()
	{
		return body.getX();
	}
	public double getY()
	{
		return body.getY();
	}
	public double getWidth()
	{
		return body.getWidth();
	}
	public double getHeight()
	{
		return body.getHeight()+head.getHeight()+leftWheel.getHeight();
	}
	public double getSpeed()
	{
		return speed;
	}
	
	public String toString()
	{
		//rounds speed to hundredths place
		double roundedSpeed = (int)(speed*20.0*100)/100.0;
		return name+": I am travelling at "+roundedSpeed+" mph.";
	}
}