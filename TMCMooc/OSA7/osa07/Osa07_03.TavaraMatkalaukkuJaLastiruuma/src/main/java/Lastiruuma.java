
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Peekatchu
 */
public class Lastiruuma {

    private int maksimipaino;
    private ArrayList<Matkalaukku> matkalaukut;

    public Lastiruuma(int maksimipaino) {
        this.maksimipaino = maksimipaino;
        this.matkalaukut = new ArrayList<>();
    }

    public void lisaaMatkalaukku(Matkalaukku laukku) {
        if (!(this.yhteispaino() + laukku.yhteispaino() > this.maksimipaino)) {
            this.matkalaukut.add(laukku);
        }

    }

    public int yhteispaino() {
        int kokonaispaino = 0;
        int i = 0;
        while (i < this.matkalaukut.size()) {
            kokonaispaino = kokonaispaino + this.matkalaukut.get(i).yhteispaino();
            i++;
        }
        return kokonaispaino;
    }
        public String matkalaukut() {
        if (this.matkalaukut.isEmpty()) {
            return "ei matkalaukkuja";
        }
        if (this.matkalaukut.size() == 1) {
            return "1 matkalaukku";
        }
        if (this.matkalaukut.size() >= 2) {
            return this.matkalaukut.size() + " matkalaukkua";
        } else {
            return "return statement";
        }
    }
        public void tulostaTavarat() {
        int i = 0;
        while (i < this.matkalaukut.size()) {
            this.matkalaukut.get(i).tulostaTavarat();
            i++;
        }
    }

    @Override
    public String toString() {
        return this.matkalaukut() + " (" + this.yhteispaino() + " kg)";
    }
}
