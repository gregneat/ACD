posX = 0;

function setup() {
  createCanvas(500, 500);
}

function draw() {
  background(220);
  fill(255);
  rect(posX,250,50,50);
  posX++;
}
