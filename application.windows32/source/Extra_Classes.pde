//This class uses the Math class and its random method to get a random number
//It takes a maximum and min and outputs a double
public static double getRandomInteger(double min, double max) {
  double x = (int)(Math.random()*((max-min)+1))+min;
  return x;
}
