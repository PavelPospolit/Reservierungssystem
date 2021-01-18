package com.trainee.rs.ressources;

import com.trainee.rs.Ansicht.StartAnsicht;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;


/*
 *List of constants
 *font, colors, Border, paths,...;
 */

public class Konstanten {

    public static  final Font Listen_Font = new Font("TeleNeo Office", Font.PLAIN, 20);
    public static  final Border Listen_Border = new LineBorder(new java.awt.Color(170, 20, 150));
    public static  final File rFile = new File("src\\com\\trainee\\rs\\ressources\\Raumliste.txt");
    public static  final File mFile = new File("src\\com\\trainee\\rs\\ressources\\Mitarbeiter.txt");
    public static  final File resFile = new File("src\\com\\trainee\\rs\\ressources\\Reservierungen.txt");
    public static  SimpleDateFormat df = new SimpleDateFormat("dd.MM.yy;HH:mm");


    public static  BufferedReader mEinlesen;
    static  {
        try {
            mEinlesen = new BufferedReader(new FileReader("src\\com\\trainee\\rs\\ressources\\Mitarbeiter.txt"));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(StartAnsicht.frame, "Mitarbeiterliste nicht gefunden, bitte Support kontaktieren",
                    "DATEI FEHLT", JOptionPane.ERROR_MESSAGE);

        }
    }

    public static  BufferedReader rEinlesen;
    static  {
        try {
            rEinlesen = new BufferedReader(new FileReader("src\\com\\trainee\\rs\\ressources\\Raumliste.txt"));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(StartAnsicht.frame, "Raumliste nicht gefunden, bitte Support kontaktieren",
                    "DATEI FEHLT", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static  BufferedReader resEinlesen;
    static  {
        try {
            resEinlesen = new BufferedReader(new FileReader("src\\com\\trainee\\rs\\ressources\\Reservierungen.txt"));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(StartAnsicht.frame, "Reservierungsliste nicht gefunden, bitte Support kontaktieren",
                    "DATEI FEHLT", JOptionPane.ERROR_MESSAGE);

        }
    }
}
