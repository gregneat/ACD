import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class starter extends JPanel implements MouseListener
{
	Rectangle2D.Double yes, no;
	static JFrame frame;
	boolean green,red;
	
	public static void main(String[] args) 
	{
		frame = new JFrame("App");
		frame.add(new starter());
		frame.setSize(600,600);
		frame.setUndecorated(true);
		frame.setVisible(true);
	}
	
	public starter()
	{
		frame.addMouseListener(this);
		yes = new Rectangle2D.Double(100,90,30,30);
		no = new Rectangle2D.Double(150,90,30,30);
	}
  
	// paint method draws shapes on jframe
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		if(green)
		{
			g2.setColor(Color.GREEN);
			g2.fill(new Rectangle2D.Double(0,0,600,600));
		}
		if(red)
		{
			g2.setColor(Color.RED);
			g2.fill(new Rectangle2D.Double(0,0,600,600));
		}
		
		g.setColor(Color.BLACK);
		String a = new String("Would you like to start the game?");
		g.drawString(a,80,60);
		g.drawString("yes",110,110);
		g.drawString("no",160,110);
	
		g2.draw(yes);
		g2.draw(no);
		
	}
  
	//must use all the methods of the MouseListener and MouseMotionListener interfaces
  
	public void mouseClicked(MouseEvent e)
	{
		if(yes.contains(e.getX(),e.getY()))
		{
			green=true;
			repaint();
		}
		else if(no.contains(e.getX(),e.getY()))
		{
			red=true;
			repaint();
		}
	} 
  
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}  
	public void mouseEntered(MouseEvent e){} 
	public void mouseExited(MouseEvent e){}
}

