import javax.swing.*;

public class starter extends JPanel
{
	static JFrame frame;
	
	public static void main(String[] args) {
		frame = new JFrame("First Frame");
		frame.add(new starter());
		frame.setSize(600,600);
		frame.setVisible(true);
	}
	
	public starter()
	{
		
	}
	
}

