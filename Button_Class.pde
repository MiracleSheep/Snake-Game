//class that creates buttons
class Button {

  
//Draws the button
public void DrawButton(int length, int width, int x, int y, String word) {
   fill(#16DE64);
   if (mouseX > x && mouseX < x + length && mouseY > y && mouseY < y + width) {
     fill(#FFFFFF);
}
  
  int s = word.length();
  rect(x,y,length,width);
  fill(#E30707);
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
