import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*Enter a new Name/Username
 * compare entered Username with already existing
 * if Username already in use:
 * instructs u to enter a new one
 * if Username is unique:
 * continues
 * if esc is pressed: cancel and back to start*/

public class EnterMagui implements KeyListener {

    JTextField nameInput;

    public EnterMagui(JTextField textfield) {
        nameInput = textfield;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Mitarbeitergui.sName = Mitarbeitergui.Answer.getText();
            String[] hilfsString = DatenErzeugnung.getHmapMitarbeiter().keySet().toArray(new String[0]);
            for (int i = 0; i < hilfsString.length; i++) {
                if (hilfsString[i].equals(Mitarbeitergui.sName) ||
                        DatenErzeugnung.getHmapMitarbeiter().get(hilfsString[i]).getsMaName().equals(Mitarbeitergui.sName)) {
                    Mitarbeitergui.bMA = false;
                    break;
                } else Mitarbeitergui.bMA = true;
            }
            if(!Mitarbeitergui.bMA){
                JOptionPane.showMessageDialog(Mitarbeitergui.frame,"Mitarbeiter bereits vorhanden, bitte anderen Benutzernamen wählen (evtl. Nachname mit einfügen)");
                Mitarbeitergui.frame.dispose();
                Mitarbeitergui.createAndShowGui();
            }
            else{
                Passwortgui.createAndShowGui();
                Mitarbeitergui.frame.dispose();
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Start.createAndShowGui();
            Mitarbeitergui.frame.dispose();
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
