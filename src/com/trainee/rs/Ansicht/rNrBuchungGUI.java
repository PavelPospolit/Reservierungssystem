package com.trainee.rs.Ansicht;

import com.trainee.rs.ressources.DatenErzeugnung;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*Enter the room number u want to book
 * checks if room does exist and is available
 * if yes: continue
 * if no: cancel and go back to start*/

public class rNrBuchungGUI implements KeyListener {
    static final boolean shouldFIll = true;
    static final boolean shouldWeightx = true;
    static final boolean RIGHT_TO_LEFT = false;
    static JTextField Answer;
    static JLabel Anweisung;
    static JFrame frame;
    static String sResRNR;
    static boolean bRaumverfueg = true;

    public static void addComponentsToPane(Container pane){
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

        Anweisung = new JLabel("Raumnummer:  ");
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

        button = new JButton(new AbstractAction("Eingabe:") {
            @Override
            public void actionPerformed(ActionEvent e) {
                sResRNR = Answer.getText();
                bRaumverfueg = DatenErzeugnung.getHmapRooms().containsKey(sResRNR)
                        && (DatenErzeugnung.getHmapRooms().get(sResRNR).getVerfuegbarkeit()) == true;
                if (bRaumverfueg) {
                    BisGUI.createAndShowGui();
                    frame.dispose();
                } else if (bRaumverfueg == false) {
                    JOptionPane.showMessageDialog(frame, "Raum nicht gefunden oder nicht vorhanden!");
                    frame.dispose();
                    StartAnsicht.createAndShowGui();
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
        gdc.gridy = 2;
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
        gdc.gridy = 3;
        button.setFont(new Font("TeleNeo Office", Font.PLAIN, 30));
        button.setBackground(Color.darkGray);
        button.setForeground(Color.white);
        pane.add(button, gdc);

        rNrBuchungGUI listener = new rNrBuchungGUI(Answer);
        Answer.addKeyListener(listener);
    }

    JTextField nameInput;


    public rNrBuchungGUI(JTextField textfield) {
        nameInput = textfield;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            sResRNR = Answer.getText();
            bRaumverfueg = DatenErzeugnung.getHmapRooms().containsKey(sResRNR)
                    && DatenErzeugnung.getHmapRooms().get(sResRNR).getVerfuegbarkeit() == true;
            if (bRaumverfueg) {
                BisGUI.createAndShowGui();
                frame.dispose();
            } else if (bRaumverfueg == false) {
                JOptionPane.showMessageDialog(frame, "Raum nicht gefunden oder nicht vorhanden!");
                frame.dispose();
                StartAnsicht.createAndShowGui();
            }
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
    
    public static void createAndShowGui(){
        frame = new JFrame("Raumreservierung");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);
    }

}
