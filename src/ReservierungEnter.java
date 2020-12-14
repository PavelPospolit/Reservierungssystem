import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*Enter a Employee name/username or Employee ID to log in
 * if entered ID does not exists: show error message and go back to start
 * otherwhise continue: */

public class ReservierungEnter implements KeyListener {

    JTextField nameInput;


    public ReservierungEnter(JTextField textfield) {
        nameInput = textfield;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            ReservierungGUI.sNutzername = ReservierungGUI.Answer.getText();
            String[] hilfsString = DatenErzeugnung.getHmapMitarbeiter().keySet().toArray(new String[0]);
            for (int i = 0; i < hilfsString.length; i++) {
                if (hilfsString[i].equals(ReservierungGUI.sNutzername) ||
                        DatenErzeugnung.getHmapMitarbeiter().get(hilfsString[i]).getsMaName().equals(ReservierungGUI.sNutzername)) {
                    ReservierungGUI.bNutzer = true;
                    ReservierungGUI.sÜbergabe = hilfsString[i];
                    break;
                } else ReservierungGUI.bNutzer = false;
            }
            if (ReservierungGUI.bNutzer) {
                bPasswortGUI.createAndShowGui();
                ReservierungGUI.frame.dispose();
            } else if (!ReservierungGUI.bNutzer) {
                JOptionPane.showMessageDialog(ReservierungGUI.frame, "Nutzer nicht gefunden.");
                ReservierungGUI.frame.dispose();
                Start.createAndShowGui();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Start.createAndShowGui();
            ReservierungGUI.frame.dispose();
        }

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }
}
