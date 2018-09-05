package application.model;

import application.model.Udflugt;

public class Ledsager {
    private Udflugt udflugt;

    private String navn;
    private Tilmelding tilmelding;

    public Ledsager(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public Tilmelding getTilmelding() {
        return tilmelding;
    }

    public void setTilmelding(Tilmelding tilmelding) {
        this.tilmelding = tilmelding;
    }

    // BeregnSamletUdflugtPris()

    public double beregnSamletPris() {
        double sum = 0;
        sum = udflugt.getPris();
        return sum;
    }

    @Override
    public String toString() {
        return navn;
    }
}
