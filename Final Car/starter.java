import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

public class starter extends JPanel implements Runnable, MouseListener
{
	//private variables
	static JFrame frame;
	//unique to each computer
	static final int SCREEN_HEIGHT = 687;
	static final int SCREEN_WIDTH = 1287;
	
	Car[] cars;
	Road[] roads;
	//index of fastest car
	int fastIndex;

	public static void main(String[] args)
	{
		frame = new JFrame("App");
		frame.setUndecorated(true);
		frame.add(new starter());
		frame.setSize(SCREEN_WIDTH,SCREEN_HEIGHT);
		frame.setVisible(true);
	}
	//creates all objects
	public starter()
	{	
		roads = new Road[(int)(SCREEN_HEIGHT/20)];
		makeRoads();
		cars = new Car[100];
		makeCars();
		printFastestCar();
		printAverageSpeed();
		
		frame.addMouseListener(this);
		Thread thread = new Thread(this);
		//calls the run function
		thread.start();
	}
	//makes random cars at random places to the left of the screen
	public void makeCars()
	{
		String[] names = new String[]{"BOB","SUE","JOE","NEATO","FALCON"};
		for(int i=0; i<cars.length; i++)
		{
			String name = names[(int)(Math.random()*names.length)];
			Color color = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
			double speed = Math.random()*5+1;
			cars[i] = new Car(Math.random()*(-SCREEN_WIDTH),Math.random()*SCREEN_HEIGHT,name,color,speed);
		}
	}
	//makes evenly spaced horizontal roads
	public void makeRoads()
	{
		for(int i=0; i<roads.length; i++)
			roads[i] = new Road(i*SCREEN_HEIGHT/20,SCREEN_WIDTH,SCREEN_HEIGHT/20-10);
	}
	
	//called by repaint
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//important to paint roads first because cars are the last layer
		for(int i=0; i<roads.length; i++)
			roads[i].paint(g);
		for(int i=0; i<cars.length; i++)
			cars[i].paint(g);
	}
	
	public void printFastestCar()
	{
		Car fastest = new Car();
		double topSpeed = 0.0;
		for(int i=0; i<cars.length; i++)
		{
			if(cars[i].getSpeed() > topSpeed)
			{
				topSpeed = cars[i].getSpeed();
				fastest = cars[i];
				fastIndex = i;
			}	
		}	
		fastest.setName("Lightning McQueen");
		System.out.println("The fastest car is "+fastest+" Give him a ticket!");
	}
	public void printAverageSpeed()
	{
		double[] speeds = new double[cars.length];
		double sum = 0;
		for(int i=0; i<speeds.length; i++)
		{
			speeds[i] = cars[i].getSpeed();
			sum += speeds[i];
		}	
		//rounds to hundredths place
		double roundedAverage = (int)((sum/(double)(speeds.length))*20.0*100)/100.0;
		System.out.println("The average speed of all the cars is: "+roundedAverage+" mph.");
	}
	public void run()
	{
		while(true)
		{
			for(int i=0;i<cars.length;i++)
			{
				//recycles cars if they go off screen
				if(cars[i].getX() >= SCREEN_WIDTH)
				{
					cars[i].setLocation(Math.random()*(-SCREEN_WIDTH),(int)(Math.random()*SCREEN_HEIGHT));
				}
				cars[i].drive();
			}
			repaint();
		
			try { Thread.sleep(15); }
			catch (InterruptedException e) { }
		}
	}
	//little game designed to click on the fastest car
	public void mousePressed(MouseEvent e)
	{
		boolean hit = false;
		if(cars[fastIndex].contains(e.getX(), e.getY()))
		{
			System.out.println("You caught the fastest car!");
			hit = true;
		}
		for(int i=cars.length-1; i>=0; i--)
		{
			if(cars[i].contains(e.getX(), e.getY()) && i!=fastIndex && !hit)
			{
				System.out.println("Wrong car. Try again.");
				hit = true;
				break;
			}
		}
		for(int i=0; i<roads.length; i++)
		{
			if(roads[i].contains(e.getX(),e.getY()) && !hit)
			{
				System.out.println("You hit the road. Try again.");
				hit = true;
				break;
			}
		}	
	}
	public void mouseReleased(MouseEvent e){}  
	public void mouseClicked(MouseEvent e){} 
	public void mouseEntered(MouseEvent e){} 
	public void mouseExited(MouseEvent e){}
}