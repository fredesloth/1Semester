package application.model;

public class Deltager {
    private String navn;
    private String adresse;
    private String by;
    private String land;
    private String tlf;
    private String firmaNavn;
    private String firmaTlf;

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
}
