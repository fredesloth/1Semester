package lektion5;

public class Konto {

    private int nr;
    private int saldo;
    private String kontotype;

    public Konto(String kontotype, int nr) {
        this.kontotype = kontotype;
        this.nr = nr;
    }

    public void setKontotype(String kontotype) {
        this.kontotype = kontotype;
    }

    public String getKontotype() {
        return kontotype;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getNr() {
        return nr;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int saldo() {
        return saldo;
    }

    // Kod metoden indsætBeløb.
    public void setIndsætBeløb(int indsætBeløb) {
        saldo = saldo + indsætBeløb;
    }

    public void printKonto() {
        System.out.println("***************************************************************************");
        System.out.println("Kontotype: " + kontotype);
        System.out.println("Saldo på konto: " + saldo);
        System.out.println("Bruger nummer: " + nr);
    }

}
