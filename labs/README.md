# Example Lab Directory

This directory serves as an example of what a possible lab structure would look like. It demonstrates two concepts that could be used in the ACD: __*processing*__ and __*test driven development*__

### Processing

[Processing](https://processing.org/) is a java library which is similar to objectdraw and could serve as an alternative to JFrame. I am not as well versed in JFrame, so it might end up being the better choice eventually, but I feel that it is worth our time to highlight the pros and cons and make the decision from there as to which would best suit the ACD.

#### Pros

###### 1. Code is less abrasive at first glance

  For newcomers to programming, the apparent complexity of the code they see is a factor worth considering. At least from what I can see, it looks like Processing wins out over JFrame in this regard. For instance, refer to the difference between the "rect move no click" file versus "0-processing-lab-example". Both do the same thing - move a rectangle across the screen - but the Processing file does it in about half the lines of code with less foreign concepts from the respective framework.

###### 2. Plenty of documentation and community support

  Processing has a wonderfully active community, and their documentation is very cohesive and complete. This could be beneficial if people wanted to go off and create cool stuff on their own.

###### 3. Easy to transition to javascript/p5.js

  The Processing library was implemented into a javascript framework called [p5.js](https://p5js.org/). It's a very popular framework with *tons* of documentation and community activity, and has essentially the same concepts and methods as the java version. This could allow for a wonderfully seamless transition from Java in the first quarter to javascript in the second quarter for the buffet class, assuming the goal is still for the buffet and AP classes to be as integrated as possible in the first quarter.

#### Cons

###### "Purity"

  For the java purist, this library might have a bit too much "magic" happening in the background. For instance, creating a shape(rectangle for instance) in JFrame involves

  ```java
  rect = new Rectangle2D.Double(x,y,width,height);
  ```

  while in Processing, this same action is done with

  ```java
  rect(x,y,width,height);
  ```

  This is largely just a product of how each of the libraries are structured, as the `rect()` method itself is what creates a new object.

  However, Processing can still create other classes, like a `Ball` for instance.

  ```java
  public class Ball {
    private PApplet sketch;

    public Ball(PApplet sketch) {
      this.sketch = sketch;
    }

    /* other methods */
  }
  ```

  This can be instantiated in another class with

  ```java
  Ball myBall = new Ball(this); //where this is the PApplet
  ```

  This could be helpful in bringing to life the idea of AP making the classes, and buffet using them.

### Test Driven Development

I might write more about this, but just as a preview, codecademy has a [cool article](https://news.codecademy.com/test-driven-development/) about Test Driven Development- what it is, why its used, and more. Essentially, pretty much the entire industry uses test driven development when they write code- which involves writing tests that fail, and then writing the actual code which will make these tests pass.

I feel that implementing this in some way in the course curriculum not only introduces people to a concept that they will 100% run into if they continue into the field, but is also incredibly useful in the development process. It modifies how you think about the code you're trying to write, forcing you to wrap your head around *how* you're going to write your code as apposed to jumping into an empty java file and fiddling around.

The "1-testing-lab-example" has relevant files, and will contain an example of how testing could be used in a lab.

### Conclusion

This is all I'm writing for now, might come up with more info later. Post in the slack if anyone has questions.
