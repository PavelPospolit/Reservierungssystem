/*Mitarbeiter Konstruktor*/

public class Mitarbeiter {
    private final String sMaName;
    private final String sMitarbeiterID;
    private final String sPasswort;

    public String getsMaName() {
        return sMaName;
    }
    public String getsMitarbeiterID() {
        return sMitarbeiterID;
    }
    public String getsPasswort() {
        return sPasswort;
    }

    public Mitarbeiter(String maName, String mitarbeiterID, String passwort) {
        sMaName = maName;
        sMitarbeiterID = mitarbeiterID;
        sPasswort = passwort;

    }
}
