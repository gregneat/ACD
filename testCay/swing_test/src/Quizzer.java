public class Quizzer implements InputControl {

	static Rectangle box;

	public static void main(String args[])
        {
			MouseController mC = new MouseController(Canvas.getInstance(),new Quizzer());
			box = new Rectangle(5,10,60,80);
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


		public void onMouseClick(double x, double y){
        	System.out.println("Clicked at :" + x + " " + y);
			box.translate(x - box.getX(),y - box.getY());
		}
}
