import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/*Enter a Password
 * create a random 8 digit Number for EmployeeID
 * construct Employee ID with MA+random Number (e.g. MA918529358)
 * create new helper Hashmap
 * put in new entered Data and Data from Hashmap HmapMitarbeiter
 * overwrite Data in HmapMitarbeiter with the Data in new helper Hashmap*/

public class Passwortgui {
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
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFIll) {
            c.fill = GridBagConstraints.HORIZONTAL;
        }
        Answer = new JTextField();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0;
        c.gridwidth = 2;
        Answer.setFont(new Font("TeleNeo Office", Font.PLAIN, 20));
        Answer.setForeground(Color.black);
        Answer.setHorizontalAlignment(JLabel.LEFT);
        TitledBorder titled = new TitledBorder("Eingabe:");
        titled.setTitleColor(Color.black);
        Answer.setBorder(titled);
        pane.add(Answer, c);

        Anweisung = new JLabel("Passwort:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 50;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.gridwidth = 2;
        Anweisung.setFont(new Font("TeleNeo Office", Font.PLAIN, 20));
        Anweisung.setForeground(Color.white);
        Anweisung.setHorizontalAlignment(JLabel.LEFT);
        pane.add(Anweisung, c);

        button = new JButton(new AbstractAction("Anlegen") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random_Number_Generator rand = new Random_Number_Generator();
                sPasswort = Answer.getText();
                int iRand = rand.MaRandomNumber();
                sMitarbeiternummer = "MA" + iRand;
                HashMap<String, Mitarbeiter> hilfsmap = new HashMap<>();
                Mitarbeiter hilfsMa = new Mitarbeiter(
                        Mitarbeitergui.sName,
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
                Start.createAndShowGui();
            }
        });
        if (shouldWeightx) {
            c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.ipadx = 30;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        button.setFont(new Font("TeleNeo Office", Font.PLAIN, 30));
        button.setBackground(Color.darkGray);
        button.setForeground(Color.white);
        pane.add(button, c);

        button = new JButton(new AbstractAction("Cancel") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Start.createAndShowGui();
                frame.dispose();
            }
        });
        if (shouldWeightx) {
            c.weightx = 0.5;
        }
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30;
        c.ipadx = 30;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.gridheight = 1;
        button.setFont(new Font("TeleNeo Office", Font.PLAIN, 30));
        button.setBackground(Color.darkGray);
        button.setForeground(Color.white);
        pane.add(button, c);

        EnterPW listener = new EnterPW(Passwortgui.Answer);
        Passwortgui.Answer.addKeyListener(listener);
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
