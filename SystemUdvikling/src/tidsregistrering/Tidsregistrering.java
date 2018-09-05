package tidsregistrering;

public class Tidsregistrering {
    private double brugtTid;
    private String medarbejder;
    private String bemærkning;
    private double estTid;
    private String navnOpgave;

    public Tidsregistrering(String navnOpgave, String medarbejder, double estTid) {
        this.navnOpgave = navnOpgave;
        this.medarbejder = medarbejder;
        this.estTid = estTid;
    }

    public void setMedarbejder(String medarbejder) {
        this.medarbejder = medarbejder;
    }

    public String getMedarbejder() {
        return medarbejder;
    }

    public void setBemærkning(String bemærkning) {
        this.bemærkning = bemærkning;
    }

    public String getBemærkning() {
        return this.bemærkning;
    }

    public void setBrugtTid(double brugtTid) {
        this.brugtTid = brugtTid;
    }

    public double getBrugtTid() {
        return brugtTid;
    }

    public void printTidsregistrering() {
        System.out.println("************************************************************************'");
        System.out.println("Navnet på opgaven: " + navnOpgave);
        System.out.println("Medarbejder på opgaven: " + medarbejder);
        System.out.println("Den brugte tid på opgaven: " + brugtTid);
        System.out.println("Den estimeret tid på opgaven: " + estTid);
        System.out.println("Bemærkning på opgaven: " + bemærkning);
    }

}
