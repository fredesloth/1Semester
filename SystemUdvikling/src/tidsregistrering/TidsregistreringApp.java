package tidsregistrering;

public class TidsregistreringApp {
    public static void main(String[] args) {

        Tidsregistrering test = new Tidsregistrering("Kodning i Java", "Peter Nielsen", 13.5);
        test.setBemærkning("Det går sgu lidt sløvt lige pt");
        test.printTidsregistrering();
        test.setBrugtTid(6.7);
        test.printTidsregistrering();
    }
}
