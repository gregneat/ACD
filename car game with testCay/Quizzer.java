import java.awt.event.*;
import pkg.*;

public class Quizzer extends MyMouseListener
{
	static Vehicle[] arr;
	static Player p;
	static boolean lose;
	
    public static void main(String args[])
    {
		//intializes Quizzer object so MyMouseListener is contructed and methods can be accessed
		Quizzer initListener = new Quizzer();
			
		p = new Player(50,300);
		p.draw();
		
		arr = new Vehicle[100];
		for(int i=0;i<arr.length;i++)
		{
			if(i%2==0)
			{
				arr[i] = new Car(1200+100*i,(int)(600*Math.random()));
				arr[i].draw();
			}
			else
			{
				arr[i] = new Bus(1200+100*i,(int)(600*Math.random()));
				arr[i].draw();
			}
		}
		
		int x=1200+arr.length*100;	
		while (!lose && x>0) 
		{
			x-=2;
			for(int i = 0;i<arr.length;i++)
			{
				Canvas.pause(300);
				arr[i].drive(-2);

				if(p.crash(arr[i])||p.getY()<=0||p.getY()>=600)
				{
					lose = true;
					break;
				}
			}
		}
			
		if(lose)
		{
			System.out.print("You lose");
		}
		else
		{
			System.out.print("You win");
		}
			
	}	
		
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			p.moveTo(p.getX(),p.getY()-15);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			p.moveTo(p.getX(),p.getY()+15);	
		}
	}
}
