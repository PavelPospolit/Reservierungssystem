import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/*ON ENTER PRESS:
 *reate a random Number with 8 digits
 * repeat that process untill its a unique Booking ID
 *make Booking ID start with BU * randomNumber
 * create a helper Hashmap and fill witht he new Data and add Data from HmapRooms
 * overwrite  the Data in HmapRooms with Data from Helper Hashmap
 *
 * ON ESC PRESS:
 * cancels the programm and goes back to start, deletes all changes*/

public class BisGUI {
    static final boolean shouldFIll = true;
    static final boolean shouldWeightx = true;
    static final boolean RIGHT_TO_LEFT = false;
    static JTextField Answer;
    static JLabel Anweisung;
    static JFrame frame;
    static String sBis;

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

        Anweisung = new JLabel("Bis wann(dd.mm.yy;hh:mm):");
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

        button = new JButton(new AbstractAction("Buchen") {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random_Number_Generator rand = new Random_Number_Generator();
                sBis = Answer.getText();
                int iRand = rand.ResRandomNumber();
                String Buchungsnummer = "BU" + iRand;
                HashMap<String, Reservierungen> hilfsmap = new HashMap<>();
                Reservierungen hilfsRes = new Reservierungen(
                        Buchungsnummer,
                        DatenErzeugnung.getHmapMitarbeiter().get(ReservierungGUI.sÜbergabe).getsMaName(),
                        rNrBuchung.sResRNR,
                        BisGUI.sBis);
                hilfsmap.put(Buchungsnummer, hilfsRes);
                String[] hilfsString = DatenErzeugnung.getHmapReservierungen().keySet().toArray(new String[0]);
                for (int i = 0; i < hilfsString.length; i++) {
                    hilfsmap.put(hilfsString[i], DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]));
                }
                DatenErzeugnung.setHmapReservierungen(hilfsmap);
                JOptionPane.showMessageDialog(frame, "Buchung erfolgreich abgeschlossen!");
                frame.dispose();
                if (DatenErzeugnung.getHmapRooms().containsKey(rNrBuchung.sResRNR)) {
                    DatenErzeugnung.getHmapRooms().get(rNrBuchung.sResRNR).setVerfügbarkeit(false);
                }
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

        BisEnter listener = new BisEnter(BisGUI.Answer);
        BisGUI.Answer.addKeyListener(listener);
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
