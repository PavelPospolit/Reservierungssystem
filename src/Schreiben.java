import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*Empties existent .txt files (to avoid data being doubled)
 * gets the Keys of the Hashmaps and puts them into hilsString variable
 * writes Data from Hashmaps into .txt file*/

public class Schreiben {
    static BufferedWriter mWriter;
    static BufferedWriter rWriter;
    static BufferedWriter resWriter;
    static BufferedWriter mLeeren;
    static BufferedWriter rLeeren;
    static BufferedWriter resLeeren;

    static {
        try {
            mWriter = new BufferedWriter(new FileWriter(Konstanten.mFile, true));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("keine Rechte");
        }
    }

    static {
        try {
            rWriter = new BufferedWriter(new FileWriter(Konstanten.rFile, true));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("keine Rechte");
        }
    }

    static {
        try {
            resWriter = new BufferedWriter(new FileWriter(Konstanten.resFile, true));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("keine Rechte");
        }
    }

    public Schreiben() throws IOException {
        try {
            mLeeren = new BufferedWriter(new FileWriter(Konstanten.mFile));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("keine Rechte");
        }
        mLeeren.write("");
        mLeeren.close();
        String[] hilfsString = DatenErzeugnung.getHmapMitarbeiter().keySet().toArray(new String[0]);
        for (int i = 0; i < hilfsString.length; i++) {
            mWriter.write(
                    DatenErzeugnung.getHmapMitarbeiter().get(hilfsString[i]).getsMaName() +
                    ", " +
                    hilfsString[i] +
                    ", " +
                    DatenErzeugnung.getHmapMitarbeiter().get(hilfsString[i]).getsPasswort());
            mWriter.newLine();
        }
        mWriter.close();

        try {
            rLeeren = new BufferedWriter(new FileWriter(Konstanten.rFile));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("keine Rechte");
        }
        rLeeren.write("");
        rLeeren.close();
        hilfsString = DatenErzeugnung.getHmapRooms().keySet().toArray(new String[0]);
        for (int i = 0; i < hilfsString.length; i++) {
            rWriter.write(
                    DatenErzeugnung.getHmapRooms().get(hilfsString[i]).getBezeichnung() +
                    ", " +
                    DatenErzeugnung.getHmapRooms().get(hilfsString[i]).getRaumNr() +
                    ", " +
                    DatenErzeugnung.getHmapRooms().get(hilfsString[i]).getEigenschaften() +
                    ", " +
                    DatenErzeugnung.getHmapRooms().get(hilfsString[i]).getKapazität() +
                    ", " +
                    DatenErzeugnung.getHmapRooms().get(hilfsString[i]).getVerfügbarkeit());
            rWriter.newLine();
        }
        rWriter.close();

        try {
            resLeeren = new BufferedWriter(new FileWriter(Konstanten.resFile));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("keine Rechte");
        }
        resLeeren.write("");
        resLeeren.close();
        hilfsString = DatenErzeugnung.getHmapReservierungen().keySet().toArray(new String[0]);
        for (int i = 0; i < hilfsString.length; i++) {
            resWriter.write(
                    DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]).getsReservierungsnummer() +
                    ", " +
                    DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]).getSmaName() +
                    ", " +
                    DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]).getsRaumNummer() +
                    ", " +
                    DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]).getsBisWann());
            resWriter.newLine();
        }
        resWriter.close();
    }
}
