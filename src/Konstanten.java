import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/*
 *List of constants
 *font, colors, Border, paths,...;
 */

public class Konstanten {

    static final Font Listen_Font = new Font("TeleNeo Office", Font.PLAIN, 20);
    static final Border Listen_Border = new LineBorder(new java.awt.Color(170, 20, 150));
    static final File rFile = new File("C:\\Users\\A113017330\\Desktop\\Reservierungssystem\\Raumliste.txt");
    static final File mFile = new File("C:\\Users\\A113017330\\Desktop\\Reservierungssystem\\Mitarbeiter.txt");
    static final File resFile = new File("C:\\Users\\A113017330\\Desktop\\Reservierungssystem\\Reservierungen.txt");

    static BufferedReader mEinlesen;
    static {
        try {
            mEinlesen = new BufferedReader(new FileReader("C:\\Users\\A113017330\\Desktop\\Reservierungssystem\\Mitarbeiter.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Datei nicht gefunden");

        }
    }

    static BufferedReader rEinlesen;
    static {
        try {
            rEinlesen = new BufferedReader(new FileReader("C:\\Users\\A113017330\\Desktop\\Reservierungssystem\\Raumliste.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Datei nicht gefunden");
        }
    }

    static BufferedReader resEinlesen;
    static {
        try {
            resEinlesen = new BufferedReader(new FileReader("C:\\Users\\A113017330\\Desktop\\Reservierungssystem\\Reservierungen.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Datei nicht gefunden");

        }
    }
}
