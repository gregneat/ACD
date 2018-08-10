import pkg.*;

public class Car implements Vehicle{

	private Rectangle body1,body2;
	private Ellipse wheel1, wheel2;
	
	public Car(int xx, int yy)
	{
		body1 = new Rectangle(xx,yy,60,20);
		body2 = new Rectangle(xx+10,yy-20,40,20);
		wheel1 = new Ellipse(xx,yy+20,15,15);
		wheel2 = new Ellipse(xx+45,yy+20,15,15);
	}
	
	public void draw()
	{
		body1.setColor(Color.BLUE);
		body2.setColor(Color.BLUE);
		wheel1.setColor(Color.BLACK);
		wheel2.setColor(Color.BLACK);
		
		body1.fill();
		body2.fill();
		wheel1.fill();
		wheel2.fill();
	}
	
	public void drive(int x)
	{
		body1.translate(x,0);
		body2.translate(x,0);
		wheel1.translate(x,0);
		wheel2.translate(x,0);
	}
	
	public Rectangle getBounds()
	{
		Rectangle a = new Rectangle(body1.getX(),body2.getY(),60,40);
		return a;
	}
}