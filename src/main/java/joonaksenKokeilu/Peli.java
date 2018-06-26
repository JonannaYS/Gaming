package joonaksenKokeilu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Peli {
    private Scanner lukija;

    public Peli(Scanner lukija){
        this.lukija = lukija;
    }

    public void kaynnista() {
        //luodaan huoneet
        Huone nykyinenHuone;
        Huone eteinen = new Huone("Eteinen", "Olet eteisessä. Eteisestä on pääsy rappukäytävään, olohuoneeseen ja kylpyhuoneeseen. Tosin rappukäytävän ovi saattaa olla lukittu...");
        Huone olohuone = new Huone("Olohuone", "Olet olohuoneessa. Olohuoneesta on pääsy eteiseen, makuuhuoneeseen ja parvekkeelle.");
        Huone makuuhuone = new Huone("Makuuhuone","Olet makuuhuoneessa. Makuuhuoneesta ei pääse muualle kuin takaisin olohuoneeseen.");
        Huone kylpyhuone = new Huone("Kylpyhuone", "Olet kylpyhuoneessa. Kylpyhuoneessa on ovi eteiseen ja lasiovi saunaan.");
        Huone sauna = new Huone ("Sauna", "Olet saunassa. Huh, miten kuuma! Taitaa olla parempi mennä takaisin kylpyhuoneeseen.");
        Huone parveke = new Huone ("Parveke","Olet parvekkeella. Täältä on kyllä komeat maisemat! Parvekkeelta on vain yksi ovi, joka johtaa olohuoneeseen.");
        Huone rappu = new Huone("Rappukäytävä", "Rappukäytävä",true);

        //lisätään uloskäynnit
        eteinen.lisaaUloskaynti(olohuone);
        eteinen.lisaaUloskaynti(kylpyhuone);
        eteinen.lisaaUloskaynti(rappu);

        olohuone.lisaaUloskaynti(eteinen);
        olohuone.lisaaUloskaynti(makuuhuone);
        olohuone.lisaaUloskaynti(parveke);

        makuuhuone.lisaaUloskaynti(olohuone);

        kylpyhuone.lisaaUloskaynti(eteinen);
        kylpyhuone.lisaaUloskaynti(sauna);

        sauna.lisaaUloskaynti(kylpyhuone);

        parveke.lisaaUloskaynti(olohuone);

        //luodaan esineet
        Esine kengat = new Esine("Kengät", "Vanhat likaiset kengät.", 1);
        Esine tietokone = new Esine("Tietokone", "Vuoden 2012 Mac mini -tietokone. Vähän rikkinäinen.",2);
        Esine kasipaino = new Esine("Käsipaino", "Painava käsipaino.", 20);
        Esine takki = new Esine("Takki", "Nahkatakki",3);
        Esine avain = new Esine("Avain", "Tällä voisi ehkä avata jonkun lukon...",0);
        Esine moukari = new Esine("Moukari","Iso ja painava moukari. Ehkä tällä voisi rikkoa ulko-oven?",60);

        //lisätään esineitä huoneisiin
        eteinen.lisaaEsine(kengat);
        eteinen.lisaaEsine(takki);

        olohuone.lisaaEsine(tietokone);
        olohuone.lisaaEsine(kasipaino);

        sauna.lisaaEsine(avain);

        //luodaan reppuolio
        Reppu reppu = new Reppu(25);

        //asetetaan pelin aloituspaikka
        nykyinenHuone = parveke;

        //varsinainen luuppi, jonka sisällä peli pyörii
        while (true) {
            if (nykyinenHuone == rappu) {
                System.out.println("Onneksi olkoon! Pääsit ulos!");
                break;
            }

            System.out.println("===========================================================================================");
            System.out.println("### " + nykyinenHuone.getKuvaus() + " ###");
            System.out.println("\nMitä haluaisit tehdä?");

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
            System.out.println("============================================================================================");

            try {
                System.out.print("Komento: ");
                int komento = Integer.parseInt(lukija.nextLine());

                //ohjelman lopetus
                if (komento == 999) {
                    System.out.println("Kiitos ja näkemiin! Toivottavasti ensi kerralla jaksat pelata loppuun asti.");
                    break;
                }

                // repun sisällön tulostaminen
                else if (komento == 100) {
                    System.out.println(reppu);
                }

                // siirrytään toiseen huoneeseen, jos se ei ole lukittu
                else if (komento <= nykyinenHuone.uloskayntienMaara()){
                    Huone seuraavaHuone = nykyinenHuone.getUloskaynnit().get(komento-1);

                    if (reppu.getSisalto().contains(avain)) {
                        seuraavaHuone.avaaLukitus();
                    }

                    if (seuraavaHuone.onLukittu()) {
                        System.out.println(seuraavaHuone.getNimi() + " on lukittu. Löytyisikö jostain jokin esine, millä lukituksen voisi avata?");
                    }

                    else {
                        nykyinenHuone = seuraavaHuone;
                        System.out.println("Siirryit huoneeseen " + nykyinenHuone.getNimi() + ".");
                    }
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
