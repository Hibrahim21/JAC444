import java.io.*;

public class Car implements Serializable {

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public double getMileage() {
		return mileage;
	}

	public String getPlateNo() {
		return PlateNo;
	}

	private String model;
	private String color;
	private double mileage;
	private String PlateNo;

	public Car( String brand, String colo, double m ) {
		model = brand;
		color = colo;
		mileage = m;
		PlateNo = "NoPlate";
	}

	public String toString() {
		return "Model: " + model + " Color: " + color +
				" Mileage: " +  mileage + 
				" PlateNo: " + PlateNo;
	}

	public void getRegistered(String plate) {
		PlateNo = plate;
	}


	public void setModel(String model) {
		this.model = model;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public void setPlateNo(String plateNo) {
		PlateNo = plateNo;
	}
}