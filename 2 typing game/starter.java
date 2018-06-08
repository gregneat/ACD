import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.*;

public class starter extends JPanel implements KeyListener
{
	Rectangle2D.Double rect,background;
	int count=0,mistakes=0,numOfWords=1,xCoord=75;
	double startTime=0;
	String game = "i go to crescenta valley high school";
	String s = "Start: ";
	Font font1 = new Font("Serif",Font.BOLD, 20);
	static JFrame frame;
	
	public static void main(String[] args) 
	{
		frame = new JFrame("Typing Game");
		frame.add(new starter());
		frame.setSize(600,300);
		frame.setVisible(true);
	}
	
	public starter() 
	{
		///intializes background rectangle and moving rectangle
		rect = new Rectangle2D.Double(xCoord,50,600,25);
		background = new Rectangle2D.Double(0,0,600,300);
		
		//counts # of spaces in game string to get # of words
		countSpaces();
		
		//adds key listener to frame
		frame.addKeyListener(this);
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.GREEN);
		//draws the background rectangle
		g2.fill(background);
		
		g.setColor(Color.BLACK);
		//tells user to double click at beginning of game
		if(count==0)
		{
			g.drawString("Please double click to focus the keyboard",40,40);
		}
		
		g.setFont(font1);
		//draws the phrase to be typed 
		g.drawString("Type: "+game,10,70);
		//draws what the user typed so far
		g.drawString(s,10,100);	
		
		//draws the rectangle that is moving across screen
		g2.setColor(Color.GREEN);
		g2.fill(rect);

		//only runs at end of game
		if(count==game.length())
		{
			//calculates # of words per minute
			double elapsedTime = (double)(System.currentTimeMillis()-startTime)/60000;
			int wpm = (int)(numOfWords/elapsedTime);
	
			//prints out wpm and # of mistakes made while typing
			g.setColor(Color.black);
			g.drawString("You type "+wpm+" words per minute.",100,150);
			g.drawString("You made "+mistakes+" mistake(s).",100,170);				
		}
    }
  
	public void keyPressed(KeyEvent e) 
	{
		//gets the character that user types and converts to string
		char cc = e.getKeyChar();
		String c = Character.toString(cc);
		
		//only runs if the user has not finished typing phrase
		if(count<game.length())
		{
			//checks if character typed is equal to the next letter in the game string
			if(c.equals(game.substring(count,count+1)))
			{
				//gets the time when user starts typing
				if(count==0)
				{
					startTime = (double)System.currentTimeMillis();
				}
				
				s = s + c;//updates the user's string that will be printed on the screen
				count++;//counts which letter the user is currently on in the game string
				
				//moves rectangle that is blocking the game string over 10 units
				xCoord+=10;
				rect.setFrame(xCoord,50,rect.getWidth(),rect.getHeight());
				
				//calls paintComponent method to redraw the screen
				repaint();
			}
			
			//checks if character typed is not equal to next letter in the game string
			else if(!c.equals(game.substring(count,count+1)))
			{
				mistakes++;
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
	//this method counts number of spaces to see how many words are in game string
	//can be created by students
	private void countSpaces()
	{
		for(int i=0;i<game.length();i++)
		{
			if(game.substring(i,i+1).equals(" "))
			{
				numOfWords++;
			}
		}
	}
	
	//this method can be used to draw multiline game strings
	//can be created by students
	private void drawString(Graphics g, String text, int x, int y) 
	{
		for (String line : text.split("\n"))
		{
			g.drawString(line, x, y+=20);
		}	
	}
	
	
	//this method is called in between repaints to reduce screen flickering
	//should be given to students
	public void update(Graphics g)
	{
		Image img = createImage(getWidth(),getHeight());
		Graphics gg = img.getGraphics();
		paint(gg);
		g.drawImage(img,0,0,this);
	}
  
}

