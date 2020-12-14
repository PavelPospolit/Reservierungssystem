import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*Enter room Number of the room u want to give back
 * checks if room exists
 * sets availability to true and deletes reservation */

public class ZurückgebenEnter implements KeyListener {

    JTextField nameInput;

    public ZurückgebenEnter(JTextField textfield) {
        nameInput = textfield;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            ZurückgebenGUI.sZurückNr = ZurückgebenGUI.Answer.getText();
            String[] hilfsString = DatenErzeugnung.getHmapReservierungen().keySet().toArray(new String[0]);
            for (int i = 0; i < hilfsString.length; i++) {
                if (DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]).getsRaumNummer().equals(ZurückgebenGUI.sZurückNr)) {
                    DatenErzeugnung.getHmapReservierungen().remove(hilfsString[i]);
                }
            }
            if (DatenErzeugnung.getHmapRooms().containsKey(ZurückgebenGUI.sZurückNr)) {
                DatenErzeugnung.getHmapRooms().get(ZurückgebenGUI.sZurückNr).setVerfügbarkeit(true);
            }
            JOptionPane.showMessageDialog(ZurückgebenGUI.frame, "Raum " + ZurückgebenGUI.sZurückNr + " erfolgreich freigegeben!");
            ZurückgebenGUI.frame.dispose();
            Start.createAndShowGui();
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Start.createAndShowGui();
            ZurückgebenGUI.frame.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub
    }
}
