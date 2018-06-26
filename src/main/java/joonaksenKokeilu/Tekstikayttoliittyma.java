package joonaksenKokeilu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Tekstikayttoliittyma {
    private Scanner lukija;

    public Tekstikayttoliittyma(Scanner lukija){
        this.lukija = lukija;
    }

    public void kaynnista() {
        Huone nykyinen;

        Huone eteinen = new Huone("Eteinen", "Olet eteisessä.");
        Huone olohuone = new Huone("Olohuone", "Olet olohuoneessa.");
        Huone makuuhuone = new Huone("Makuuhuone","Olet makuuhuoneessa.");

        eteinen.lisaaUloskaynti(olohuone);
        olohuone.lisaaUloskaynti(eteinen);
        olohuone.lisaaUloskaynti(makuuhuone);
        makuuhuone.lisaaUloskaynti(olohuone);

//        Map<String, Huone> huoneet = new HashMap<>();
//        huoneet.put("eteinen", eteinen);
//        huoneet.put("olohuone", olohuone);
//        huoneet.put("makuuhuone", makuuhuone);



        nykyinen = olohuone;

        while (true) {
            System.out.println(nykyinen.getKuvaus());
            System.out.println("Mitä haluaisit tehdä?");

            //tulostetaan uloskäynnit
            for (int i = 0; i<nykyinen.getUloskaynnit().size(); i++){
                System.out.println(">"+ (i+1) + " - siirry huoneeseen " + nykyinen.getUloskaynnit().get(i).getNimi());
            }

            //tulostetaan mukaan otettavat esineet

            //annetaan mahdollisuus lopettaa
            System.out.println(">999 - lopeta peli");

            try {
                int komento = Integer.parseInt(lukija.nextLine());
                if (komento == 999) break;
                nykyinen = nykyinen.getUloskaynnit().get(komento-1);
            }

            catch (Exception e) {
                System.out.println("Virhe!");
            }
        }
    }
}
