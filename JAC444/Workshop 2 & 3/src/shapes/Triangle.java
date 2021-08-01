package shapes;

import java.text.DecimalFormat;

public class Triangle implements Shape {
    double side1;
    double side2;
    double side3;

    Triangle (double side_1,double side_2,double side_3) throws TriangleException{
        if(side_1 > 0 && side_2 > 0 && side_3 > 0 &&  side_1 < side_2 + side_3 && side_2 < side_1 + side_3 && side_3 < side_1 + side_2){
        side1 = side_1;
        side2 = side_2;
        side3 = side_3;
        }else{
            throw new TriangleException("Invalid side(s)!");
        }
    }

    public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}

    public double getPerimeter() {

        return (getSide1() + getSide3() + getSide2()) ;
    }

	public String toString(){
        DecimalFormat df = new DecimalFormat("0.0000##");
        return "Triangle {s1=" + getSide1() + ", s2=" + getSide2() + ", s3=" + getSide3() + "} perimeter = " + df.format(getPerimeter());
    }
}
