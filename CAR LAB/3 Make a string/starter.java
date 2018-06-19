import javax.swing.*;
import java.awt.*;

public class starter extends JPanel 
{
	static JFrame frame;
	
	String joe;
	
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
		
		
		joe = new String("Hello World");
		//String joe = new String("Hello World");
		//String joe = "Hello World";
		
		System.out.print(joe);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.drawString(joe,20,40);
	}

}

