import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class starter extends JPanel implements Runnable
{
	static JFrame frame;
	
	Rectangle2D.Double[] rects;

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
		
		rects = new Rectangle2D.Double[10];
		for(int i=0;i<rects.length;i++)
		{
			int y = (int)(Math.random()*550);
			rects[i] = new Rectangle2D.Double(-i*100,y,50,50);
		}
		
		
		Thread thread = new Thread(this);
		thread.start();//calls the run function
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLUE);
		for(int i=0;i<rects.length;i++)
		{
			g2.fill(rects[i]);
		}

	}
	
	
	public void run()
	{
		while(true)
		{
			for(int i=0;i<rects.length;i++)
			{
				int x = (int)rects[i].getX()+2;
				rects[i].setFrame(x,rects[i].getY(),50,50);
			}
			repaint();
			
		
			try { Thread.sleep(15); }
			catch (InterruptedException e) { }
		}
	}
}

