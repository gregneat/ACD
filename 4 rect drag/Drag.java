import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Drag extends JPanel implements MouseListener,MouseMotionListener
{
	Rectangle2D.Double rect;
	boolean click;
	double a,b;
	static JFrame frame;
	
	public static void main(String[] args) 
	{
		frame = new JFrame("Drag");
		frame.add(new Drag());
		frame.setSize(600,300);
		
		
		frame.setUndecorated(true);
		frame.setVisible(true);
		
	}
	  
	public Drag()
	{
		rect = new Rectangle2D.Double(40,40,50,50);
		
		frame.addMouseListener(this);
		frame.addMouseMotionListener(this);
	}
  
  
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//must use graphics2D for shapes
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLUE);
		g2.fill(rect);
	}
  
	//must use all the methods of the MouseListener and MouseMotionListener interfaces
	public void mousePressed(MouseEvent e)
	{
		if(rect.contains(e.getX(),e.getY()))
		{
			click=true;
			a = e.getX()-rect.getX();
			b = e.getY()-rect.getY();
			
		}
	}
	
	public void mouseDragged(MouseEvent e)
	{
		if(click)
		{
			rect.setFrame(e.getX()-a,e.getY()-b,50,50);
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
	
	
	
	//this method is called in between repaints to reduce screen flickering
	//should be given to students
	// public void update(Graphics g)
	// {
		// Image img = createImage(getWidth(),getHeight());
		// Graphics gg = img.getGraphics();
		// paint(gg);
		// g.drawImage(img,0,0,this);
	// }
}

