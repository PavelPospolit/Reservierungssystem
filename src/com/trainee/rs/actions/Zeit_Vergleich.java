package com.trainee.rs.actions;

import com.trainee.rs.Ansicht.StartAnsicht;
import com.trainee.rs.ressources.DatenErzeugnung;
import com.trainee.rs.ressources.Konstanten;

import javax.swing.*;
import java.text.ParseException;
import java.util.Date;

/*create a date format
 * safe today's Date and Time into date1 variable
 * safe the Date untill booking ends into date2 variable
 * compare each others
 * if date1>=date2 (ending date of the reservation has been reeched or surpassed):
 * return Room by deleting the reservation and setting availability to true
 * check next reservation
 * wait 1 second
 * repeat until true (always) */

public class Zeit_Vergleich extends Thread {
    public void run() {
        while (true) {
            String date = Konstanten.df.format(new Date());
            String[] hilfsString = DatenErzeugnung.getHmapReservierungen().keySet().toArray(new String[0]);
            for (int i = 0; i < hilfsString.length; i++) {
                Date date1 = null;
                try {
                    date1 = Konstanten.df.parse(date);
                } catch (ParseException e) {
                    System.out.println("Falsches Zeitformat");
                }
                Date date2 = null;
                try {
                    date2 = Konstanten.df.parse(DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]).getsBisWann());
                } catch (ParseException e) {
                    System.out.println("Falsches Zeitformat");
                }
                if (date1.compareTo(date2) >= 0) {
                    DatenErzeugnung.getHmapRooms().get(DatenErzeugnung.getHmapReservierungen().get(hilfsString[i]).getsRaumNummer()).setVerfuegbarkeit(true);
                    DatenErzeugnung.getHmapReservierungen().remove(hilfsString[i]);
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(StartAnsicht.frame, "Es ist ein Fehler beim Zeitvergleich " +
                                "aufgetreten, Bitte support kontaktieren! Fehlercode",
                        "Aktualisierungsfehler", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
