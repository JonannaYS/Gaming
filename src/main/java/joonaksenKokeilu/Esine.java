package joonaksenKokeilu;

public class Esine {
    private String nimi;
    private String kuvaus;
    private int paino;

    public Esine(String nimi, String kuvaus, int paino){
        this.nimi = nimi;
        this.kuvaus = kuvaus;
        this.paino = paino;
    }

    public String getNimi() {
        return nimi;
    }

    public String getKuvaus() {
        return kuvaus;
    }

    public int getPaino() {
        return paino;
    }

    public String toString(){
        return nimi;
    }
}
