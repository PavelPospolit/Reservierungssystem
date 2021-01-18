import com.trainee.rs.Ansicht.StartAnsicht;
import com.trainee.rs.actions.Zeit_Vergleich;
import com.trainee.rs.ressources.DatenErzeugnung;

import java.io.IOException;

/*read in Data (leseAlle() function)
* create com.trainee.rs.Ansicht.StartAnsicht GUI
* create a Time Check Onject with constructor
* start time check thread (checks time and if given time is higher than time until a room was booked: return room automatically*/

public class RaumReservierung {
    public static void main(String[] args) throws IOException {
        DatenErzeugnung.leseAlle();
        StartAnsicht.createAndShowGui();
        Zeit_Vergleich z = new Zeit_Vergleich();
        z.run();
    }
}
