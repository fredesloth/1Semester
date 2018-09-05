package application.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import application.model.Hotel;
import application.model.Tilmelding;
import application.model.Udflugt;

public class Konference {
	private String navn;
	private String beskrivelse;
	private String addresse;
	private LocalDate startDato;
	private LocalDate slutDato;
	private double pris;
	private ArrayList<Tilmelding> tilmeldinger;
	private ArrayList<Hotel> hoteller;
	private ArrayList<Udflugt> udflugter;
	
	public Konference (String navn, String beskrivelse, String addresse, LocalDate startDato, LocalDate slutDato, double pris) {
		this.navn = navn;
		this.beskrivelse = beskrivelse;
		this.addresse = addresse;
		this.startDato = startDato;
		this.slutDato = slutDato;
		this.pris = pris;
		
		this.tilmeldinger = new ArrayList<>();
		this.hoteller = new ArrayList<>();
		this.udflugter = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return navn + ", " + pris + "DKK";
	}
	
	public ArrayList<String> getDates() {
		ArrayList<String> dates = new ArrayList<>();
		
		for (int i = 0; i < this.beregnAntalDage(); i++) {
			dates.add(startDato.toString());
		}
		
		return dates;
	}
	
	public boolean checkAlreadySignedUp(Deltager deltager) {
		boolean signedUp = false;
		for (Tilmelding t : tilmeldinger) {
			if (t.getDeltager() == deltager) {
				signedUp = true;
			}
		}
		
		return signedUp;
	}
	
	public Udflugt createUdflugt(String navn, double pris, String beskrivelse, LocalDate dato, String tid, boolean frokost) {
		Udflugt udflugt = new Udflugt(navn, pris, beskrivelse, dato, tid, frokost);
		addUdflugt(udflugt);
		return udflugt;
	}
	
	public void addUdflugt(Udflugt udflugt) {
		this.udflugter.add(udflugt);
	}
	
	public ArrayList<Udflugt> getUdflugter() {
		return new ArrayList<Udflugt>(this.udflugter);
	}
	
	public void removeUdflugt(Udflugt udflugt) {
		this.udflugter.remove(udflugt);
	}
	
	public void addTilmelding(Tilmelding tilmelding) {
		this.tilmeldinger.add(tilmelding);
	}
	
	public ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<Tilmelding>(this.tilmeldinger);
	}
	
	public void removeTilmelding(Tilmelding tilmelding) {
		this.tilmeldinger.remove(tilmelding);
	}
	
	public void addHotel(Hotel hotel) {
		this.hoteller.add(hotel);
	}
	
	public void setHotels(ArrayList<Hotel> hoteller) {
		this.hoteller = hoteller;
	}
	
	public void removeHotel(Hotel hotel) {
		this.hoteller.remove(hotel);
	}
	
	public ArrayList<Hotel> getHoteller() {
		return new ArrayList<Hotel>(this.hoteller);
	}
	
	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getBeksrivelse() {
		return beskrivelse;
	}

	public void setBeksrivelse(String beksrivelse) {
		this.beskrivelse = beksrivelse;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public LocalDate getStartDato() {
		return startDato;
	}

	public void setStartDato(LocalDate startDato) {
		this.startDato = startDato;
	}

	public LocalDate getSlutDato() {
		return slutDato;
	}

	public void setSlutDato(LocalDate slutDato) {
		this.slutDato = slutDato;
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}
	
	//---------------------------------------------------------------------------
	
	public int beregnAntalDage() {
		Period p = startDato.until(slutDato);
		int antalDage = p.getDays();
		
		return antalDage;
	}
}
