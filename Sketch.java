import processing.core.PApplet;

public class Sketch extends PApplet {

// variables and snow loop
  
  float playerX = 250;
  float playerY = 250;
  int lives = 3;
	float[] circleY = new float[25];
  boolean[] SnowAppearance = new boolean[25];
  
  public void settings() {
	
    size(500, 500);
    for (int i = 0; i < circleY.length; i++) {
    circleY[i] = random(height);
    SnowAppearance[i] = true;
  }
  }

  public void setup() {
    background(0);
  }

  public void draw() {

    // puts player in the middle of the screen
    
    background(0);
    fill(0,0, 255);
    ellipse(playerX, playerY, 25, 25);
    for (int i = 0; i < circleY.length; i++) {
    float circleX = width * i / circleY.length;
    if (SnowAppearance[i]) {
      fill(255,255,255);
      ellipse(circleX, circleY[i], 25, 25);
    }

    circleY[i]++;

    if (circleY[i] > height) {
      circleY[i] = 0;
    }

    // this is where the player hits the snow and the lives go down
      
    if (playerX >= circleX - 15 && playerX <= circleX + 15 && playerY >= circleY[i] - 15 && playerY <= circleY[i] + 15 && SnowAppearance[i])
    {
      lives = lives - 1;
      SnowAppearance[i] = false;
    }

    // this is where i click the snow to make it go away
      
    if (mouseX >= circleX - 15 && mouseX <= circleX + 15 && mouseY >= circleY[i] - 15 && mouseY <= circleY[i] + 15 && SnowAppearance[i] && mousePressed == true)
    {
      SnowAppearance[i] = false;
    }
    if (keyPressed) {
      
      if (keyCode == UP){
        circleY[i] = circleY[i] - 1;
      }
      if (keyCode == DOWN){
        circleY[i] = circleY[i] + 3;
      }
    }
  }

      // lives
    
    if (lives >= 3) {
      fill(255,0,0);
      rect(440, 15, 50, 50);
      rect(380, 15, 50, 50);
      rect(320, 15, 50, 50);
    }
    if (lives == 2) {
      fill(255,0,0);
      rect(440, 15, 50, 50);
      rect(380, 15, 50, 50);
    }
    if (lives == 1) {
      fill(255,0,0);
      rect(440, 15, 50, 50);
    }
    if (lives < 1) {
      background(255, 255, 255);
    }
    
    
  }

    // different keys doing things
  
  public void keyPressed() {
    if (key == 'w'){
      playerY -= 5;
    }
    if (key == 's'){
      playerY += 5;
    }
    if (key == 'a'){
      playerX -= 5;
    }
    if (key == 'd'){
      playerX += 5;
    }
    
  }
  
  // define other methods down here.
}