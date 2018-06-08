import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class starter extends JPanel implements MouseListener
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
		
		//add mouse listener to frame
		frame.addMouseListener(this);
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLUE);
		g2.fill(rect);
		
		g.setColor(Color.BLACK);
		g.drawString(Integer.toString(count),(int)rect.getX(),30);
	}
	
	public void mouseClicked(MouseEvent e)
	{
		//incrementing rectangle location
		count = count+10;
		rect.setFrame(count,40,50,50);
		repaint();
	}
	
	public void mouseReleased(MouseEvent e){}  
	public void mousePressed(MouseEvent e){} 
	public void mouseEntered(MouseEvent e){} 
	public void mouseExited(MouseEvent e){}
}

