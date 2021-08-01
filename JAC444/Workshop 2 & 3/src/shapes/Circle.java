package shapes;
import java.lang.Math;
import java.text.DecimalFormat;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) throws CircleException {
        if(radius > 0) {
            this.radius = radius;
        }else{
            throw new CircleException("Invalid radius!");
        }
    }
    
    public double getRadius(){
        return radius;
    }
    
    @Override
    public double getPerimeter(){
       return   2*Math.PI*getRadius() ;
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00000");
        return "Circle {r= "+getRadius() + "} perimeter = "+ df.format(getPerimeter());
    }
}