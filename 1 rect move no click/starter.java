import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class starter extends JPanel implements Runnable
{
	Rectangle2D.Double rect;
	int count=0;
	static JFrame frame;
	
	public static void main(String[] args) {
		frame = new JFrame("Chem App");
		frame.add(new starter());
		frame.setSize(1200,600);
		frame.setVisible(true);
	}
	
	public starter()
	{
		rect = new Rectangle2D.Double(0,40,50,50);
		
		Thread thread = new Thread(this);
		thread.start();//calls the run function
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		//must use 2d graphics for shapes
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLUE);
		g2.fill(rect);
		//regualr graphics for strings
		g.setColor(Color.BLACK);
		g.drawString(Integer.toString(count),(int)rect.getX(),30);
	}
	
	public void run()
	{
		while(true)
		{
			//incrementing rectangle location
			count = count+1;
			rect.setFrame(count,40,50,50);
			repaint();//calls paintComponent method
		
			//pauses screen evry 15 ms to create animation
			try { Thread.sleep(15); }
			catch (InterruptedException e) { }
		}
	}
}

