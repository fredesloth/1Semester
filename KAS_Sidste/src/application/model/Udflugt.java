package application.model;

import java.time.LocalDate;

public class Udflugt {
	private String navn;
	private double pris;
	private String beskrivelse;
	private LocalDate dato;
	private String tid;
	private boolean frokost;
	
	public Udflugt(String navn, double pris, String beskrivelse, LocalDate dato, String tid, boolean frokost) {
		this.navn = navn;
		this.pris = pris;
		this.beskrivelse = beskrivelse;
		this.frokost = frokost;
		this.dato = dato;
		this.tid = tid;
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

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	public LocalDate getDate() {
		return dato;
	}

	public void setDate(LocalDate dato) {
		this.dato = dato;
	}

	public boolean getFrokost() {
		return frokost;
	}

	public void setFrokost(boolean frokost) {
		this.frokost = frokost;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}
}
