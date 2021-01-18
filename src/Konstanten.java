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

    static final Font Listen_Font = new Font("TeleNeo Office", Font.PLAIN, 20);
    static final Border Listen_Border = new LineBorder(new java.awt.Color(170, 20, 150));
    static final File rFile = new File("src\\Raumliste.txt");
    static final File mFile = new File("src\\Mitarbeiter.txt");
    static final File resFile = new File("src\\Reservierungen.txt");
    static SimpleDateFormat df = new SimpleDateFormat("dd.MM.yy;HH:mm");


    static BufferedReader mEinlesen;
    static {
        try {
            mEinlesen = new BufferedReader(new FileReader("src\\Mitarbeiter.txt"));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(StartAnsicht.frame, "Mitarbeiterliste nicht gefunden, bitte Support kontaktieren",
                    "DATEI FEHLT", JOptionPane.ERROR_MESSAGE);

        }
    }

    static BufferedReader rEinlesen;
    static {
        try {
            rEinlesen = new BufferedReader(new FileReader("src\\Raumliste.txt"));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(StartAnsicht.frame, "Raumliste nicht gefunden, bitte Support kontaktieren",
                    "DATEI FEHLT", JOptionPane.ERROR_MESSAGE);
        }
    }

    static BufferedReader resEinlesen;
    static {
        try {
            resEinlesen = new BufferedReader(new FileReader("src\\Reservierungen.txt"));
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(StartAnsicht.frame, "Reservierungsliste nicht gefunden, bitte Support kontaktieren",
                    "DATEI FEHLT", JOptionPane.ERROR_MESSAGE);

        }
    }
}
