/*Create a Raeume Constructor*/

public class Raeume {
    private final String sBezeichnung;
    private final int iKapazitaet;
    private boolean bVerfuegbarkeit;
    private String sEigenschaften;
    private final String sRaumNr;

    public String getRaumNr() {
        return sRaumNr;
    }
    public boolean getVerfuegbarkeit() {
        return bVerfuegbarkeit;
    }
    public int getKapazitaet() {
        return iKapazitaet;
    }
    public String getBezeichnung() {
        return sBezeichnung;
    }
    public String getEigenschaften() {
        return sEigenschaften;
    }
    public void setEigenschaften(String eigenschaften) {
        sEigenschaften = eigenschaften;
    }
    public void setVerfuegbarkeit(boolean verfuegbarkeit) {
        bVerfuegbarkeit = verfuegbarkeit;
    }

    public Raeume(String bezeichnung, String raumnummer, String eigenschaften, int kapazitaet, boolean verfuegbarkeit) {
        sBezeichnung = bezeichnung;
        sEigenschaften = eigenschaften;
        iKapazitaet = kapazitaet;
        sRaumNr = raumnummer;
        bVerfuegbarkeit = verfuegbarkeit;

    }
}
