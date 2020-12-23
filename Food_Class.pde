
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
  void DrawFood() {
    fill(#29D65B);
    ellipse(randx, randy, Flength, Flength);
    IsEaten();
  }

  //function responsible for making new food
  void NewFood() {
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
