//making the class that draws a snake
public class Snake {

  //Snake class values
  static final float SnakeSquareLength = 25;
  int size = 2;
  int maxsize = 100;
  float Coords[][] = new float[maxsize][2]; 
  int direction = 0 ;
  int start = 1;
  int score = 0;


  
  //function that lets the snake move around
  void Move() {
    fill(#FC1414);

    if (keyPressed && key == 'w' || key == 'W') {
            if (size != 2) {
      if (direction == 2) {
        size = 2;
      rect(0,0,525,525);
      }
            }
      direction = 1;
    } else if (keyPressed && key == 's' || key == 'S') {
            if (size != 2) {
      if (direction == 1) {
        size = 2;
      rect(0,0,525,525);
      }
            }
      direction = 2;
    } else if (keyPressed && key == 'a' || key == 'A') {
        if (size != 2) {
      if (direction == 4) {
        size = 2;
      rect(0,0,525,525);
      }
        }
      direction = 3;
    } else if (keyPressed && key == 'd' || key == 'D') {
      if (size != 2) {
      if (direction == 3) {
        size = 2;
      rect(0,0,525,525);
      }
      }
      direction = 4;
      }
      
     


    if (direction == 1) {
      Coords[0][1] -= speed;
    } else if (direction == 2) {
      Coords[0][1] += speed;
    } else if (direction == 3) {
      Coords[0][0] -= speed;
    } else if (direction == 4) {
      Coords[0][0] += speed;
    } else {
    }


    Edgeloop();
    Collision();
  }


  //function that checks if the snake hits the edge and redirects
  void Edgeloop() {
    if (Coords[0][0] <= 0) {
      Coords[0][0] = 500; 
      return;
    } else if (Coords[0][0] >= 502) {
      Coords[0][0] = 0;
      return;
    }  else if (Coords[0][1] <= 0) {
      Coords[0][1] = 500; 
      return;
    } else if (Coords[0][1] >= 502) {
      Coords[0][1] = 0;
      return;
    }
  } 

    



  //function that draws the snake
  void Create() throws ArrayIndexOutOfBoundsException {
        text("Score: " + score, 510/2,20);
    
    if (start == 1) {
    Coords[0][0] = 50;
    Coords[0][1] = 50;
    start = 0;
    }
    try {
      fill(#FC1414);
      for (int b = 1; b < size; b++) {
        Coords[size - b][0] = Coords[size - b - 1][0];
        Coords[size - b][1] = Coords[size - b - 1][1];
        rect(Coords[b][0] + 10, Coords[b][1] + 10, SnakeSquareLength, SnakeSquareLength);
      }
      Move();
    } 
    catch (ArrayIndexOutOfBoundsException e) {
      textSize(20);
      fill(#FFFFFF);
      text("You Win!",525/2,525/2);
      try {
      Thread.currentThread().sleep(3000);
      } catch (Throwable f){
      }
      text("You Win!",525/2,525/2);
      pressed = false;
      size = 2;
      start = 1;
      draw();  
  }
  }
  
  
  //function that constantly checks if collided
  void Collision() {
    for (int i = 25; i <= size; i++) {
       if (Coords[0][0] < Coords[i][0] && Coords[0][0] + SnakeSquareLength > Coords[i][0] && Coords[0][1] < Coords[i][1] && Coords[0][1] + SnakeSquareLength > Coords[i][1] || Coords[0][0] < Coords[i][0] + SnakeSquareLength && Coords[0][0] + SnakeSquareLength > Coords[i][0]  + SnakeSquareLength && Coords[0][1] < Coords[i][1]  + SnakeSquareLength && Coords[0][1] + SnakeSquareLength > Coords[i][1]  + SnakeSquareLength) {
        rect(0,0,525,525);
        size = 2;
        score = 0;
       } 
    }

}
  
  
  }
