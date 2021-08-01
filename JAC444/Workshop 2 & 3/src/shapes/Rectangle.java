package shapes;

import java.text.DecimalFormat;

public class Rectangle extends Parallelogram {
  
  public Rectangle(double length,double width) throws Exception{
    super(length, width);
  }
  
  @Override	
   public String toString(){
   DecimalFormat df = new DecimalFormat("0.0000##");
      return "Rectangle {w=" + super.getwid() + ", h=" + super.getlen() + "} perimeter = " + df.format(getPerimeter());
      }

}
