import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/*Enter a Password
 * compares entered Password with saved in Hashmap
 * if Password is correct, continue with Booking
 * if Password is incorrect show Error Message "Falsches Passwort" and go back to start*/

public class bPasswortGUI {
    static final boolean shouldFIll = true;
    static final boolean shouldWeightx = true;
    static final boolean RIGHT_TO_LEFT = false;
    static JTextField Answer;
    static JLabel Anweisung;
    static JFrame frame;
    static String sEinloggpasswort;
    static boolean bPasswort = true;

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
        c.gridwidth = 1;
        Answer.setFont(new Font("TeleNeo Office", Font.PLAIN, 20));
        Answer.setForeground(Color.black);
        Answer.setHorizontalAlignment(JLabel.LEFT);
        TitledBorder titled = new TitledBorder("Eingabe:");
        titled.setTitleColor(Color.black);
        Answer.setBorder(titled);
        pane.add(Answer, c);

        Anweisung = new JLabel("Passwort: ");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 50;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.gridwidth = 5;
        Anweisung.setFont(new Font("TeleNeo Office", Font.PLAIN, 20));
        Anweisung.setForeground(Color.white);
        Anweisung.setHorizontalAlignment(JLabel.LEFT);
        pane.add(Anweisung, c);

        button = new JButton(new AbstractAction("Eingabe") {
            @Override
            public void actionPerformed(ActionEvent e) {
                sEinloggpasswort = Answer.getText();
                String[] hilfsString = DatenErzeugnung.getHmapMitarbeiter().keySet().toArray(new String[0]);
                for (int i = 0; i < hilfsString.length; i++) {
                    if ((hilfsString[i].equals(ReservierungGUI.sNutzername) ||
                            DatenErzeugnung.getHmapMitarbeiter().get(hilfsString[i]).getsMaName().equals(ReservierungGUI.sNutzername))&&
                            DatenErzeugnung.getHmapMitarbeiter().get(hilfsString[i]).getsPasswort().equals(sEinloggpasswort)) {
                        bPasswort = true;
                        break;
                    } else bPasswort = false;
                }

                if (!bPasswort) {
                    JOptionPane.showMessageDialog(frame, "Falsches Passwort.");
                    frame.dispose();
                    Start.createAndShowGui();
                } else {
                    rNrBuchung.createAndShowGui();
                    frame.dispose();
                }
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
        c.gridy = 2;
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
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        button.setFont(new Font("TeleNeo Office", Font.PLAIN, 30));
        button.setBackground(Color.darkGray);
        button.setForeground(Color.white);
        pane.add(button, c);

        bPasswortEnter listener = new bPasswortEnter(bPasswortGUI.Answer);
        bPasswortGUI.Answer.addKeyListener(listener);
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
