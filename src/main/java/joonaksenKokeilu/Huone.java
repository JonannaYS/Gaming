package joonaksenKokeilu;

import java.util.ArrayList;
import java.util.List;

public class Huone {
    private String nimi;
    private String kuvaus;
    private List<Esine> irtaimisto = new ArrayList<>();
    private List<Huone> uloskaynnit = new ArrayList<>();
    private boolean lukossa = false;

    public Huone(){

    }

    public Huone(String nimi){
        this.nimi = nimi;
    }

    public Huone(String nimi, String kuvaus) {
        this.nimi = nimi;
        this.kuvaus = kuvaus;

    }

    public Huone(String nimi, String kuvaus, boolean lukossa) {
        this.nimi = nimi;
        this.kuvaus = kuvaus;
        this.lukossa = lukossa;
    }

    public String getNimi() {
        return nimi;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public List<Esine> getIrtaimisto() {
        return irtaimisto;
    }

    public List<Huone> getUloskaynnit() {
        return uloskaynnit;
    }

    public void lisaaUloskaynti(Huone uloskaynti){
        uloskaynnit.add(uloskaynti);
    }

    public void lisaaEsine(Esine esine){
        irtaimisto.add(esine);
    }

    public int esineidenMaara(){
        return irtaimisto.size();
    }

    public int uloskayntienMaara(){
        return uloskaynnit.size();
    }

    public boolean onLukittu(){
        return lukossa;
    }

    public void avaaLukitus(){
        this.lukossa = false;
    }


}
