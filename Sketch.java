import processing.core.PApplet;

public class Sketch extends PApplet {
	
  // Declare Arrays for Circle Location and if Circle is visible or active 
  float[] circleY= new float [30];
  float[] circleX= new float [30];
  boolean[] boolSnowVisible = new boolean [30];
  boolean[] boolSnowActive = new boolean [30];

  // Snowball Fall Speed
  int intCircleSpeed = 2;

  // Booleans for if snowball is falling fast or slow
  boolean boolCircleSlow = false;
  boolean boolCircleFast = false;

  // Initial Location of player ball
  float floatPlayerCircleX = 300;
  float floatPlayerCircleY = 300;

  // Booleans for player ball movement
  boolean boolPlayerCircleLeft = false;
  boolean boolPlayerCircleRight = false;
  boolean boolPlayerCircleUp = false;
  boolean boolPlayerCircleDown = false;

  // int and bool for lives
  int intLives = 3;
  boolean boolAlive = true;

  public void settings() {
	// put your size call here
    size(800, 800);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(50);
    for (int i = 0; i < circleY.length; i++){
      circleY[i] = random(height);
      circleX[i] = random(width);
      boolSnowVisible[i] = true;
      boolSnowActive[i] = true;
    }
  }
    
  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    if (boolAlive){
      background(50);

    // Draws player ball and controls player movement
      fill(0, 0, 255);
      ellipse(floatPlayerCircleX, floatPlayerCircleY, 20, 20);
      if (boolPlayerCircleRight){
        floatPlayerCircleX += 5;
      }
      if (boolPlayerCircleLeft){
        floatPlayerCircleX -= 5;
      }
      if (boolPlayerCircleUp){
        floatPlayerCircleY -= 5;
      }
      if (boolPlayerCircleDown){
        floatPlayerCircleY += 5  ;
      }

      // Draws Snowballs
      fill(255, 255, 255);
      for (int i = 0; i < circleY.length; i++){
        if (boolSnowVisible[i] == true){
          ellipse(circleX[i], circleY[i], 50, 50);
        }
        
        circleY[i] += intCircleSpeed;

        if (circleY[i] > height) {
          circleY[i] = 0;
         
        }

        // Collission detection between player circle and snowballs
        if (dist(floatPlayerCircleX, floatPlayerCircleY, circleX[i], circleY[i]) <= (25 + 10) && boolSnowActive[i] && boolSnowVisible[i]){
          intLives--;
          boolSnowActive[i] = false;
        }
        if (dist(floatPlayerCircleX, floatPlayerCircleY, circleX[i], circleY[i]) >= (25 + 10)){
          boolSnowActive[i] = true;
        }

        // Makes snowballs dissapear if clicked upon
        
      }
        
      // Draws rectangles representing lives
      for (int i = 0; i < intLives; i++){
        rect(700 + i *15, 50 , 10, 10);
      }
      if (intLives == 0){
        boolAlive = false;
      }
    
    }
    else{
      background(255, 255, 255);
    }
  }

  /**
   * Depending on keypressed sets boolean values and speed values
   */

  public void keyPressed(){
    if (keyCode == UP){
      intCircleSpeed = 1;
    }
    if (keyCode == DOWN){
      intCircleSpeed = 10;
    }
    if (key == 'a'){
      boolPlayerCircleLeft = true;
    }
    if (key == 'd'){
      boolPlayerCircleRight  = true;
    }
    if (key == 'w'){
      boolPlayerCircleUp = true;
    }
    if (key == 's'){
      boolPlayerCircleDown = true;
    }
  }

  /**
   * Depending on keyreleased sets boolean values and speed values
   */

  public void keyReleased(){
    if (keyCode == UP){
      intCircleSpeed = 2;
    }
    if (keyCode == DOWN){
      intCircleSpeed = 2; 
    }
    if (key == 'a'){
      boolPlayerCircleLeft = false;
    }
    if (key == 'd'){
      boolPlayerCircleRight = false;
    }
    if (key == 'w'){
      boolPlayerCircleUp = false;
    }
    if (key == 's'){
      boolPlayerCircleDown = false;
    }
  }

  /**
   * If mouse is clicked make the snowball dissapear
   */

  public void mouseClicked(){
    for (int i = 0; i < circleY.length; i++){
      if (dist(mouseX, mouseY, circleX[i], circleY[i]) <= 25){
        boolSnowVisible[i] = false;
      }  
    }
  }
}
  
 
