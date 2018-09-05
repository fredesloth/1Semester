package eksempelcar;

public class Car {
	private int km;
	private String registrationNumber;
	private String color;
	private String brand;

	public Car(String brand, String color) {
		super();
		this.brand = brand;
		this.color = color;
	}

	public int getKm() {
		return this.km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	public String getRegistrationNumber() {
		return this.registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return this.brand;
	}

}
