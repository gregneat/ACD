import java.awt.geom.*;
import java.awt.*;

public class CarWithStripe extends Car{

	Rectangle2D.Double stripe;
	
	public CarWithStripe(int xx, int yy)
	{
		super(xx,yy);
		stripe = new Rectangle2D.Double(xx,yy+5,60,10);
	}
	
	
	public void paint(Graphics2D g2)
	{
		super.paint(g2);
		g2.setColor(Color.YELLOW);
		g2.fill(stripe);
	}
	
	public void drive(int x)
	{
		super.drive(x);
		stripe.setFrame(stripe.getX()-x,stripe.getY(),60,10);
	}
	
	// public Rectangle2D getBounds()
	// {
		// super.getBounds();
	// }

	
}