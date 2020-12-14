import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*Enter a Password
 * create a random 8 digit Number for EmployeeID
 * construct Employee ID with MA+random Number (e.g. MA918529358)
 * create new helper Hashmap
 * put in new entered Data and Data from Hashmap HmapMitarbeiter
 * overwrite Data in HmapMitarbeiter with the Data in new helper Hashmap*/

public class EnterPW implements KeyListener {

    JTextField nameInput;

    public EnterPW(JTextField textfield) {
        nameInput = textfield;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Random_Number_Generator rand = new Random_Number_Generator();
            Passwortgui.sPasswort = Passwortgui.Answer.getText();
            int iRand = rand.MaRandomNumber();
            Passwortgui.sMitarbeiternummer = "MA" + iRand;
            HashMap<String, Mitarbeiter> hilfsmap = new HashMap<>();
            Mitarbeiter hilfsMa = new Mitarbeiter(
                    Mitarbeitergui.sName,
                    Passwortgui.sMitarbeiternummer,
                    Passwortgui.sPasswort);
            hilfsmap.put(Passwortgui.sMitarbeiternummer, hilfsMa);
            String[] hilfsString = DatenErzeugnung.getHmapMitarbeiter().keySet().toArray(new String[0]);
            for (int i = 0; i < hilfsString.length; i++) {
                hilfsmap.put(hilfsString[i], DatenErzeugnung.getHmapMitarbeiter().get(hilfsString[i]));
            }
            DatenErzeugnung.setHmapMitarbeiter(hilfsmap);
            JOptionPane.showMessageDialog(Passwortgui.frame, "Mitarbeiter erfolgreich hinzugefügt.");
            Passwortgui.frame.dispose();
            Start.createAndShowGui();
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Start.createAndShowGui();
            Passwortgui.frame.dispose();
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
