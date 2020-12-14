import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*Enter the room number u want to book
 * checks if room does exist and is available
 * if yes: continue
 * if no: cancel and go back to start*/


public class rNrEnter implements KeyListener {

    JTextField nameInput;


    public rNrEnter(JTextField textfield) {
        nameInput = textfield;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            rNrBuchung.sResRNR = rNrBuchung.Answer.getText();
            rNrBuchung.bRaumverfüg = DatenErzeugnung.getHmapRooms().containsKey(rNrBuchung.sResRNR)
                    && DatenErzeugnung.getHmapRooms().get(rNrBuchung.sResRNR).getVerfügbarkeit() == true;
            if (rNrBuchung.bRaumverfüg) {
                BisGUI.createAndShowGui();
                rNrBuchung.frame.dispose();
            } else if (rNrBuchung.bRaumverfüg == false) {
                JOptionPane.showMessageDialog(rNrBuchung.frame, "Raum nicht gefunden oder nicht vorhanden!");
                rNrBuchung.frame.dispose();
                Start.createAndShowGui();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Start.createAndShowGui();
            rNrBuchung.frame.dispose();
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
