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
        Huone nykyinenHuone;

        //luodaan huoneet
        Huone eteinen = new Huone("Eteinen", "Olet eteisessä.");
        Huone olohuone = new Huone("Olohuone", "Olet olohuoneessa.");
        Huone makuuhuone = new Huone("Makuuhuone","Olet makuuhuoneessa.");

        //lisätään uloskäynnit
        eteinen.lisaaUloskaynti(olohuone);
        olohuone.lisaaUloskaynti(eteinen);
        olohuone.lisaaUloskaynti(makuuhuone);
        makuuhuone.lisaaUloskaynti(olohuone);

        //luodaan esineet
        Esine kengat = new Esine("Kengät", "Vanhat likaiset kengät.", 1);
        Esine tietokone = new Esine("Tietokone", "Vuoden 2012 Mac mini -tietokone. Vähän rikkinäinen.",2);
        Esine kasipaino = new Esine("Käsipaino", "Painava käsipaino.", 20);

        //lisätään esineitä huoneisiin
        eteinen.lisaaEsine(kengat);
        olohuone.lisaaEsine(tietokone);
        olohuone.lisaaEsine(kasipaino);

        //luodaan reppuolio
        Reppu reppu = new Reppu(30);

        nykyinenHuone = eteinen;

        while (true) {
            System.out.println("========================================");
            System.out.println(nykyinenHuone.getKuvaus());
            System.out.println("Mitä haluaisit tehdä?");

            int komentoNro = 1;

            //tulostetaan uloskäynnit
            for (int i = 0; i<nykyinenHuone.getUloskaynnit().size(); i++){
                System.out.println("\t>"+ (komentoNro++) + " - siirry huoneeseen " + nykyinenHuone.getUloskaynnit().get(i).getNimi());
            }

            //tulostetaan mukaan otettavat esineet
            for (int i = 0; i<nykyinenHuone.getIrtaimisto().size(); i++){
                System.out.println("\t>"+ (komentoNro++) + " - ota huoneesta " + nykyinenHuone.getIrtaimisto().get(i).getNimi() + " ja laita reppuun.");
            }

            //tulostetaan repun sisältö
            for (int i = 0; i<reppu.getSisalto().size(); i++) {
                System.out.println("\t>"+ (komentoNro++) + " - jätä " + reppu.getSisalto().get(i).getNimi() + " huoneeseen " + nykyinenHuone.getNimi());
            }


            //staattiset komennot
            System.out.println("\t>100 - näytä repun sisältö");
            System.out.println("\t>999 - lopeta peli");
            System.out.println("========================================");

            try {
                System.out.print("Komento: ");
                int komento = Integer.parseInt(lukija.nextLine());

                //ohjelman lopetus
                if (komento == 999) {
                    break;
                }

                // repun sisällön tulostaminen
                else if (komento == 100) {
                    System.out.println(reppu);
                }

                // siirrytään toiseen huoneeseen
                else if (komento <= nykyinenHuone.uloskayntienMaara()){
                    nykyinenHuone = nykyinenHuone.getUloskaynnit().get(komento-1);
                    System.out.println("Siirryit huoneeseen " + nykyinenHuone.getNimi());
                }

                // otetaan esine huoneesta ja laitetaan se reppuun
                else if (komento <= nykyinenHuone.uloskayntienMaara()+nykyinenHuone.esineidenMaara()) {
                    int indeksi = komento-nykyinenHuone.uloskayntienMaara()-1;
                    Esine esine = nykyinenHuone.getIrtaimisto().get(indeksi);

                    //mahtuuko esine reppuun?
                    if (reppu.lisaaEsine(esine)) {
                        System.out.println("Laitoit esineen " + esine.getNimi() + " (" + esine.getPaino() + " kg) reppuun. Repun paino on nyt " + reppu.getPaino() + "/" + reppu.getMaksimipaino() + " kg");
                        nykyinenHuone.getIrtaimisto().remove(indeksi);
                    }
                    else {
                        System.out.println(esine.getNimi() + " ei mahtunut reppuun! Repusta olisi tullut liian painava.");
                    }
                }

                // otetaan esine repusta pois ja jätetään se huoneeseen
                else if (komento <= komentoNro) {
                    int indeksi = komento-nykyinenHuone.esineidenMaara()-nykyinenHuone.uloskayntienMaara()-1;
                    Esine esine = reppu.getSisalto().get(indeksi);
                    nykyinenHuone.lisaaEsine(reppu.getSisalto().get(indeksi));
                    reppu.getSisalto().remove(indeksi);
                    System.out.println("Jätit esineen " + esine.getNimi() + " huoneeseen " + nykyinenHuone.getNimi());
                }

                else {
                    System.out.println("Tuntematon komento, yritetäänpäs uudestaan...");
                }
            }

            catch (Exception e) {
                System.out.println("Virhe!");
            }
        }
    }
}
