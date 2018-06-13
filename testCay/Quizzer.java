public class Quizzer {

        public static void main(String args[])
        {
			Rectangle box = new Rectangle(5,10,60,80);
			box.draw();
			for(int i = 0;i<10;i++)
			{
				System.out.println("hi!");
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

}
