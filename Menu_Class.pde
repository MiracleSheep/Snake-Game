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

  
  fill(#0CAFF7);
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




fill(#FC1414);
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
