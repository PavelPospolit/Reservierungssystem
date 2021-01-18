package com.trainee.rs.actions;/*Creates a random number for 2 cases: employee (com.trainee.rs.Classes.Mitarbeiter) and booking (Reservierung)*/

import com.trainee.rs.ressources.DatenErzeugnung;

public class Random_Number_Generator {
    public int MaRandomNumber(){
        int iRand;
        do {
            iRand = (int) (Math.random() * 99999999) + 10000000;
        } while (DatenErzeugnung.getHmapMitarbeiter().containsKey(("MA"+iRand)));
        return iRand;
    }
    public  int ResRandomNumber(){
        int iRand;
        do {
            iRand = (int) (Math.random() * 99999999) + 10000000;
        } while (DatenErzeugnung.getHmapMitarbeiter().containsKey(("BU"+iRand)));
        return iRand;
    }
}
