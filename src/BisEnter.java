import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*ON ENTER PRESS:
 *reate a random Number with 8 digits
 * repeat that process untill its a unique Booking ID
 *make Booking ID start with BU * randomNumber
 * create a helper Hashmap and fill witht he new Data and add Data from HmapRooms
 * overwrite  the Data in HmapRooms with Data from Helper Hashmap
 *
 * ON ESC PRESS:
 * cancels the programm and goes back to start, deletes all changes*/

public class BisEnter implements KeyListener {

    JTextField nameInput;

    public BisEnter(JTextField textfield) {
        nameInput = textfield;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Random_Number_Generator rand = new Random_Number_Generator();
            BisGUI.sBis = BisGUI.Answer.getText();
            int iRand = rand.ResRandomNumber();
            String Buchungsnummer = "BU" + iRand;
            HashMap<String, Reservierungen> hilfsmap = new HashMap<>();
            Reservierungen hilfsRes = new Reservierungen(
                    Buchungsnummer,
                    DatenErzeugnung.getHmapMitarbeiter().get(ReservierungGUI.sÜbergabe).getsMaName(),
                    rNrBuchung.sResRNR,
                    BisGUI.sBis);
            hilfsmap.put(Buchungsnummer, hilfsRes);
            String[] hilfsString = DatenErzeugnung.getHmapReservierungen().keySet().toArray(new String[0]);
            for (int i = 0; i < hilfsString.length; i++) {
                hilfsmap.put(hilfsString[i], DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]));
            }
            DatenErzeugnung.setHmapReservierungen(hilfsmap);
            JOptionPane.showMessageDialog(BisGUI.frame, "Buchung erfolgreich abgeschlossen!");
            BisGUI.frame.dispose();
            if (DatenErzeugnung.getHmapRooms().containsKey(rNrBuchung.sResRNR)) {
                DatenErzeugnung.getHmapRooms().get(rNrBuchung.sResRNR).setVerfügbarkeit(false);
            }
            Start.createAndShowGui();
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Start.createAndShowGui();
            BisGUI.frame.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
