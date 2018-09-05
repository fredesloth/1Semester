package exempler;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class DialogMedRullendeTekst {

    public static void main(String[] args) {

        JTextArea msg = new JTextArea(
                "Dette viser en tekst som gør at du kan rulle, dette ville være smart med længere tekster som denne hvor jeg bare fylder den ud");
        msg.setLineWrap(true);
        msg.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(msg);
        JOptionPane.showMessageDialog(null, scrollPane);

    }

}
