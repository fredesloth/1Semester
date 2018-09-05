package opgaver;

import javax.swing.JOptionPane;

public class Bil {

    public static void main(String[] args) {

        double PrisForBenzin = 11.95;
        double Afstand = 8;
        double KilometerPrLiter = 15;
        double Vedligeholdelse = 0.29;
        double OffT = 20;
        double PrisForBil = ((Afstand / KilometerPrLiter * PrisForBenzin) + (Afstand * Vedligeholdelse));

        if (OffT > PrisForBil) {
            System.out.println("Offentlig transport er dyrest");
            // \n gør at den starte på næste linje
            JOptionPane.showMessageDialog(null,
                    "Offentlig transport er dyrest, prisen er: " + OffT + " kr."
                            + "\nSe resultat for at kører i bil for neden" + "\nPrisen for at kører i bil er "
                            + PrisForBil + " kr.",
                    "Resultat", JOptionPane.PLAIN_MESSAGE);
        } else {
            System.out.println("At kører i bil er dyrest");
            JOptionPane.showMessageDialog(null,
                    "Bil er dyrest, prisen er: " + PrisForBil + " kr."
                            + "\nSe resultat for offentlig transport for neden"
                            + "\nPrisen for at tage offentlig transport er " + OffT + " kr.",
                    "Resultat", JOptionPane.PLAIN_MESSAGE);
        }
        System.out.println("");
        System.out.println("Pris for at køre i bil:");
        System.out.println(PrisForBil);
        System.out.println("");
        System.out.println("Pris for at tage offentlig transport:");
        System.out.println(OffT);
    }

}
