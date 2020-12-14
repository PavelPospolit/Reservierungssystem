/*Create a Reservierungen Constructor*/

public class Reservierungen {
    private static String sReservierungsnummer;
    private static String smaName;
    private static String sBisWann;
    private static String sRaumNummer;

    public static String getsReservierungsnummer() {
        return sReservierungsnummer;
    }
    public static String getSmaName() {
        return smaName;
    }
    public static String getsBisWann() {
        return sBisWann;
    }
    public static String getsRaumNummer() {
        return sRaumNummer;
    }
    public static void setiReservierungsnummer(int iReservierungsnummer) {
        Reservierungen.sReservierungsnummer = sReservierungsnummer;
    }
    public static void setSmaName(String smaName) {
        Reservierungen.smaName = smaName;
    }
    public static void setsBisWann(String sBisWann) {
        Reservierungen.sBisWann = sBisWann;
    }
    public static void setsRaumNummer(String sRaumNummer) {
        Reservierungen.sRaumNummer = sRaumNummer;
    }


    public Reservierungen(String resNummer, String maName, String raumnummer, String biswann) {
        sReservierungsnummer = resNummer;
        smaName = maName;
        sBisWann = biswann;
        sRaumNummer = raumnummer;
    }
}
