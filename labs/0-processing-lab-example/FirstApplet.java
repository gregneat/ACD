import processing.core.PApplet;

public class FirstApplet extends PApplet{

  // runs upon initialization
  public void settings() {
    size(500, 500);
  }

  // runs like a while loop
  public void draw() {
    // fill() takes 3 parameters corresponding to the rgb values of the color
    fill((float)Math.random()*255, (float)Math.random()*255, (float)Math.random()*255);
    ellipse(mouseX, mouseY, 50, 50);
  }

  public void mousePressed() {
    background(65);
  }



  public static void main(String[] args){
    // name of the sketch
		String[] processingArgs = {"FirstApplet"};

    // create new instance of sketch
		FirstApplet firstApplet = new FirstApplet();

    // run the sketch
		PApplet.runSketch(processingArgs, firstApplet);
	}



}
