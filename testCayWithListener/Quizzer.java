import java.awt.event.*;


public class Quizzer extends MyMouseListener
{
        public static void main(String args[])
        {
			new Quizzer();
			
			Rectangle box = new Rectangle(5,10,60,80);
			box.draw();
			for(int i = 0;i<10;i++)
			{
				Canvas.pause(50000);
				// for(long j=0;j<100;j++)
				// {
					// for(long k=0;k<100;k++)
					// {
						// System.out.print(i);
					// }
				// }
				box.translate(20,20);	
			}
		}
		
		public void mouseClicked(MouseEvent e)
		{
			System.out.print("hello");
		}

}
