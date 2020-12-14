import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;

/*Creates 3 Objects Mitarbeiter (ma), Räume (room), Reservierungen (res)
 * creates 3 Hashmaps (hmapMitarbeiter, hmapRäume, hmapReservierungen)
 * puts the Data from Onjects imto Hashmaps*/

public class DatenErzeugnung {
    static String sZeile;
    static final String UTF8_BOM = "\uFEFF";
    static String[] alhilfe;
    private static HashMap<String, Mitarbeiter> hmapMitarbeiter = new HashMap<>();
    private static HashMap<String, Räume> hmapRäume = new HashMap<>();
    private static HashMap<String, Reservierungen> hmapReservierungen = new HashMap<>();

    public static HashMap<String, Mitarbeiter> getHmapMitarbeiter() {
        return hmapMitarbeiter;
    }

    public static HashMap<String, Reservierungen> getHmapReservierungen() {
        return hmapReservierungen;
    }

    public static HashMap<String, Räume> getHmapRooms() {
        return hmapRäume;
    }

    public static void setHmapMitarbeiter(HashMap<String, Mitarbeiter> hmapMitarbeiter1) {
        hmapMitarbeiter = hmapMitarbeiter1;
    }

    public static void setHmapRooms(HashMap<String, Räume> hmapRooms1) {
        hmapRäume = hmapRooms1;
    }

    public static void setHmapReservierungen(HashMap<String, Reservierungen> hmapReservierungen1) {
        hmapReservierungen = hmapReservierungen1;
    }

    public static void leseAlle() throws IOException {
        verarbeiteZeilen(Konstanten.mEinlesen);
        verarbeiteZeilen(Konstanten.rEinlesen);
        verarbeiteZeilen(Konstanten.resEinlesen);
    }

    public static void verarbeiteZeilen(BufferedReader welcher) throws IOException {
        for (int i = 0; (DatenErzeugnung.sZeile = welcher.readLine()) != null; i++) {
            if (DatenErzeugnung.sZeile.startsWith(UTF8_BOM)) {
                DatenErzeugnung.sZeile = DatenErzeugnung.sZeile.substring(1);
            }
            alhilfe = DatenErzeugnung.sZeile.split(", ");
            if (welcher == Konstanten.mEinlesen) {
                for (int j = 0; j <= alhilfe.length - 2; j += 3) {
                    Mitarbeiter ma = new Mitarbeiter(
                            alhilfe[j],
                            alhilfe[j + 1],
                            alhilfe[j + 2]);
                    hmapMitarbeiter.put(ma.getsMitarbeiterID(), ma);
                }
            }
            if (welcher == Konstanten.rEinlesen) {
                for (int j = 0; j <= alhilfe.length - 4; j += 5) {
                    Räume room = new Räume(
                            alhilfe[j],
                            alhilfe[j + 1],
                            alhilfe[j + 2],
                            Integer.parseInt(alhilfe[j + 3]),
                            Boolean.parseBoolean(alhilfe[j + 4]));
                    hmapRäume.put(room.getRaumNr(), room);
                }
            }
            if (welcher == Konstanten.resEinlesen) {
                for (int j = 0; j <= alhilfe.length - 4; j += 4) {
                    Reservierungen res = new Reservierungen(
                            alhilfe[j],
                            alhilfe[j + 1],
                            alhilfe[j + 2],
                            alhilfe[j + 3]);
                    hmapReservierungen.put(Reservierungen.getsReservierungsnummer(), res);
                }
            }
        }
    }
}
