/*Create a Räume Constructor*/

public class Räume {
    private final String sBezeichnung;
    private final int iKapazität;
    private boolean bVerfügbarkeit;
    private String sEigenschaften;
    private final String sRaumNr;

    public String getRaumNr() {
        return sRaumNr;
    }
    public boolean getVerfügbarkeit() {
        return bVerfügbarkeit;
    }
    public int getKapazität() {
        return iKapazität;
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
    public void setVerfügbarkeit(boolean verfügbarkeit) {
        bVerfügbarkeit = verfügbarkeit;
    }

    public Räume(String bezeichnung, String raumnummer, String eigenschaften, int kapazität, boolean verfügbarkeit) {
        sBezeichnung = bezeichnung;
        sEigenschaften = eigenschaften;
        iKapazität = kapazität;
        sRaumNr = raumnummer;
        bVerfügbarkeit = verfügbarkeit;

    }
}
