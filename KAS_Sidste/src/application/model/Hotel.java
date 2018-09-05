package application.model;

import java.util.ArrayList;

import application.model.Tillæg;

public class Hotel {
	private String navn;
	private double enkeltVærelsePris;
	private double dobbeltVærelsePris;
	private int stjerner;
	private String addresse;
	private ArrayList<Tillæg> tillæg;

	public Hotel(String navn, double enkeltVærelsePris, double dobbeltVærelsePris, int stjerner, String addresse) {
		this.navn = navn;
		this.enkeltVærelsePris = enkeltVærelsePris;
		this.dobbeltVærelsePris = dobbeltVærelsePris;
		this.stjerner = stjerner;
		this.setAddresse(addresse);
		this.tillæg = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return navn;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public double getEnkeltVærelsePris() {
		return enkeltVærelsePris;
	}

	public void setEnkeltVærelsePris(double enkeltVærelsePris) {
		this.enkeltVærelsePris = enkeltVærelsePris;
	}

	public double getDobbeltVærelsePris() {
		return dobbeltVærelsePris;
	}

	public void setDobbeltVærelsePris(double dobbeltVærelsePris) {
		this.dobbeltVærelsePris = dobbeltVærelsePris;
	}

	public int getStjerner() {
		return stjerner;
	}

	public void setStjerner(int stjerner) {
		this.stjerner = stjerner;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public ArrayList<Tillæg> getTillæg() {
		return new ArrayList<Tillæg>(tillæg);
	}

	public void addTillæg(Tillæg tillæg) {
		this.tillæg.add(tillæg);
	}
	
	public Tillæg createTillæg(String navn, double pris) {
		Tillæg tillæg = new Tillæg(navn, pris);
		addTillæg(tillæg);
		return tillæg;
	}

	public void removeTillæg(Tillæg tillæg) {
		this.tillæg.remove(tillæg);
	}
}
