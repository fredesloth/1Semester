package application.model;

public class Ledsager {
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
}
