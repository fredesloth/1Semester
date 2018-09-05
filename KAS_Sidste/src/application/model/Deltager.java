package application.model;

import java.util.ArrayList;

public class Deltager {
	private String fornavn;
	private String efternavn;
	private String addresse;
	private String by;
	private String land;
	private String tlf;
	private String firmaNavn;
	private String firmaTlf;
	private ArrayList<Tilmelding> tilmeldinger;
	
	public Deltager (String fornavn, String efternavn, String addresse, String by, String land, String tlf, String firmaNavn, String firmaTlf) {
		this.fornavn = fornavn;
		this.efternavn = efternavn;
		this.addresse = addresse;
		this.by = by;
		this.land = land;
		this.tlf = tlf;
		this.firmaNavn = firmaNavn;
		this.firmaTlf = firmaTlf;
		this.tilmeldinger = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return this.fornavn + " " + this.efternavn;
	}

	public String getFirmaNavn() {
		return firmaNavn;
	}

	public void setFirmaNavn(String firmaNavn) {
		this.firmaNavn = firmaNavn;
	}

	public String getFirmaTlf() {
		return firmaTlf;
	}

	public void setFirmaTlf(String firmaTlf) {
		this.firmaTlf = firmaTlf;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getEfternavn() {
		return efternavn;
	}

	public void setEfternavn(String efternavn) {
		this.efternavn = efternavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<Tilmelding>(tilmeldinger);
	}

	public void addTilmelding(Tilmelding tilmelding) {
		this.tilmeldinger.add(tilmelding);
	}
	
	public void removeTilmelding(Tilmelding tilmelding) {
		this.tilmeldinger.remove(tilmelding);
	}
}
