package application.model;

public class Tillæg {
    private double pris;
    private String navn;

    public Tillæg(double pris, String navn) {
        this.pris = pris;
        this.navn = navn;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

}
