import java.io.IOException;

/*read in Data (leseAlle() function)
* create Start GUI
* create a Time Check Onject with constructor
* start time check thread (checks time and if given time is higher than time until a room was booked: return room automatically*/

public class RaumReservierung {
    public static void main(String[] args) throws IOException {
        DatenErzeugnung.leseAlle();
        Start.createAndShowGui();
        Zeit_Vergleich z = new Zeit_Vergleich();
        z.run();
    }
}
