import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*Enter new unique room Number
 * if room Number is not unique
 * show error message and request to enter a new one (repeat untill unique)
 * safe entered unique room Number in variable sRaznbznner*/

public class RaumnummerEnter implements KeyListener {

    JTextField nameInput;


    public RaumnummerEnter(JTextField textfield) {
        nameInput = textfield;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            RaumnummerGUI.sRaumnummer = RaumnummerGUI.Answer.getText();
            RaumnummerGUI.bRaumnummer = !DatenErzeugnung.getHmapRooms().containsKey(RaumnummerGUI.sRaumnummer);

            if(!RaumnummerGUI.bRaumnummer){
                JOptionPane.showMessageDialog(RaumnummerGUI.frame, "Raumnummer bereits vorhanden, andere Raumnummer verwenden! ");
                RaumnummerGUI.frame.dispose();
                RaumnummerGUI.createAndShowGui();
            }
            else if(RaumnummerGUI.bRaumnummer){
                RaumeigenschaftenGUI.createAndShowGui();
                RaumnummerGUI.frame.dispose();
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Start.createAndShowGui();
            RaumnummerGUI.frame.dispose();
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
