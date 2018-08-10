import pkg.*;

public class Player{

	private Ellipse face, eye1, eye2;
	private Rectangle mouth;
	
	public Player(int xx, int yy)
	{
		face = new Ellipse(xx,yy,40,40);
		eye1 = new Ellipse(xx+5,yy+10,10,10);
		eye2 = new Ellipse(xx+25,yy+10,10,10);
		mouth = new Rectangle(xx+10,yy+30,20,2);
	}
	
	
	public void draw()
	{
		face.setColor(Color.BLUE);
		eye1.setColor(Color.YELLOW);
		eye2.setColor(Color.YELLOW);
		mouth.setColor(Color.YELLOW);
		
		face.fill();
		eye1.fill();
		eye2.fill();
		mouth.fill();
		
	}
	
	public boolean crash(Vehicle v)
	{
		if(face.contains(v.getBounds()))
		{
			return true;
		}
		return false;
	}
	
	public void moveTo(double x, double y)
	{
		face.moveTo(x,y);
		eye1.moveTo(x+5,y+10);
		eye2.moveTo(x+25,y+10);
		mouth.moveTo(x+10,y+30);
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