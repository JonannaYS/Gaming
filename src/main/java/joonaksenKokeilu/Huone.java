package joonaksenKokeilu;

import java.util.ArrayList;
import java.util.List;

public class Huone {
    private String nimi;
    private String kuvaus;
    private List<Esine> irtaimisto;
    private List<Huone> uloskaynnit;

    public Huone(){
        this.irtaimisto = new ArrayList<>();
        this.uloskaynnit = new ArrayList<>();
    }

    public Huone(String nimi){
        this.nimi = nimi;
        this.irtaimisto = new ArrayList<>();
        this.uloskaynnit = new ArrayList<>();
    }

    public Huone(String nimi, String kuvaus) {
        this.nimi = nimi;
        this.kuvaus = kuvaus;
        this.irtaimisto = new ArrayList<>();
        this.uloskaynnit = new ArrayList<>();
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


}
