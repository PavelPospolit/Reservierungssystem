import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/*enter room capacity
 * safe entered capacity in variable iKapazität*/

public class RaumkapazitätEnter implements KeyListener {

    JTextField nameInput;

    public RaumkapazitätEnter(JTextField textfield) {
        nameInput = textfield;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            RaumkapazitätGUI.iKapazität = Integer.parseInt(RaumkapazitätGUI.Answer.getText());
            VerfügbarkeitGUI.createAndShowGui();
            RaumkapazitätGUI.frame.dispose();
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Start.createAndShowGui();
            RaumkapazitätGUI.frame.dispose();
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
