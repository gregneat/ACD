import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class starter extends JPanel
{
	static JFrame frame;
	
	Car c;

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
		
		c = new Car(50,50);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.BLUE);
		c.paint(g2);

	}
}

