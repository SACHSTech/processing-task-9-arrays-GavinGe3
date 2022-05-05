import processing.core.PApplet;

public class Sketch extends PApplet {
	
  float[] circleY= new float [30];
  int circleSpeed = 2;

  boolean boolCircleSlow = false;
  boolean boolCircleFast = false;

  int playerCircleX = 300;
  int playerCircleY = 300;

  boolean playerCircleLeft = false;
  boolean playerCircleRight = false;
  boolean playerCircleUp = false;
  boolean playerCircleDown = false;



  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(400, 400);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(50);
    for (int i = 0; i < circleY.length; i++){
      circleY[i] = random(height);
  }
}

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    background(50);

    ellipse(playerCircleX, playerCircleY, 20, 20);
    if (playerCircleRight){
      playerCircleX += 5;
    }
    if (playerCircleLeft){
      playerCircleX -= 5;
    }
    if (playerCircleUp){
      playerCircleY -= 5;
    }
    if (playerCircleDown){
      playerCircleY += 5  ;
    }

    for (int i = 0; i < circleY.length; i++){
      float circleX = width * i / circleY.length;
      ellipse(circleX, circleY[i], 25, 25);

      circleY[i] += circleSpeed;

      if (circleY[i] > height) {
        circleY[i] = 0;
      }
    }
    
  }
  public void keyPressed(){
    if (keyCode == UP){
      circleSpeed = 1;
    }
    if (keyCode == DOWN){
      circleSpeed = 10;
    }
    if (key == 'a'){
      playerCircleLeft = true;
    }
    if (key == 'd'){
      playerCircleRight  = true;
    }
    if (key == 'w'){
      playerCircleUp = true;
    }
    if (key == 's'){
      playerCircleDown = true;
    }
  }
  public void keyReleased(){
    if (keyCode == UP){
      circleSpeed = 2;
    }
    if (keyCode == DOWN){
      circleSpeed = 2; 
    }
    if (key == 'a'){
      playerCircleLeft = false;
    }
    if (key == 'd'){
      playerCircleRight = false;
    }
    if (key == 'w'){
      playerCircleUp = false;
    }
    if (key == 's'){
      playerCircleDown = false;
    }
  }
    
}
  
  // define other methods down here.
