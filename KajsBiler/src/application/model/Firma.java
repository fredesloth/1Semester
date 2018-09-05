package application.model;

public class Firma {
    private int CVR;
    private String navn;

    public Firma(String navn, int CVR) {
        this.CVR = CVR;
        this.navn = navn;
    }

    public int getCVR() {
        return CVR;
    }

    public void setCVR(int cVR) {
        CVR = cVR;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

}
