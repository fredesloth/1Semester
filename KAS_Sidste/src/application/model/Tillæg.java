package application.model;

public class Tillæg {
	private double pris;
	private String navn;
	
	public Tillæg(String navn, double pris) {
		this.navn = navn;
		this.pris = pris;
	}
	
	@Override
	public String toString() {
		return navn + ", " + pris + "DKK";
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
}
