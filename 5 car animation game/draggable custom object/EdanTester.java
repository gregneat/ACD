import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EdanTester extends JPanel implements MouseListener,MouseMotionListener
{
	Edan test;
	double a,b;
	boolean click;
	Point lastPoint;
	static JFrame frame;
	
	public static void main(String[] args) 
	{
		frame = new JFrame("App");
		frame.add(new EdanTester());
		frame.setSize(1200,600);
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
	
	public EdanTester()
	{
		frame.addMouseListener(this);
		frame.addMouseMotionListener(this);
		test = new Edan(60,60);
	}
  
	// paintComponent method draws shapes on applet window
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		test.paint(g);
	}
  
	//must use all the methods of the MouseListener and MouseMotionListener interfaces
	public void mousePressed(MouseEvent e)
	{
		if(test.contains(e.getX(),e.getY()))
		{
			click=true;
			a = e.getX()-test.getX();
			b = e.getY()-test.getY();
		}
	}
  
	public void mouseDragged(MouseEvent e)
	{
		if(click)
		{
			test.setLocation(e.getX()-a,e.getY()-b);
			repaint();
		}
	}
  
	public void mouseReleased(MouseEvent e)
	{
		click=false;
	}  
  
	//must be implemented but do not have to be used
	public void mouseClicked(MouseEvent e){} 
	public void mouseEntered(MouseEvent e){} 
	public void mouseExited(MouseEvent e){}
	public void mouseMoved(MouseEvent e){}
}

