import pkg.*;

public class Bus implements Vehicle{

	private Rectangle body;
	private Ellipse wheel1,wheel2;
	
	public Bus(int xx, int yy)
	{
		body = new Rectangle(xx,yy,100,40);
		wheel1 = new Ellipse(xx,yy+40,15,15);
		wheel2 = new Ellipse(xx+85,yy+40,15,15);
	}
	
	
	public void draw()
	{
		body.setColor(Color.YELLOW);
		wheel1.setColor(Color.BLACK);
		wheel2.setColor(Color.BLACK);
		
		body.fill();
		wheel1.fill();
		wheel2.fill();
	}
	
	public void drive(int x)
	{
		body.translate(x,0);
		wheel1.translate(x,0);
		wheel2.translate(x,0);
	}
	
	public Rectangle getBounds()
	{
		Rectangle a = new Rectangle(body.getX(),body.getY(),100,55);
		return a;
	}
}