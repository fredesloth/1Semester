package opgaver;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class P1_17 {

    public static void main(String[] args) throws Exception {

        URL imageLocation = new URL("http://www.itforum.dk/files/images/EAAA_logo.jpg");
        JOptionPane.showMessageDialog(null, "Dette er Aarhus Erhvervsakedemi's logo", "Aarhus Erhvervsakedmi",
                JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
    }

}
