import java.util.Random;
//making a new class of snake with its own food type
float speed = 2;
boolean pressed = false;
StartScreen S = new StartScreen();
Food F = new Food();


//sets up the function
void setup() {
  size(525, 525);
  noStroke();
}

//Draw loop
void draw() {
  background(0);

if (S.ispressed() == false) {
S.DrawStartMenu();
} else {

   F.DrawFood();
   F.Create();
}
}
