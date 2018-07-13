import processing.core.PApplet;

public class MoveRect extends PApplet{

  private int posX;

  // runs upon initialization
  public void settings() {
    posX = 0;
    size(500, 500);
  }

  // runs like a while loop
  public void draw() {
    rect(posX, 250, 50, 50);
    posX++;
  }

  public static void main(String[] args){
    // name of the sketch
		String[] processingArgs = {"FirstApplet"};
    // create new instance of sketch
		MoveRect firstApplet = new MoveRect();
    // run the sketch
		PApplet.runSketch(processingArgs, firstApplet);
	}
}
