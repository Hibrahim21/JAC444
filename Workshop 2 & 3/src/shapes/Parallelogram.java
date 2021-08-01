package shapes;
import java.text.DecimalFormat;

public class Parallelogram implements Shape{
    private double len;
    private double wid;

    public Parallelogram(double length,double width)throws ParallelogramException{
        if(length > 0 && width > 0) {
            this.len = length;
            this.wid = width;
        }else {
            throw new ParallelogramException("Invalid side(s)!");
        }
    }

    public void setDimensions(double length,double width){
        this.len = length;
        this.wid = width;
    }

    double getlen(){
        return len;
    }

    double getwid(){
        return wid;
    }

    @Override
    public double getPerimeter(){
    	double d = (2 * getlen()) + (2 * getwid());
        return Math.round(d * 100000.0) / 100000.0;

    }

    public String toString(){
        DecimalFormat df = new DecimalFormat("0.0000##");
        return "Parallelogram {w=" + getwid() + ", h=" + getlen() + "} perimeter = " + df.format(getPerimeter());
    }
}