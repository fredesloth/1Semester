package exempler;

import javax.swing.JOptionPane;

public class DialogBox {

    public static void main(String[] args) {

        double Jorden = 20.5;
        int Solen = 40;

        JOptionPane.showMessageDialog(null,
                "Dette er en dialog box\nEfter dette N springer den en linje ned\n"
                        + "Efter et + kan man insætte double eller int som fx " + Solen + " eller " + Jorden + " sådan",
                "Dette er overskriften", JOptionPane.PLAIN_MESSAGE);

    }

}
