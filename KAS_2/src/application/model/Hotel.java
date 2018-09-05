package application.model;

import java.util.ArrayList;

public class Hotel {

    private String navn;
    private double enkeltVærelsePris;
    private double dobbeltVærelsePris;
    private ArrayList<Tillæg> alleTillæg = new ArrayList<>();
    private int stjerner;

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

    // --------------------------------------------------------------------------

    public void setEnkeltVærelsePris(double enkeltVærelsePris) {
        this.enkeltVærelsePris = enkeltVærelsePris;
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
    // ???????????????? (Det samme med tilmelding, hotel og konference)

    public Tillæg createTillæg(double pris, String navn) {
        Tillæg tillæg = new Tillæg(pris, navn);
        addTillæg(tillæg);
        return tillæg;
    }

}
