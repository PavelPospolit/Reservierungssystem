import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*Enter the availability of the room (true/false)
 * saving the entered value in bVerfüg variable
 * creating helper Hashmap
 * creating helper Object (hilfsRäume)
 * adding the data from HmapRooms and the helper object into helper Hashmap
 * overwriting Data in HmapRooms with helper Hashmap Data*/

public class VerfügbarkeitEnter implements KeyListener {

    JTextField nameInput;

    public VerfügbarkeitEnter(JTextField textfield) {
        nameInput = textfield;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            VerfügbarkeitGUI.bVerfüg = Boolean.parseBoolean(VerfügbarkeitGUI.Answer.getText());
            HashMap<String, Räume> hilfsmap = new HashMap<>();
            Räume hilfsRäume = new Räume(
                    RaumGUI.sRaumbezeichnung,
                    RaumnummerGUI.sRaumnummer,
                    RaumeigenschaftenGUI.sEigenschaften,
                    RaumkapazitätGUI.iKapazität,
                    VerfügbarkeitGUI.bVerfüg);
            hilfsmap.put(RaumnummerGUI.sRaumnummer, hilfsRäume);
            String[] hilfsString = DatenErzeugnung.getHmapRooms().keySet().toArray(new String[0]);
            for (int i = 0; i < hilfsString.length; i++){
                hilfsmap.put(hilfsString[i], DatenErzeugnung.getHmapRooms().get(hilfsString[i]));
            }
            DatenErzeugnung.setHmapRooms(hilfsmap);
            JOptionPane.showMessageDialog(VerfügbarkeitGUI.frame, "Raum erfolgreich hinzugefügt.");
            VerfügbarkeitGUI.frame.dispose();
            Start.createAndShowGui();
        }
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Start.createAndShowGui();
            VerfügbarkeitGUI.frame.dispose();
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
