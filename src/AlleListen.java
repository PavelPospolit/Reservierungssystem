import javax.swing.*;
import java.awt.*;

/*Checks if Hashmaps are empty123
 * if not empty: creates Labels and Textareas
 * Names Labels (e.g.: Mitarbeiter, Räume, Reservierungen)
 * puts Data from HashMap into associating Texarea (e.g:: Employee Names into Textarea with the first line "Name:\n"*/

public class AlleListen {
    static final boolean shouldFIll = true;
    static final boolean RIGHT_TO_LEFT = false;
    static JTextArea Mitarbeitername;
    static JTextArea Mitarbeiternummer;
    static JTextArea Raumbezeichnung;
    static JTextArea RaumNummer;
    static JTextArea RaumEigenschaften;
    static JTextArea RaumKapazität;
    static JTextArea RaumVerfügbarkeit;
    static JTextArea ReservierungNameMA;
    static JTextArea ReservierungRaumNummer;
    static JTextArea ReservierungEndDatum;
    static JLabel lMitarbeiter;
    static JLabel lRäume;
    static JLabel lReservierungen;
    static JFrame frame;

    public static void addComponentsToPane(Container pane) {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFIll) {
            c.fill = GridBagConstraints.HORIZONTAL;
        }
        if (DatenErzeugnung.getHmapMitarbeiter().size() != 0) {
            Mitarbeitername = new JTextArea("Name:\n");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 1;
            c.weightx = 5;
            c.gridwidth = 1;
            Mitarbeitername.setBorder(Konstanten.Listen_Border);
            Mitarbeitername.setBackground(Color.black);
            Mitarbeitername.setFont(Konstanten.Listen_Font);
            Mitarbeitername.setForeground(Color.white);
            pane.add(Mitarbeitername, c);
            
            Mitarbeiternummer = new JTextArea("Mitarbeiternummer:\n");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 1;
            c.gridy = 1;
            c.weightx = 5;
            c.gridwidth = 1;
            Mitarbeiternummer.setBorder(Konstanten.Listen_Border);
            Mitarbeiternummer.setBackground(Color.black);
            Mitarbeiternummer.setFont(Konstanten.Listen_Font);
            Mitarbeiternummer.setForeground(Color.white);
            pane.add(Mitarbeiternummer, c);

            String[] hilfsString = DatenErzeugnung.getHmapMitarbeiter().keySet().toArray(new String[0]);
            for (int i = 0; i < hilfsString.length; i++) {
                Mitarbeiternummer.setText(Mitarbeiternummer.getText() + hilfsString[i] + "\n");
                Mitarbeitername.setText(Mitarbeitername.getText() + DatenErzeugnung.getHmapMitarbeiter().get(hilfsString[i]).getsMaName() + "\n");
            }

            lMitarbeiter = new JLabel("MITARBEITER:  ");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 0;
            c.weightx = 1;
            c.gridwidth = 1;
            lMitarbeiter.setBorder(Konstanten.Listen_Border);
            lMitarbeiter.setFont(Konstanten.Listen_Font);
            lMitarbeiter.setForeground(Color.white);
            lMitarbeiter.setHorizontalAlignment(JLabel.LEFT);
            pane.add(lMitarbeiter, c);
        }
        if (DatenErzeugnung.getHmapRooms().size() != 0) {
            Raumbezeichnung = new JTextArea("Bezeichnung:\n");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 7;
            c.weightx = 5;
            c.gridwidth = 1;
            Raumbezeichnung.setBorder(Konstanten.Listen_Border);
            Raumbezeichnung.setBackground(Color.black);
            Raumbezeichnung.setFont(Konstanten.Listen_Font);
            Raumbezeichnung.setForeground(Color.white);
            pane.add(Raumbezeichnung, c);

            RaumNummer = new JTextArea("Nummer:\n");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 1;
            c.gridy = 7;
            c.weightx = 5;
            c.gridwidth = 1;
            RaumNummer.setBorder(Konstanten.Listen_Border);
            RaumNummer.setBackground(Color.black);
            RaumNummer.setFont(Konstanten.Listen_Font);
            RaumNummer.setForeground(Color.white);
            pane.add(RaumNummer, c);

            RaumEigenschaften = new JTextArea("Eigenschaften:\n");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 2;
            c.gridy = 7;
            c.weightx = 5;
            c.gridwidth = 1;
            RaumEigenschaften.setBorder(Konstanten.Listen_Border);
            RaumEigenschaften.setBackground(Color.black);
            RaumEigenschaften.setFont(Konstanten.Listen_Font);
            RaumEigenschaften.setForeground(Color.white);
            pane.add(RaumEigenschaften, c);

            RaumKapazität = new JTextArea("Kapazität:\n");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 3;
            c.gridy = 7;
            c.weightx = 5;
            c.gridwidth = 1;
            RaumKapazität.setBorder(Konstanten.Listen_Border);
            RaumKapazität.setBackground(Color.black);
            RaumKapazität.setFont(Konstanten.Listen_Font);
            RaumKapazität.setForeground(Color.white);
            pane.add(RaumKapazität, c);

            RaumVerfügbarkeit = new JTextArea("Verfügbarkeit:\n");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 4;
            c.gridy = 7;
            c.weightx = 5;
            c.gridwidth = 1;
            RaumVerfügbarkeit.setBorder(Konstanten.Listen_Border);
            RaumVerfügbarkeit.setBackground(Color.black);
            RaumVerfügbarkeit.setFont(Konstanten.Listen_Font);
            RaumVerfügbarkeit.setForeground(Color.white);
            pane.add(RaumVerfügbarkeit, c);

            String[] hilfsString = DatenErzeugnung.getHmapRooms().keySet().toArray(new String[0]);
            for (int i = 0; i < hilfsString.length; i++) {
                RaumNummer.setText(RaumNummer.getText() + DatenErzeugnung.getHmapRooms().get(hilfsString[i]).getRaumNr() + "\n");
                Raumbezeichnung.setText(Raumbezeichnung.getText() + DatenErzeugnung.getHmapRooms().get(hilfsString[i]).getBezeichnung() + "\n");
                RaumEigenschaften.setText(RaumEigenschaften.getText() + DatenErzeugnung.getHmapRooms().get(hilfsString[i]).getEigenschaften() + "\n");
                RaumKapazität.setText(RaumKapazität.getText() + DatenErzeugnung.getHmapRooms().get(hilfsString[i]).getKapazität() + "\n");
                RaumVerfügbarkeit.setText(RaumVerfügbarkeit.getText() + DatenErzeugnung.getHmapRooms().get(hilfsString[i]).getVerfügbarkeit() + "\n");
            }

            lRäume = new JLabel("RÄUME:  ");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 6;
            c.weightx = 1;
            c.gridwidth = 1;
            lRäume.setBorder(Konstanten.Listen_Border);
            lRäume.setFont(Konstanten.Listen_Font);
            lRäume.setForeground(Color.white);
            lRäume.setHorizontalAlignment(JLabel.LEFT);
            pane.add(lRäume, c);
        }

        if (DatenErzeugnung.getHmapReservierungen().size() != 0) {
            ReservierungNameMA = new JTextArea("Name:\n");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = 9;
            c.weightx = 5;
            c.gridwidth = 1;
            ReservierungNameMA.setBorder(Konstanten.Listen_Border);
            ReservierungNameMA.setBackground(Color.black);
            ReservierungNameMA.setFont(Konstanten.Listen_Font);
            ReservierungNameMA.setForeground(Color.white);
            pane.add(ReservierungNameMA, c);

            ReservierungRaumNummer = new JTextArea("Raumnummer:\n");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 1;
            c.gridy = 9;
            c.weightx = 5;
            c.gridwidth = 1;
            ReservierungRaumNummer.setBorder(Konstanten.Listen_Border);
            ReservierungRaumNummer.setBackground(Color.black);
            ReservierungRaumNummer.setFont(Konstanten.Listen_Font);
            ReservierungRaumNummer.setForeground(Color.white);
            pane.add(ReservierungRaumNummer, c);

            ReservierungEndDatum = new JTextArea("Bis wann reserviert:\n");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 2;
            c.gridy = 9;
            c.weightx = 5;
            c.gridwidth = 1;
            ReservierungEndDatum.setBorder(Konstanten.Listen_Border);
            ReservierungEndDatum.setBackground(Color.black);
            ReservierungEndDatum.setFont(Konstanten.Listen_Font);
            ReservierungEndDatum.setForeground(Color.white);
            pane.add(ReservierungEndDatum, c);

            String[] hilfsString = DatenErzeugnung.getHmapReservierungen().keySet().toArray(new String[0]);
            for (int i = 0; i < hilfsString.length; i++) {
                ReservierungNameMA.setText(ReservierungNameMA.getText() + DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]).getSmaName() + "\n");
                ReservierungRaumNummer.setText(ReservierungRaumNummer.getText() + DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]).getsRaumNummer() + "\n");
                ReservierungEndDatum.setText(ReservierungEndDatum.getText() + DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]).getsBisWann() + "\n");

            }

            lReservierungen = new JLabel("RESERVIERUNGEN:  ");
            c.fill = GridBagConstraints.HORIZONTAL;
            c.ipady = 50;
            c.gridx = 0;
            c.gridy = 8;
            c.weightx = 1;
            c.gridwidth = 1;
            lReservierungen.setBorder(Konstanten.Listen_Border);
            lReservierungen.setFont(Konstanten.Listen_Font);
            lReservierungen.setForeground(Color.white);
            lReservierungen.setHorizontalAlignment(JLabel.LEFT);
            pane.add(lReservierungen, c);
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