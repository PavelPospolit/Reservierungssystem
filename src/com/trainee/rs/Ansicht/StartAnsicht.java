package com.trainee.rs.Ansicht;

import com.trainee.rs.actions.Schreiben;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

/*creates the start window with all the buttons*/

public class StartAnsicht {
    static final boolean shouldFIll = true;
    static final boolean shouldWeightx = true;
    static final boolean RIGHT_TO_LEFT = false;
    public static JFrame frame;
    static boolean bUpdate;

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


        JButton button1 = new JButton(new AbstractAction("Neuer Mitarbeiter") {
            @Override
            public void actionPerformed(ActionEvent e) {
                MitarbeiterGUI.createAndShowGui();
                frame.dispose();
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
        gdc.gridy = 0;
        button1.setFont(new Font("TeleNeo Office", Font.PLAIN, 30));
        button1.setBackground(Color.darkGray);
        button1.setForeground(Color.white);
        pane.add(button1, gdc);

        button = new JButton(new AbstractAction("Neuer Raum") {
            @Override
            public void actionPerformed(ActionEvent e) {
                RaumGUI.createAndShowGui();
                frame.dispose();
            }
        });
        if (shouldWeightx) {
            gdc.weightx = 0.5;
        }
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.insets = new Insets(5, 5, 5, 5);
        gdc.gridx = 1;
        gdc.gridy = 0;
        button.setFont(new Font("TeleNeo Office", Font.PLAIN, 30));
        button.setBackground(Color.darkGray);
        button.setForeground(Color.white);
        pane.add(button, gdc);

        button = new JButton(new AbstractAction("Raum Buchen") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReservierungGUI.createAndShowGui();
                frame.dispose();
            }
        });
        if (shouldWeightx) {
            gdc.weightx = 0.5;
        }
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.insets = new Insets(5, 5, 5, 5);
        gdc.gridx = 0;
        gdc.gridy = 1;
        button.setFont(new Font("TeleNeo Office", Font.PLAIN, 30));
        button.setBackground(Color.darkGray);
        button.setForeground(Color.white);
        pane.add(button, gdc);

        button = new JButton(new AbstractAction("Raum freigeben") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZurueckgebenGUI.createAndShowGui();
                frame.dispose();
            }
        });
        if (shouldWeightx) {
            gdc.weightx = 0.5;
        }
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.insets = new Insets(5, 5, 5, 5);
        gdc.gridx = 1;
        gdc.gridy = 1;
        button.setFont(new Font("TeleNeo Office", Font.PLAIN, 30));
        button.setBackground(Color.darkGray);
        button.setForeground(Color.white);
        pane.add(button, gdc);

        button = new JButton(new AbstractAction("Mitarbeiter, Räume, Reservierungen anzeigen") {
            @Override
            public void actionPerformed(ActionEvent e) {
                bUpdate = true;
                StartAnsicht.frame.dispose();
                StartAnsicht.createAndShowGui();
                if (AlleListen.frame != null) {
                    AlleListen.frame.dispose();
                    AlleListen.createAndShowGui();
                } else {
                    AlleListen.createAndShowGui();
                }
            }
        });
        if (shouldWeightx) {
            gdc.weightx = 0.5;
        }
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.insets = new Insets(5, 5, 5, 5);
        gdc.gridx = 0;
        gdc.gridy = 2;
        button.setFont(new Font("TeleNeo Office", Font.PLAIN, 30));
        button.setBackground(Color.darkGray);
        button.setForeground(Color.white);
        pane.add(button, gdc);

        button = new JButton(new AbstractAction("Speichern & Beenden") {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Schreiben s = new Schreiben();
                } catch (IOException ioException) {
                    JOptionPane.showMessageDialog(StartAnsicht.frame, "Es ist ein Fehler beim com.trainee.rs.actions.Schreiben aufgetreten, Support Kontaktieren!",
                            "SCHREIBFEHLER", JOptionPane.ERROR_MESSAGE);
                }
                System.exit(0);
            }

        });
        if (shouldWeightx) {
            gdc.weightx = 0.5;
        }
        gdc.fill = GridBagConstraints.HORIZONTAL;
        gdc.insets = new Insets(5, 5, 5, 5);
        gdc.gridx = 1;
        gdc.gridy = 2;
        button.setFont(new Font("TeleNeo Office", Font.PLAIN, 30));
        button.setBackground(Color.darkGray);
        button.setForeground(Color.white);
        pane.add(button, gdc);
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
