import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class ChemApp extends JPanel implements Runnable,KeyListener,MouseListener{

	private Thread runner;
	private int y=0,count=0,right=0,wrong=0,diff=100;
	boolean gameOver,correct,incorrect;
	private Beaker c;
	private String[]is,total;
	private ArrayList<String> total2,insolu,bob;
	private ArrayList<Integer> xCoord,yCoord;
	private static JFrame frame;
	
	public static void main(String[] args) {
		frame = new JFrame("Chem App");
		frame.add(new ChemApp());
		frame.setSize(600,600);
		frame.setVisible(true);
	}

	public ChemApp()
	{
		c = new Beaker(150,500);
		
		total = new String[]{"KSO4","NaSO4","NaCl","KBr","LiOH","NH4Cl","BaCl","KOH","AgNO3","Ag(C2H3O2)","Pb(NO3)2","AlCl3","RbNO3","CsNO3","Ba(OH)2","Na2S","Na(C2H3O2)","KI","NH4Br","K2S","AgCl","Zn(NO3)2","BeBr2","AgF","Ca3(PO4)2","Ag3PO4","BaF2","MgF2","PbF2","CaCO3","SrCO3","BaCO3","FeCO3","PbCO3","Sr3(PO4)2","CaF2","CdS","FeS","ZnS","Ag2S","Fe(OH)3","Al(OH)3","Co(OH)2","MgCl2","AgCl","HgS","PbBr2","Mg(OH)2"};
		is = new String[]{"Ca3(PO4)2","Ag3PO4","BaF2","MgF2","PbF2","CaCO3","SrCO3","BaCO3","FeCO3","PbCO3","Sr3(PO4)2","CaF2","CdS","FeS","ZnS","Ag2S","Fe(OH)3","Al(OH)3","Co(OH)2","MgCl2","AgCl","HgS","PbBr2","Mg(OH)2"};
		shuffle();
		
		bob = new ArrayList<String>();
		
		total2 = new ArrayList<String>();
		xCoord = new ArrayList<Integer>();
		yCoord = new ArrayList<Integer>();
		for(int i=0;i<total.length;i++)
		{
			total2.add(total[i]);
			xCoord.add((int)(350*Math.random()+125));
			yCoord.add(-diff*i);
		}
		
		insolu = new ArrayList<String>();
		for(int i=0;i<is.length;i++)
		{
			insolu.add(is[i]);
		}
		
		frame.addKeyListener(this);
		frame.addMouseListener(this);
	}
	
	private void shuffle()
	{
		for (int k=total.length-1;k>0;k--) {
			int howMany = k + 1;
			int start = 0;
			int randPos = (int) (Math.random() * howMany) + start;
			String temp = total[k];
			total[k] = total[randPos];
			total[randPos] = temp;
		}
	}
	
	public void mouseClicked(MouseEvent e)
	{
		count++;
		if(count==2)
		{
			runner = new Thread(this);
			runner.start();
		}
	} 
 
	public void run() 
	{
		int end = diff*(total.length-1)+620;
		while (y<end) 
		{
			y+=1.5;
			repaint();
			try { runner.sleep(18); }
			catch (InterruptedException e) { }
		}
		gameOver=true;
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(new Color(255,178,102));
		g2.fill(new Rectangle2D.Double(0,0,frame.getContentPane().getWidth(),frame.getContentPane().getWidth()));
		
		g.setColor(Color.BLACK);
		if(count<2)
		{
			g.drawString("Double click to start",200,100);
			g.drawString("Use left and right arrow keys to move beaker.",150,120);
			g.drawString("Make sure to catch the insoluble compounds and avoid the soluble ones!!",100,140);
		}
	
		
		c.paint(g2);
		
		g.drawString("Right: "+right,20,20);
		g.drawString("Wrong: "+wrong,20,40);
		
		g.setColor(Color.BLACK);
		for(int i=0;i<total2.size();i++)
		{	
			g.drawString(total2.get(i),xCoord.get(i),yCoord.get(i)+y);
			if(c.getX()<=xCoord.get(i)&&(c.getX()+c.getWidth())>=xCoord.get(i)&&c.getY()==yCoord.get(i)+y&&checkInsoluble(i))
			{
				total2.remove(i);xCoord.remove(i);yCoord.remove(i);
				i--;right++;
				correct = true;incorrect = false;
				
				if(bob.size()==1){bob.remove(0);bob.add("CORRECT");}
				else{bob.add("CORRECT");}	
			}
			else if(c.getX()<=xCoord.get(i)&&(c.getX()+c.getWidth())>=xCoord.get(i)&&c.getY()==yCoord.get(i)+y&&!checkInsoluble(i))
			{
				total2.remove(i);xCoord.remove(i);yCoord.remove(i);
				i--;wrong++;
				correct = false;incorrect = true;
				
				if(bob.size()==1){bob.remove(0);bob.add("WRONG");}
				else{bob.add("WRONG");}	
			}
		}
		
		if(correct||incorrect)
		{
			g.drawString(bob.get(0),(int)c.getX()+11,(int)(c.getY()+30));
		}
		
		if(gameOver)
		{
			removeKeyListener(this);
			g.setColor(Color.BLACK);
			g.drawString("GAME OVER",200,100);
			int h = 24+right-wrong;
			g.drawString("You got "+h+" out of 48!!",180,120);
		}
	}
	
	public boolean checkInsoluble(int x)
	{
		for(int i=0;i<insolu.size();i++)
		{
			if(total2.get(x).equals(insolu.get(i)))
			{
				insolu.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public void update(Graphics g)
	{
		Image img = createImage(getWidth(),getHeight());
		Graphics gg = img.getGraphics();
		paint(gg);
		g.drawImage(img,0,0,this);
	}
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == 37)
		{
			c.setLocation(c.getX()-10,c.getY());
		}
		else if(e.getKeyCode() == 39)
		{
			c.setLocation(c.getX()+10,c.getY());	
		}
		repaint();
	}
	
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void mouseReleased(MouseEvent e){}  
	public void mousePressed(MouseEvent e){} 
	public void mouseEntered(MouseEvent e){} 
	public void mouseExited(MouseEvent e){}
		
}

class Beaker{

	private Rectangle2D.Double a;
	private Ellipse2D.Double b;
	
	public Beaker(int xx, int yy)
	{
		a = new Rectangle2D.Double(xx,yy,80,60);
		b = new Ellipse2D.Double(xx,yy-10,80,20);
	}
	
	public void setLocation(double x, double y)
	{
		a.setFrame(x,y,a.getWidth(),a.getHeight());
		b.setFrame(x,y-10,b.getWidth(),b.getHeight());
	}
	
	public void paint(Graphics2D g2)
	{
		g2.setColor(new Color(204,0,0));
		g2.fill(a);
		g2.setColor(new Color(100,0,0));
		g2.fill(b);
	}
	
	public double getX()
	{
		return a.getX();
	}
	
	public double getY()
	{
		return a.getY();
	}
	
	public double getWidth()
	{
		return a.getWidth();
	}
}