package pkg;
import javax.swing.*;
import java.awt.event.*;

public class MyMouseListener implements MouseListener, MouseMotionListener, KeyListener {
	
	public MyMouseListener()
	{
		Canvas.getFrame().addMouseListener(this);
		Canvas.getFrame().addMouseMotionListener(this);
		Canvas.getFrame().addKeyListener(this);
	}
	
	public void mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}	
	public void mousePressed(MouseEvent e){} 
	public void mouseEntered(MouseEvent e){} 
	public void mouseExited(MouseEvent e){}
	public void mouseDragged(MouseEvent e){}
	public void mouseMoved(MouseEvent e){}
	public void keyTyped(KeyEvent e){}
	public void keyPressed(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	
	
	
}