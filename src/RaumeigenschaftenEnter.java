import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/*Enter Room features
 * safe entered features in variable sEigenschaften*/

public class RaumeigenschaftenEnter implements KeyListener {

    JTextField nameInput;

    public RaumeigenschaftenEnter(JTextField textfield) {
        nameInput = textfield;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            RaumeigenschaftenGUI.sEigenschaften = RaumeigenschaftenGUI.Answer.getText();
            RaumkapazitätGUI.createAndShowGui();
            RaumeigenschaftenGUI.frame.dispose();
        }
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Start.createAndShowGui();
            RaumeigenschaftenGUI.frame.dispose();
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
