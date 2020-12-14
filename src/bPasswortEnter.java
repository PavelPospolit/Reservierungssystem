import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*Enter a Password
 * compares entered Password with saved in Hashmap
 * if Password is correct, continue with Booking
 * if Password is incorrect show Error Message "Falsches Passwort" and go back to start*/

public class bPasswortEnter implements KeyListener {

    JTextField nameInput;

    public bPasswortEnter(JTextField textfield) {
        nameInput = textfield;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            bPasswortGUI.sEinloggpasswort = bPasswortGUI.Answer.getText();
            String[] hilfsString = DatenErzeugnung.getHmapMitarbeiter().keySet().toArray(new String[0]);
            for (int i = 0; i < hilfsString.length; i++) {
                if ((hilfsString[i].equals(ReservierungGUI.sNutzername) ||
                        DatenErzeugnung.getHmapMitarbeiter().get(hilfsString[i]).getsMaName().equals(ReservierungGUI.sNutzername))&&
                        DatenErzeugnung.getHmapMitarbeiter().get(hilfsString[i]).getsPasswort().equals(bPasswortGUI.sEinloggpasswort)) {
                    bPasswortGUI.bPasswort = true;
                    break;
                } else bPasswortGUI.bPasswort = false;
            }
            if (!bPasswortGUI.bPasswort) {
                JOptionPane.showMessageDialog(bPasswortGUI.frame, "Falsches Passwort.");
                bPasswortGUI.frame.dispose();
                Start.createAndShowGui();
            } else {
                rNrBuchung.createAndShowGui();
                bPasswortGUI.frame.dispose();
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Start.createAndShowGui();
            bPasswortGUI.frame.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
    }
    @Override
    public void keyTyped(KeyEvent arg0) {
    }
}
