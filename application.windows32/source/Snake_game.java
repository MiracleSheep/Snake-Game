import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.Random; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Snake_game extends PApplet {


//making a new class of snake with its own food type
float speed = 2;
boolean pressed = false;
StartScreen S = new StartScreen();
Food F = new Food();


//sets up the function
public void setup() {
  
  noStroke();
}

//Draw loop
public void draw() {
  background(0);

if (S.ispressed() == false) {
S.DrawStartMenu();
} else {

   F.DrawFood();
   F.Create();
}
}
//class that creates buttons
class Button {

  
//Draws the button
public void DrawButton(int length, int width, int x, int y, String word) {
   fill(0xff16DE64);
   if (mouseX > x && mouseX < x + length && mouseY > y && mouseY < y + width) {
     fill(0xffFFFFFF);
}
  
  int s = word.length();
  rect(x,y,length,width);
  fill(0xffE30707);
  textSize(10);
  text(word, x + 4*(s/2), y + width/2);
  //return(IsPressed(length,width,x,y));

}

//checks if the button is pressed
public boolean IsPressed(int length, int width, int x, int y) {
  
  
    if (mouseX > x && mouseX < x + length && mouseY > y && mouseY < y + width && mousePressed) {
  return(true);
} else {
return(false);
}
}
}
//This class uses the Math class and its random method to get a random number
//It takes a maximum and min and outputs a double
public static double getRandomInteger(double min, double max) {
  double x = (int)(Math.random()*((max-min)+1))+min;
  return x;
}

//Food class, member of Snake
public class Food extends Snake {

  //Variables belonging to Food
  float randx;
  float randy;
  static final float Flength = 10;

  //constructor function, makes new food
  public Food() {
    NewFood();
  }

  //function that draws the food
  public void DrawFood() {
    fill(0xff29D65B);
    ellipse(randx, randy, Flength, Flength);
    IsEaten();
  }

  //function responsible for making new food
  public void NewFood() {
    randx = (float)getRandomInteger(0 + Flength, 500 - Flength);
    randy = (float)getRandomInteger(0 + Flength, 500 - Flength);
  }

  //function that checks if the snake makes contact with it
  public void IsEaten() {
      float x = Coords[0][0] + SnakeSquareLength*2;
      float y = Coords[0][1] + SnakeSquareLength*2;
     
    if (Coords[0][0] < randx && x > randx && Coords[0][1] < randy && y > randy) {
      NewFood();
      size += 1;
      score = size - 2;
    }
  }
}
//menu class
class StartScreen {
int starts = 0;
float LR = 0;
float y = 0;
float x;
float change;
Button B = new Button();
Button S1 = new Button();
Button S2 = new Button();


  
//Draws the menu
public void DrawStartMenu(){

  
  fill(0xff0CAFF7);
  textSize(32);
text("Snake", 440/2, 50);
  textSize(16);
text("By John Khalife", 425/2, 75);
B.DrawButton(40,25,500/2,515/2,"Start");
S1.DrawButton(40,23,130/2,450,"Slow");
S2.DrawButton(40,23,400,450,"Fast");
if (S1.IsPressed(40,23,130/2,450)) {
speed = 2;
}

if (S2.IsPressed(40,23,400,450)) {
speed = 4;
}

Animation();


}

public void Animation() {

  if (starts == 0) {
LR = (float) getRandomInteger(1,2);
 y = (float) getRandomInteger(0,500);
 if (LR == 1) {
x = 0;
change = 2;
} else if (LR == 2) {
x = 500;
change = -2;
} else {
x = 0;
change = 2;
}

 starts = 1;
}

if (x == -2 || x == 502) {
starts = 0;
}




fill(0xffFC1414);
rect(x,y,25,25);
x += change;



}

//responsible for starting the game
public boolean ispressed() {
  if (pressed == false) {
  if (B.IsPressed(40,25,500/2,515/2) == true) {
    pressed = true;
  } 

} else if (pressed == true) {
  return(true);
}
  
return(false);



}
}
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
  public void Move() {
    fill(0xffFC1414);

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
  public void Edgeloop() {
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
  public void Create() throws ArrayIndexOutOfBoundsException {
        text("Score: " + score, 510/2,20);
    
    if (start == 1) {
    Coords[0][0] = 50;
    Coords[0][1] = 50;
    start = 0;
    }
    try {
      fill(0xffFC1414);
      for (int b = 1; b < size; b++) {
        Coords[size - b][0] = Coords[size - b - 1][0];
        Coords[size - b][1] = Coords[size - b - 1][1];
        rect(Coords[b][0] + 10, Coords[b][1] + 10, SnakeSquareLength, SnakeSquareLength);
      }
      Move();
    } 
    catch (ArrayIndexOutOfBoundsException e) {
      textSize(20);
      fill(0xffFFFFFF);
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
  public void Collision() {
    for (int i = 25; i <= size; i++) {
       if (Coords[0][0] < Coords[i][0] && Coords[0][0] + SnakeSquareLength > Coords[i][0] && Coords[0][1] < Coords[i][1] && Coords[0][1] + SnakeSquareLength > Coords[i][1] || Coords[0][0] < Coords[i][0] + SnakeSquareLength && Coords[0][0] + SnakeSquareLength > Coords[i][0]  + SnakeSquareLength && Coords[0][1] < Coords[i][1]  + SnakeSquareLength && Coords[0][1] + SnakeSquareLength > Coords[i][1]  + SnakeSquareLength) {
        rect(0,0,525,525);
        size = 2;
        score = 0;
       } 
    }

}
  
  
  }
  public void settings() {  size(525, 525); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Snake_game" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
