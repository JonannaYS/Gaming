package joonaksenKokeilu;

import java.util.ArrayList;
import java.util.List;

public class Reppu {
    private int maksimipaino;
    private List<Esine> sisalto;

    public Reppu(int maksimipaino){
        this.maksimipaino = maksimipaino;
        this.sisalto = new ArrayList<>();
    }

    public int getMaksimipaino() {
        return maksimipaino;
    }

    public int getPaino() {
        int paino = 0;
        for (Esine esine: sisalto) {
            paino += esine.getPaino();
        }

        return paino;
    }

    public List<Esine> getSisalto() {
        return sisalto;
    }

    public boolean lisaaEsine(Esine esine) {
        if (this.getPaino()+esine.getPaino()<=this.maksimipaino) {
            sisalto.add(esine);
            return true;
        }
        else {
            return false;
        }
    }

    public int koko(){
        return sisalto.size();
    }

    @Override
    public String toString() {
        if (this.koko() == 0) {
            return "Reppu on toistaiseksi tyhjä. Kokeile laittaa sinne jokin löytämäsi esine!";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Repun sisältö (esineitä ").append(this.koko()).append(" kpl):");

        for (Esine esine: sisalto) {
            sb.append("\n").append(esine.getNimi());
        }

        return sb.toString();
    }
}
