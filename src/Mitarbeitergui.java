import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*Enter a new Name/Username
 * compare entered Username with already existing
 * if Username already in use:
 * instructs u to enter a new one
 * if Username is unique:
 * continues
 * if esc is pressed: cancel and back to start*/

public class MitarbeiterGUI implements KeyListener {
    static final boolean shouldFIll = true;
    static final boolean shouldWeightx = true;
    static final boolean RIGHT_TO_LEFT = false;
    static JTextField Answer;
    static JLabel Anweisung;
    static JFrame frame;
    static String sName;
    static boolean bMA;

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
        gdc.weightx=0;
        gdc.gridwidth=1;
        Answer.setFont(new Font("TeleNeo Office", Font.PLAIN, 20));
        Answer.setForeground(Color.black);
        Answer.setHorizontalAlignment(JLabel.LEFT);
        TitledBorder titled = new TitledBorder("Eingabe:");
        titled.setTitleColor(Color.black);
        Answer.setBorder(titled);
        pane.add(Answer,gdc);

        Anweisung = new JLabel("Name/Benutzername:");
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.ipady = 50;
        gdc.gridx = 0;
        gdc.gridy = 0;
        gdc.weightx=1;
        gdc.gridwidth=5;
        Anweisung.setFont(new Font("TeleNeo Office", Font.PLAIN, 20));
        Anweisung.setForeground(Color.white);
        Anweisung.setHorizontalAlignment(JLabel.LEFT);
        pane.add(Anweisung,gdc);

        button = new JButton(new AbstractAction("Eingabe") {
            @Override
            public void actionPerformed(ActionEvent e) {
                sName = Answer.getText();
                String[] hilfsString = DatenErzeugnung.getHmapMitarbeiter().keySet().toArray(new String[0]);
                for (int i = 0; i < hilfsString.length; i++) {
                    if (hilfsString[i].equals(sName) ||
                            DatenErzeugnung.getHmapMitarbeiter().get(hilfsString[i]).getsMaName().equals(sName)) {
                        bMA = false;
                        break;
                    } else bMA = true;
                }
                if(!bMA){
                    JOptionPane.showMessageDialog(frame,"Mitarbeiter bereits vorhanden, bitte anderen Benutzernamen wählen (evtl. Nachname mit einfügen)");
                    frame.dispose();
                    createAndShowGui();
                }
                else{
                    PasswortGUI.createAndShowGui();
                    frame.dispose();
                }
            }
        });
        if (shouldWeightx){
            gdc.weightx = 0.5;
        }
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.ipady = 30;
        gdc.ipadx = 30;
        gdc.insets = new Insets(5,5,5,5);
        gdc.gridx = 0;
        gdc.gridy = 2;
        gdc.gridwidth = 1;
        gdc.gridheight =1;
        button.setFont(new Font("TeleNeo Office", Font.PLAIN, 30));
        button.setBackground(Color.darkGray);
        button.setForeground(Color.white);
        pane.add(button,gdc);

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
        gdc.gridy = 3;
        button.setFont(new Font("TeleNeo Office", Font.PLAIN, 30));
        button.setBackground(Color.darkGray);
        button.setForeground(Color.white);
        pane.add(button, gdc);

        MitarbeiterGUI listener = new MitarbeiterGUI(Answer);
        Answer.addKeyListener(listener);
    }
    JTextField nameInput;

    public MitarbeiterGUI(JTextField textfield) {
        nameInput = textfield;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            sName = Answer.getText();
            String[] hilfsString = DatenErzeugnung.getHmapMitarbeiter().keySet().toArray(new String[0]);
            for (int i = 0; i < hilfsString.length; i++) {
                if (hilfsString[i].equals(sName) ||
                        DatenErzeugnung.getHmapMitarbeiter().get(hilfsString[i]).getsMaName().equals(sName)) {
                    bMA = false;
                    break;
                } else bMA = true;
            }
            if(!bMA){
                JOptionPane.showMessageDialog(frame,"Mitarbeiter bereits vorhanden, bitte anderen Benutzernamen wählen (evtl. Nachname mit einfügen)");
                frame.dispose();
                createAndShowGui();
            }
            else{
                PasswortGUI.createAndShowGui();
                frame.dispose();
            }
        }
        else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
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


    public static void createAndShowGui(){
        frame = new JFrame("Raumreservierung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);
    }

}
