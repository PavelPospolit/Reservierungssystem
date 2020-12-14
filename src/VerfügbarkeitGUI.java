import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/*Enter the availability of the room (true/false)
 * saving the entered value in bVerfüg variable
 * creating helper Hashmap
 * creating helper Object (hilfsRäume)
 * adding the data from HmapRooms and the helper object into helper Hashmap
 * overwriting Data in HmapRooms with helper Hashmap Data*/

public class VerfügbarkeitGUI {
    static final boolean shouldFIll = true;
    static final boolean shouldWeightx = true;
    static final boolean RIGHT_TO_LEFT = false;
    static JTextField Answer;
    static JLabel Anweisung;
    static JFrame frame;
    static boolean bVerfüg;

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
        c.weightx = 1;
        c.gridwidth = 2;
        Answer.setFont(new Font("TeleNeo Office", Font.PLAIN, 20));
        Answer.setForeground(Color.black);
        Answer.setHorizontalAlignment(JLabel.LEFT);
        TitledBorder titled = new TitledBorder("Eingabe:");
        titled.setTitleColor(Color.black);
        Answer.setBorder(titled);
        pane.add(Answer, c);

        Anweisung = new JLabel("Aktuell verfügbar? (true/false): ");
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
                bVerfüg = Boolean.parseBoolean(Answer.getText());
                HashMap<String, Räume> hilfsmap = new HashMap<>();
                Räume hilfsRäume = new Räume(
                        RaumGUI.sRaumbezeichnung,
                        RaumnummerGUI.sRaumnummer,
                        RaumeigenschaftenGUI.sEigenschaften,
                        RaumkapazitätGUI.iKapazität,
                        VerfügbarkeitGUI.bVerfüg);
                String[] hilfsString = DatenErzeugnung.getHmapRooms().keySet().toArray(new String[0]);
                for (int i = 0; i < hilfsString.length; i++){
                    hilfsmap.put(hilfsString[i], DatenErzeugnung.getHmapRooms().get(hilfsString[i]));
                }
                DatenErzeugnung.setHmapRooms(hilfsmap);
                JOptionPane.showMessageDialog(frame, "Raum erfolgreich hinzugefügt.");
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

        VerfügbarkeitEnter listener = new VerfügbarkeitEnter(VerfügbarkeitGUI.Answer);
        VerfügbarkeitGUI.Answer.addKeyListener(listener);
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
