import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/*Enter a new Room Description
 * safe entered Description in variable sRaumbezeichnung*/

public class RaumBezEnter implements KeyListener {

    JTextField nameInput;


    public RaumBezEnter(JTextField textfield) {
        nameInput = textfield;
    }



    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            RaumGUI.sRaumbezeichnung = RaumGUI.Answer.getText();
            RaumnummerGUI.createAndShowGui();
            RaumGUI.frame.dispose();
        }
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Start.createAndShowGui();
            RaumGUI.frame.dispose();
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
