import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

public class BisGUI implements KeyListener {
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

        Anweisung = new JLabel("Bis wann(dd.mm.yy;hh:mm):");
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

        button = new JButton(new AbstractAction("Buchen") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Random_Number_Generator rand = new Random_Number_Generator();
                    sBis = Answer.getText();
                    Konstanten.df.parse(sBis);
                    int iRand = rand.ResRandomNumber();
                    String Buchungsnummer = "BU" + iRand;
                    HashMap<String, Reservierungen> hilfsmap = new HashMap<>();
                    Reservierungen hilfsRes = new Reservierungen(
                            Buchungsnummer,
                            DatenErzeugnung.getHmapMitarbeiter().get(ReservierungGUI.sÜbergabe).getsMaName(),
                            rNrBuchungGUI.sResRNR,
                            sBis);
                    hilfsmap.put(Buchungsnummer, hilfsRes);
                    String[] hilfsString = DatenErzeugnung.getHmapReservierungen().keySet().toArray(new String[0]);
                    for (int i = 0; i < hilfsString.length; i++) {
                        hilfsmap.put(hilfsString[i], DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]));
                    }
                    DatenErzeugnung.setHmapReservierungen(hilfsmap);
                    JOptionPane.showMessageDialog(frame, "Buchung erfolgreich abgeschlossen!");
                    frame.dispose();
                    if (DatenErzeugnung.getHmapRooms().containsKey(rNrBuchungGUI.sResRNR)) {
                        DatenErzeugnung.getHmapRooms().get(rNrBuchungGUI.sResRNR).setVerfuegbarkeit(false);
                    }
                    StartAnsicht.createAndShowGui();
                }
                catch(ParseException a){
                    JOptionPane.showMessageDialog(frame, "Falsches Zeitformat. Bitte das Zeitformat "+(Konstanten.df.toPattern())+" nutzen", "Formatfehler",
                            JOptionPane.ERROR_MESSAGE);
                    frame.dispose();
                    createAndShowGui();
                }
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

        BisGUI listener = new BisGUI(Answer);
        Answer.addKeyListener(listener);
    }
    public BisGUI(JTextField textfield) {
        JTextField nameInput;
        nameInput = textfield;
    }


    public static void createAndShowGui() {
        frame = new JFrame("Raumreservierung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);
    }

    

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                Random_Number_Generator rand = new Random_Number_Generator();
                sBis = Answer.getText();
                Konstanten.df.parse(sBis);
                int iRand = rand.ResRandomNumber();
                String Buchungsnummer = "BU" + iRand;
                HashMap<String, Reservierungen> hilfsmap = new HashMap<>();
                Reservierungen hilfsRes = new Reservierungen(
                        Buchungsnummer,
                        DatenErzeugnung.getHmapMitarbeiter().get(ReservierungGUI.sÜbergabe).getsMaName(),
                        rNrBuchungGUI.sResRNR,
                        sBis);
                hilfsmap.put(Buchungsnummer, hilfsRes);
                String[] hilfsString = DatenErzeugnung.getHmapReservierungen().keySet().toArray(new String[0]);
                for (int i = 0; i < hilfsString.length; i++) {
                    hilfsmap.put(hilfsString[i], DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]));
                }
                DatenErzeugnung.setHmapReservierungen(hilfsmap);
                JOptionPane.showMessageDialog(frame, "Buchung erfolgreich abgeschlossen!");
                frame.dispose();
                if (DatenErzeugnung.getHmapRooms().containsKey(rNrBuchungGUI.sResRNR)) {
                    DatenErzeugnung.getHmapRooms().get(rNrBuchungGUI.sResRNR).setVerfuegbarkeit(false);
                }
                StartAnsicht.createAndShowGui();
            }
            catch(ParseException a){
                JOptionPane.showMessageDialog(frame, "Falsches Zeitformat. Bitte das Zeitformat "+(Konstanten.df.toPattern())+" nutzen", "Formatfehler",
                        JOptionPane.ERROR_MESSAGE);
                frame.dispose();
                createAndShowGui();
            }
        }


        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            StartAnsicht.createAndShowGui();
            frame.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
}
