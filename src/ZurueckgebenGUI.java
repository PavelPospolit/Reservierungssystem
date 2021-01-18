import sun.security.krb5.internal.ktab.KeyTabInputStream;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*Enter room Number of the room u want to give back
 * checks if room exists
 * sets availability to true and deletes reservation */


public class ZurueckgebenGUI implements KeyListener {
    static final boolean shouldFIll = true;
    static final boolean shouldWeightx = true;
    static final boolean RIGHT_TO_LEFT = false;
    static JTextField Answer;
    static JLabel Anweisung;
    static JFrame frame;
    static String sZurueckNr;
    static final String UTF8_BOM = "\uFEFF";
    static boolean bRaumverfueg = true;

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
        gdc.gridwidth = 1;
        Answer.setFont(new Font("TeleNeo Office", Font.PLAIN, 20));
        Answer.setForeground(Color.black);
        Answer.setHorizontalAlignment(JLabel.LEFT);
        TitledBorder titled = new TitledBorder("Eingabe:");
        titled.setTitleColor(Color.black);
        Answer.setBorder(titled);
        pane.add(Answer, gdc);

        Anweisung = new JLabel("Welchen Raum wollen Sie zurueckgeben(Raumnummer oder Reservierungsnummer)?");
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.ipady = 50;
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.weightx = 1;
        gdc.gridwidth = 5;
        Anweisung.setFont(new Font("TeleNeo Office", Font.PLAIN, 20));
        Anweisung.setForeground(Color.white);
        Anweisung.setHorizontalAlignment(JLabel.LEFT);
        pane.add(Anweisung, gdc);

        button = new JButton(new AbstractAction("Freigeben") {
            @Override
            public void actionPerformed(ActionEvent e) {
                sZurueckNr = Answer.getText();
                String[] hilfsString = DatenErzeugnung.getHmapReservierungen().keySet().toArray(new String[0]);
                for (int i = 0; i < hilfsString.length; i++) {
                    if (DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]).getsRaumNummer().equals(sZurueckNr)) {
                        DatenErzeugnung.getHmapReservierungen().remove(hilfsString[i]);
                    }
                }
                if (DatenErzeugnung.getHmapRooms().containsKey(sZurueckNr)) {
                    DatenErzeugnung.getHmapRooms().get(sZurueckNr).setVerfuegbarkeit(true);
                }
                JOptionPane.showMessageDialog(frame, "Raum " + sZurueckNr + " erfolgreich freigegeben!");
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

        ZurueckgebenGUI listener = new ZurueckgebenGUI(Answer);
        Answer.addKeyListener(listener);

    }
    JTextField nameInput;

    public ZurueckgebenGUI(JTextField textfield) {
        nameInput = textfield;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            sZurueckNr = Answer.getText();
            String[] hilfsString = DatenErzeugnung.getHmapReservierungen().keySet().toArray(new String[0]);
            for (int i = 0; i < hilfsString.length; i++) {
                if (DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]).getsRaumNummer().equals(sZurueckNr)) {
                    DatenErzeugnung.getHmapReservierungen().remove(hilfsString[i]);
                }
            }
            if (DatenErzeugnung.getHmapRooms().containsKey(sZurueckNr)) {
                DatenErzeugnung.getHmapRooms().get(sZurueckNr).setVerfuegbarkeit(true);
            }
            JOptionPane.showMessageDialog(frame, "Raum " + sZurueckNr + " erfolgreich freigegeben!");
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
        // TODO Auto-generated method stub
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
