import javax.swing.*;
import java.awt.event.*;

public class MyMouseListener implements MouseListener, MouseMotionListener {
	
	public MyMouseListener()
	{
		Canvas.getFrame().addMouseListener(this);
		Canvas.getFrame().addMouseMotionListener(this);
	}
	
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}	
	public void mousePressed(MouseEvent e){} 
	public void mouseEntered(MouseEvent e){} 
	public void mouseExited(MouseEvent e){}
	public void mouseDragged(MouseEvent e){}
	public void mouseMoved(MouseEvent e){}
	
	
	
}