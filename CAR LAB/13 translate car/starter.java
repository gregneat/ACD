import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class starter extends JPanel implements Runnable
{
	static JFrame frame;
	
	Car[] cars;

	public static void main(String[] args) {
		frame = new JFrame("App");
		frame.add(new starter());
		frame.setSize(600,600);
		frame.setVisible(true);
	}
	
	public starter()
	{
		Color a = new Color(0,255,0);
		setBackground(a);
		
		cars = new Car[10];
		for(int i=0;i<cars.length;i++)
		{
			int y = (int)(Math.random()*550);
			cars[i] = new Car(-i*100,y);
		}
		
		
		Thread thread = new Thread(this);
		thread.start();//calls the run function
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLUE);
		for(int i=0;i<cars.length;i++)
		{
			cars[i].paint(g2);
		}

	}
	
	
	public void run()
	{
		while(true)
		{
			for(int i=0;i<cars.length;i++)
			{
				cars[i].drive(2);
			}
			repaint();
			
		
			try { Thread.sleep(15); }
			catch (InterruptedException e) { }
		}
	}
}

