import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

/*Enter a Password
 * create a random 8 digit Number for EmployeeID
 * construct Employee ID with MA+random Number (e.g. MA918529358)
 * create new helper Hashmap
 * put in new entered Data and Data from Hashmap HmapMitarbeiter
 * overwrite Data in HmapMitarbeiter with the Data in new helper Hashmap*/

public class PasswortGUI implements KeyListener {
    static final boolean shouldFIll = true;
    static final boolean shouldWeightx = true;
    static final boolean RIGHT_TO_LEFT = false;
    static JTextField Answer;
    static JLabel Anweisung;
    static JFrame frame;
    static String sPasswort;
    static String sMitarbeiternummer;

    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        JButton button;
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gdc = new GridBagConstraints();
        if (shouldFIll) {
            gdc.fill = GridBagConstraints.HORIZONTAL;
        }
        Answer = new JTextField();
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.ipady = 20;
        gdc.gridx = 0;
        gdc.gridy = 1;
        gdc.weightx = 0;
        gdc.gridwidth = 2;
        Answer.setFont(new Font("TeleNeo Office", Font.PLAIN, 20));
        Answer.setForeground(Color.black);
        Answer.setHorizontalAlignment(JLabel.LEFT);
        TitledBorder titled = new TitledBorder("Eingabe:");
        titled.setTitleColor(Color.black);
        Answer.setBorder(titled);
        pane.add(Answer, gdc);

        Anweisung = new JLabel("Passwort:");
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.ipady = 50;
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.weightx = 1;
        gdc.gridwidth = 2;
        Anweisung.setFont(new Font("TeleNeo Office", Font.PLAIN, 20));
        Anweisung.setForeground(Color.white);
        Anweisung.setHorizontalAlignment(JLabel.LEFT);
        pane.add(Anweisung, gdc);

        button = new JButton(new AbstractAction("Anlegen") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random_Number_Generator rand = new Random_Number_Generator();
                sPasswort = Answer.getText();
                int iRand = rand.MaRandomNumber();
                sMitarbeiternummer = "MA" + iRand;
                HashMap<String, Mitarbeiter> hilfsmap = new HashMap<>();
                Mitarbeiter hilfsMa = new Mitarbeiter(
                        MitarbeiterGUI.sName,
                        sMitarbeiternummer,
                        sPasswort);
                hilfsmap.put(sMitarbeiternummer, hilfsMa);
                String[] hilfsString = DatenErzeugnung.getHmapMitarbeiter().keySet().toArray(new String[0]);
                for (int i = 0; i < hilfsString.length; i++){
                    hilfsmap.put(hilfsString[i], DatenErzeugnung.getHmapMitarbeiter().get(hilfsString[i]));
                }
                DatenErzeugnung.setHmapMitarbeiter(hilfsmap);
                JOptionPane.showMessageDialog(frame, "Mitarbeiter erfolgreich hinzugefügt.");
                frame.dispose();
                StartAnsicht.createAndShowGui();
            }
        });
        if (shouldWeightx) {
            gdc.weightx = 0.5;
        }
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.ipady = 30;
        gdc.ipadx = 30;
        gdc.insets = new Insets(5, 5, 5, 5);
        gdc.gridx = 0;
        gdc.gridy = 3;
        gdc.gridwidth = 1;
        gdc.gridheight = 1;
        button.setFont(new Font("TeleNeo Office", Font.PLAIN, 30));
        button.setBackground(Color.darkGray);
        button.setForeground(Color.white);
        pane.add(button, gdc);

        button = new JButton(new AbstractAction("Cancel") {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartAnsicht.createAndShowGui();
                frame.dispose();
            }
        });
        if (shouldWeightx) {
            gdc.weightx = 0.5;
        }
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.insets = new Insets(5, 5, 5, 5);
        gdc.gridx = 0;
        gdc.gridy = 4;
        button.setFont(new Font("TeleNeo Office", Font.PLAIN, 30));
        button.setBackground(Color.darkGray);
        button.setForeground(Color.white);
        pane.add(button, gdc);

        PasswortGUI listener = new PasswortGUI(Answer);
        Answer.addKeyListener(listener);
    }
    JTextField nameInput;

    public PasswortGUI(JTextField textfield) {
        nameInput = textfield;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            Random_Number_Generator rand = new Random_Number_Generator();
            sPasswort = Answer.getText();
            int iRand = rand.MaRandomNumber();
            sMitarbeiternummer = "MA" + iRand;
            HashMap<String, Mitarbeiter> hilfsmap = new HashMap<>();
            Mitarbeiter hilfsMa = new Mitarbeiter(
                    MitarbeiterGUI.sName,
                    sMitarbeiternummer,
                    sPasswort);
            hilfsmap.put(sMitarbeiternummer, hilfsMa);
            String[] hilfsString = DatenErzeugnung.getHmapMitarbeiter().keySet().toArray(new String[0]);
            for (int i = 0; i < hilfsString.length; i++) {
                hilfsmap.put(hilfsString[i], DatenErzeugnung.getHmapMitarbeiter().get(hilfsString[i]));
            }
            DatenErzeugnung.setHmapMitarbeiter(hilfsmap);
            JOptionPane.showMessageDialog(frame, "Mitarbeiter erfolgreich hinzugefügt.");
            frame.dispose();
            StartAnsicht.createAndShowGui();
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            StartAnsicht.createAndShowGui();
            frame.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }


    public static void createAndShowGui() {
        frame = new JFrame("Raumreservierung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);
    }

}
