import processing.core.PApplet;

public class Sketch extends PApplet {
	
  float[] circleY= new float [30];
  float[] circleX= new float [30];
  boolean[] boolSnowVisible = new boolean [30];

  int circleSpeed = 2;

  boolean boolCircleSlow = false;
  boolean boolCircleFast = false;

  float floatPlayerCircleX = 300;
  float floatPlayerCircleY = 300;

  boolean playerCircleLeft = false;
  boolean playerCircleRight = false;
  boolean playerCircleUp = false;
  boolean playerCircleDown = false;

  int intLives = 3;
  
  boolean alive = true;

  boolean boolMouseClick = false;


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
      circleX[i] = random(width);
      boolSnowVisible[i] = true;
    }
  }
    

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    if (alive){
      background(50);

    // Draws player ball and controls player movement
      ellipse(floatPlayerCircleX, floatPlayerCircleY, 20, 20);
      if (playerCircleRight){
        floatPlayerCircleX += 5;
      }
      if (playerCircleLeft){
        floatPlayerCircleX -= 5;
      }
      if (playerCircleUp){
        floatPlayerCircleY -= 5;
      }
      if (playerCircleDown){
        floatPlayerCircleY += 5  ;
      }

      // Draws Snowballs
      for (int i = 0; i < circleY.length; i++){
        if (boolSnowVisible[i] == true){
          ellipse(circleX[i], circleY[i], 25, 25);
        }
        
        circleY[i] += circleSpeed;

        if (circleY[i] > height) {
          circleY[i] = 0;
        }

        // Collission detection between player circle and snowballs
        if (dist(floatPlayerCircleX, floatPlayerCircleY, circleX[i], circleY[i]) <= (12.5 + 10) && boolSnowVisible[i] == true){
          intLives--;
          boolSnowVisible[i] = false;
        }

        // Makes snowballs dissapear if clicked upon
        if (boolMouseClick && dist(mouseX, mouseY, circleX[i], circleY[i]) <= 12.5){
            boolSnowVisible[i] = false;
        }
      }
        
      // Draws rectangles representing lives
      for (int i = 0; i < intLives; i++){
        rect(350 + i *15, 350 , 10, 10);
      }
      if (intLives == 0){
        alive = false;
      }
    
    }
    else{
      background(255, 255, 255);
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

  
  public void mousePressed(){
    boolMouseClick = true;
  }

  public void mouseReleased(){
    boolMouseClick = false;
  }
    
}
  
  // define other methods down here.
