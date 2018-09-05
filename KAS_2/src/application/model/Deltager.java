package application.model;

import java.util.ArrayList;

public class Deltager {

    private String navn;
    private String adresse;
    private String by;
    private String land;
    private String tlf;
    private String firmaNavn;
    private String firmaTlf;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Deltager(String navn, String adresse, String by, String land, String tlf, String firmaNavn,
            String firmaTlf) {
        this.navn = navn;
        this.adresse = adresse;
        this.by = by;
        this.land = land;
        this.tlf = tlf;
        this.firmaNavn = firmaNavn;
        this.firmaTlf = firmaTlf;
    }

    public Deltager(String navn, String adresse, String by, String land, String tlf) {
        this.navn = navn;
        this.adresse = adresse;
        this.by = by;
        this.land = land;
        this.tlf = tlf;

    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public void setFirmaNavn(String firmaNavn) {
        this.firmaNavn = firmaNavn;
    }

    public void setFirmaTlf(String firmaTlf) {
        this.firmaTlf = firmaTlf;
    }

    public String getNavn() {
        return navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getBy() {
        return by;
    }

    public String getLand() {
        return land;
    }

    public String getTlf() {
        return tlf;
    }

    public String getFirmaNavn() {
        return firmaNavn;
    }

    public String getFirmaTlf() {
        return firmaTlf;
    }

    // @Override
    // public String toString() {
    // return navn + " " + adresse + " " + by + " " + land + " " + tlf + " " +
    // "hotelValgt";
    // }

    @Override
    public String toString() {
        return navn;
    }

    // ----------------------------------------------------------------------------------------------
    // Auto generated get/setters
    public ArrayList<Tilmelding> getTilmeldinger() {
        return tilmeldinger;
    }

    public void setTilmeldinger(ArrayList<Tilmelding> tilmeldinger) {
        this.tilmeldinger = tilmeldinger;
    }
    // ----------------------------------------------------------------------------------------------

    // public ArrayList<Tilmelding> getTilmelding() {
    // return Storage.getTilmeldinger();
    // }
    //
    // public void addTilmelding(Tilmelding tilmelding) {
    // Storage.addTilmelding(tilmelding);
    //
    // }
    //
    // public void removeTilmelding(Tilmelding tilmelding) {
    // Storage.removeTilmelding(tilmelding);
    // }
}
