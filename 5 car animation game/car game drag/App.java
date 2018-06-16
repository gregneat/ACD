import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
public class App extends JPanel implements Runnable,MouseMotionListener,MouseListener{

	Rectangle2D.Double[] arr;
	Thread runner;
	int xdiff,ydiff,y=0;
	boolean gameOver,click;
	Car c;
	static JFrame frame;
	
	public static void main(String[] args) 
	{
		frame = new JFrame("App");
		frame.add(new App());
		frame.setSize(600,600);
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
	
	public App()
	{
		c = new Car(150,500);
		
		//array of falling blocks
		arr = new Rectangle2D.Double[50];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = new Rectangle2D.Double(600*Math.random(),-30*i,10,10);
		}
		
		frame.addMouseListener(this);
		frame.addMouseMotionListener(this);
		runner = new Thread(this);
		runner.start();
	}
 
	//this method is called by runner.start() and starts a java thread
	//this is the time based part of the code so the blocks can fall without mouse input
	public void run() {
		//end is the position of the block that starts farthest up plus length of applet
		int end = 30*(arr.length-1)+600;
		while (!gameOver && y<end) 
		{
			y+=2;
			setScreen();
			repaint();
			
			//this part pauses the method for 15 milliseconds so it appears the blocks are falling
			try { Thread.sleep(15); }
			catch (InterruptedException e) { }
		}
		gameOver=true;
		repaint();
	}

	//repaints all the objects in the applet
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
	
		Graphics2D g2 = (Graphics2D)g;
		c.paint(g2);
			
		g2.setColor(Color.RED);
		for(int i=0;i<arr.length;i++)
		{
			g2.fill(arr[i]);
		}

		
		if(gameOver)
		{
			frame.removeMouseListener(this);
			frame.removeMouseMotionListener(this);
			g.setColor(Color.BLACK);
			g.drawString("GAME OVER",200,100);
		}
	
	}
	
	//this method sets the new position of the falling blocks
	//it also checks if the car intersects the falling blocks
	public void setScreen()
	{
		for(int i=0;i<arr.length;i++)
		{
			arr[i].setFrame(arr[i].getX(),-30*i+y,10,10);
			if(c.contains(arr[i]))
			{
				gameOver = true;
				repaint();
				
			}
		}
	}
	
	//dragging the car object, lines 75-95
	public void mousePressed(MouseEvent e)
	{
		if(c.contains(e.getX(),e.getY()))
		{
			click=true;
			xdiff = (int)(e.getX()-c.getX());
			ydiff = (int)(e.getY()-c.getY());
		}
	}
	public void mouseDragged(MouseEvent e)
	{
		if(click)
		{
			c.setLocation((int)e.getX()-xdiff,(int)e.getY()-ydiff);
			repaint();
		}
	}
	public void mouseReleased(MouseEvent e)
	{
		click=false;
	}  
	
	public void mouseClicked(MouseEvent e){} 
	public void mouseEntered(MouseEvent e){} 
	public void mouseExited(MouseEvent e){}
	public void mouseMoved(MouseEvent e){}
	
	
}