package application.model;

import java.util.ArrayList;

import application.model.Tilmelding;
import application.model.Udflugt;

public class Ledsager {
	private String navn;
	private Tilmelding tilmelding;
	private ArrayList<Udflugt> udflugter;

	public Ledsager(String navn) {
		this.navn = navn;
		this.udflugter = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return navn;
	}

	public Tilmelding getTilmelding() {
		return tilmelding;
	}

	public void setTilmelding(Tilmelding tilmelding) {
		this.tilmelding = tilmelding;
	}

	public String getNavn() {
		return this.navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void addUdflugt(Udflugt udflugt) {
		this.udflugter.add(udflugt);
	}

	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<Udflugt>(udflugter);
	}
	
	public void setUdflugter(ArrayList<Udflugt> udflugter) {
		this.udflugter = udflugter;
	}

	public double getUdflugtPris() {
		double sum = 0.0;

		if (udflugter.size() > 0) {
			for (Udflugt u : udflugter) {
				sum += u.getPris();
			}
		}

		return sum;
	}

}
