package com.trainee.rs.Ansicht;

import com.trainee.rs.ressources.DatenErzeugnung;
import com.trainee.rs.ressources.Konstanten;

import javax.swing.*;
import java.awt.*;

/*Checks if Hashmaps are empty
 * if not empty: creates Labels and Textareas
 * Names Labels (e.g.: Mitarbeiter, Raeume, com.trainee.rs.Classes.Reservierungen)
 * puts Data from HashMap into associating Texarea (e.g:: Employee Names into Textarea with the first line "Name:\n"*/

public class AlleListen {
    static final boolean shouldFIll = true;
    static final boolean RIGHT_TO_LEFT = false;
    static JTextArea Mitarbeitername;
    static JTextArea Mitarbeiternummer;
    static JTextArea Raumbezeichnung;
    static JTextArea RaumNummer;
    static JTextArea RaumEigenschaften;
    static JTextArea RaumKapazitaet;
    static JTextArea RaumVerfuegbarkeit;
    static JTextArea ReservierungNameMA;
    static JTextArea ReservierungRaumNummer;
    static JTextArea ReservierungEndDatum;
    static JLabel lMitarbeiter;
    static JLabel lRaeume;
    static JLabel lReservierungen;
    static JFrame frame;

    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        pane.setLayout(new GridBagLayout());
        GridBagConstraints gdc = new GridBagConstraints();
        if (shouldFIll) {
            gdc.fill = GridBagConstraints.HORIZONTAL;
        }
        if (DatenErzeugnung.getHmapMitarbeiter().size() != 0) {
            Mitarbeitername = new JTextArea("Name:\n");
            gdc.fill = GridBagConstraints.HORIZONTAL;
            gdc.gridx = 0;
            gdc.gridy = 1;
            gdc.weightx = 5;
            gdc.gridwidth = 1;
            Mitarbeitername.setBorder(Konstanten.Listen_Border);
            Mitarbeitername.setBackground(Color.black);
            Mitarbeitername.setFont(Konstanten.Listen_Font);
            Mitarbeitername.setForeground(Color.white);
            pane.add(Mitarbeitername, gdc);
            
            Mitarbeiternummer = new JTextArea("Mitarbeiternummer:\n");
            gdc.fill = GridBagConstraints.HORIZONTAL;
            gdc.gridx = 1;
            gdc.gridy = 1;
            Mitarbeiternummer.setBorder(Konstanten.Listen_Border);
            Mitarbeiternummer.setBackground(Color.black);
            Mitarbeiternummer.setFont(Konstanten.Listen_Font);
            Mitarbeiternummer.setForeground(Color.white);
            pane.add(Mitarbeiternummer, gdc);

            String[] hilfsString = DatenErzeugnung.getHmapMitarbeiter().keySet().toArray(new String[0]);
            for (int i = 0; i < hilfsString.length; i++) {
                Mitarbeiternummer.setText(Mitarbeiternummer.getText() + hilfsString[i] + "\n");
                Mitarbeitername.setText(Mitarbeitername.getText() + DatenErzeugnung.getHmapMitarbeiter().get(hilfsString[i]).getsMaName() + "\n");
            }

            lMitarbeiter = new JLabel("MITARBEITER:  ");
            gdc.fill = GridBagConstraints.HORIZONTAL;
            gdc.gridx = 0;
            gdc.gridy = 0;
            gdc.weightx = 1;
            gdc.gridwidth = 1;
            lMitarbeiter.setBorder(Konstanten.Listen_Border);
            lMitarbeiter.setFont(Konstanten.Listen_Font);
            lMitarbeiter.setForeground(Color.white);
            lMitarbeiter.setHorizontalAlignment(JLabel.LEFT);
            pane.add(lMitarbeiter, gdc);
        }
        if (DatenErzeugnung.getHmapRooms().size() != 0) {
            Raumbezeichnung = new JTextArea("Bezeichnung:\n");
            gdc.fill = GridBagConstraints.HORIZONTAL;
            gdc.gridx = 0;
            gdc.gridy = 7;
            Raumbezeichnung.setBorder(Konstanten.Listen_Border);
            Raumbezeichnung.setBackground(Color.black);
            Raumbezeichnung.setFont(Konstanten.Listen_Font);
            Raumbezeichnung.setForeground(Color.white);
            pane.add(Raumbezeichnung, gdc);

            RaumNummer = new JTextArea("Nummer:\n");
            gdc.fill = GridBagConstraints.HORIZONTAL;
            gdc.gridx = 1;
            gdc.gridy = 7;
            RaumNummer.setBorder(Konstanten.Listen_Border);
            RaumNummer.setBackground(Color.black);
            RaumNummer.setFont(Konstanten.Listen_Font);
            RaumNummer.setForeground(Color.white);
            pane.add(RaumNummer, gdc);

            RaumEigenschaften = new JTextArea("Eigenschaften:\n");
            gdc.fill = GridBagConstraints.HORIZONTAL;
            gdc.gridx = 2;
            gdc.gridy = 7;
            RaumEigenschaften.setBorder(Konstanten.Listen_Border);
            RaumEigenschaften.setBackground(Color.black);
            RaumEigenschaften.setFont(Konstanten.Listen_Font);
            RaumEigenschaften.setForeground(Color.white);
            pane.add(RaumEigenschaften, gdc);

            RaumKapazitaet = new JTextArea("Kapazitaet:\n");
            gdc.fill = GridBagConstraints.HORIZONTAL;
            gdc.gridx = 3;
            gdc.gridy = 7;
            RaumKapazitaet.setBorder(Konstanten.Listen_Border);
            RaumKapazitaet.setBackground(Color.black);
            RaumKapazitaet.setFont(Konstanten.Listen_Font);
            RaumKapazitaet.setForeground(Color.white);
            pane.add(RaumKapazitaet, gdc);

            RaumVerfuegbarkeit = new JTextArea("Verfuegbarkeit:\n");
            gdc.fill = GridBagConstraints.HORIZONTAL;
            gdc.gridx = 4;
            gdc.gridy = 7;
            RaumVerfuegbarkeit.setBorder(Konstanten.Listen_Border);
            RaumVerfuegbarkeit.setBackground(Color.black);
            RaumVerfuegbarkeit.setFont(Konstanten.Listen_Font);
            RaumVerfuegbarkeit.setForeground(Color.white);
            pane.add(RaumVerfuegbarkeit, gdc);

            String[] hilfsString = DatenErzeugnung.getHmapRooms().keySet().toArray(new String[0]);
            for (int i = 0; i < hilfsString.length; i++) {
                RaumNummer.setText(RaumNummer.getText() + DatenErzeugnung.getHmapRooms().get(hilfsString[i]).getRaumNr() + "\n");
                Raumbezeichnung.setText(Raumbezeichnung.getText() + DatenErzeugnung.getHmapRooms().get(hilfsString[i]).getBezeichnung() + "\n");
                RaumEigenschaften.setText(RaumEigenschaften.getText() + DatenErzeugnung.getHmapRooms().get(hilfsString[i]).getEigenschaften() + "\n");
                RaumKapazitaet.setText(RaumKapazitaet.getText() + DatenErzeugnung.getHmapRooms().get(hilfsString[i]).getKapazitaet() + "\n");
                RaumVerfuegbarkeit.setText(RaumVerfuegbarkeit.getText() + DatenErzeugnung.getHmapRooms().get(hilfsString[i]).getVerfuegbarkeit() + "\n");
            }

            lRaeume = new JLabel("RÄUME:  ");
            gdc.fill = GridBagConstraints.HORIZONTAL;
            gdc.gridx = 0;
            gdc.gridy = 6;
            gdc.weightx = 1;
            gdc.gridwidth = 1;
            lRaeume.setBorder(Konstanten.Listen_Border);
            lRaeume.setFont(Konstanten.Listen_Font);
            lRaeume.setForeground(Color.white);
            lRaeume.setHorizontalAlignment(JLabel.LEFT);
            pane.add(lRaeume, gdc);
        }

        if (DatenErzeugnung.getHmapReservierungen().size() != 0) {
            ReservierungNameMA = new JTextArea("Name:\n");
            gdc.fill = GridBagConstraints.HORIZONTAL;
            gdc.gridx = 0;
            gdc.gridy = 9;
            ReservierungNameMA.setBorder(Konstanten.Listen_Border);
            ReservierungNameMA.setBackground(Color.black);
            ReservierungNameMA.setFont(Konstanten.Listen_Font);
            ReservierungNameMA.setForeground(Color.white);
            pane.add(ReservierungNameMA, gdc);

            ReservierungRaumNummer = new JTextArea("Raumnummer:\n");
            gdc.fill = GridBagConstraints.HORIZONTAL;
            gdc.gridx = 1;
            gdc.gridy = 9;
            ReservierungRaumNummer.setBorder(Konstanten.Listen_Border);
            ReservierungRaumNummer.setBackground(Color.black);
            ReservierungRaumNummer.setFont(Konstanten.Listen_Font);
            ReservierungRaumNummer.setForeground(Color.white);
            pane.add(ReservierungRaumNummer, gdc);

            ReservierungEndDatum = new JTextArea("Bis wann reserviert:\n");
            gdc.fill = GridBagConstraints.HORIZONTAL;
            gdc.gridx = 2;
            gdc.gridy = 9;
            ReservierungEndDatum.setBorder(Konstanten.Listen_Border);
            ReservierungEndDatum.setBackground(Color.black);
            ReservierungEndDatum.setFont(Konstanten.Listen_Font);
            ReservierungEndDatum.setForeground(Color.white);
            pane.add(ReservierungEndDatum, gdc);

            String[] hilfsString = DatenErzeugnung.getHmapReservierungen().keySet().toArray(new String[0]);
            for (int i = 0; i < hilfsString.length; i++) {
                ReservierungNameMA.setText(ReservierungNameMA.getText() + DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]).getSmaName() + "\n");
                ReservierungRaumNummer.setText(ReservierungRaumNummer.getText() + DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]).getsRaumNummer() + "\n");
                ReservierungEndDatum.setText(ReservierungEndDatum.getText() + DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]).getsBisWann() + "\n");

            }

            lReservierungen = new JLabel("RESERVIERUNGEN:  ");
            gdc.fill = GridBagConstraints.HORIZONTAL;
            gdc.ipady = 50;
            gdc.gridx = 0;
            gdc.gridy = 8;
            gdc.weightx = 1;
            gdc.gridwidth = 1;
            lReservierungen.setBorder(Konstanten.Listen_Border);
            lReservierungen.setFont(Konstanten.Listen_Font);
            lReservierungen.setForeground(Color.white);
            lReservierungen.setHorizontalAlignment(JLabel.LEFT);
            pane.add(lReservierungen, gdc);
        }
    }


    public static void createAndShowGui() {
        frame = new JFrame("Raumreservierung");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.black);
    }
}