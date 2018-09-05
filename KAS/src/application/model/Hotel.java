package application.model;

import java.util.ArrayList;

public class Hotel {

    private String navn;
    private double enkeltVærelsePris;
    private double dobbeltVærelsePris;
    private ArrayList<Tillæg> alleTillæg = new ArrayList<>();
    private int stjerner;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Hotel(String navn, double enkeltVærelsePris, double dobbeltVærelsePris, int stjerner) {
        this.navn = navn;
        this.enkeltVærelsePris = enkeltVærelsePris;
        this.dobbeltVærelsePris = dobbeltVærelsePris;
        this.stjerner = stjerner;

        // --------------------------------------------------------------------------

    }

    public ArrayList<Tillæg> getTillæg() {
        return new ArrayList<>(alleTillæg);
    }

    public void addTillæg(Tillæg tillæg) {
        alleTillæg.add(tillæg);
    }

    public void removeTillæg(Tillæg tillæg) {
        alleTillæg.remove(tillæg);
    }

    public ArrayList<Tillæg> getAlleTillæg() {
        return alleTillæg;
    }

    public void setAlleTillæg(ArrayList<Tillæg> alleTillæg) {
        this.alleTillæg = alleTillæg;
    }

    // ------------------------------------------------------------------------------------
    // public ArrayList<Tilmelding> getTilmelding() {
    // return new ArrayList<>(tilmeldinger);
    // }
    //
    // public void addTilmelding(Tilmelding tilmelding) {
    // tilmeldinger.add(tilmelding);
    // }
    //
    // public void removeTilmelding(Tilmelding tilmelding) {
    // tilmeldinger.remove(tilmelding);
    // }

    public void setEnkeltVærelsePris(double enkeltVærelsePris) {
        this.enkeltVærelsePris = enkeltVærelsePris;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return tilmeldinger;
    }

    // ------------------------------------------------------------------------------------

    public void setTilmeldinger(ArrayList<Tilmelding> tilmeldinger) {
        this.tilmeldinger = tilmeldinger;
    }

    public void setDobbeltVærelsePris(double dobbeltVærelsePris) {
        this.dobbeltVærelsePris = dobbeltVærelsePris;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getEnkeltVærelsePris() {
        return enkeltVærelsePris;
    }

    public double getDobbeltVærelsePris() {
        return dobbeltVærelsePris;
    }

    public String getNavn() {
        return navn;
    }

    public int getStjerner() {
        return stjerner;
    }

    public void setStjerner(int stjerner) {
        this.stjerner = stjerner;
    }

    // --------------------------------------------------------------------------

    public Tillæg createTillæg(double pris, String navn) {
        Tillæg tillæg = new Tillæg(pris, navn);
        addTillæg(tillæg);
        return tillæg;
    }

}
