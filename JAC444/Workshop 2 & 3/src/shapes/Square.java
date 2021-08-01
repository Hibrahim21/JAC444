package shapes;
import java.text.DecimalFormat;
public class Square implements Shape {
   private double side;

   public Square(double side)throws SquareException{
       if(side > 0) {
           this.side = side;
       }else {
           throw new SquareException("Invalid side!");
       }
   }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getPerimeter() {
            return 4 * getSide();
    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("0.000##");
       return "Square {s=" + getSide() + "} perimeter = " + df.format(getPerimeter());
    }
}
