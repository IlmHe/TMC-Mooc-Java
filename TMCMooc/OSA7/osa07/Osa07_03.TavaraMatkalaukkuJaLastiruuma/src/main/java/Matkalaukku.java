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
public class Matkalaukku {

    private ArrayList<Tavara> tavarat;

    private int maksimipaino;

    public Matkalaukku(int maksimipaino) {
        this.maksimipaino = maksimipaino;
        this.tavarat = new ArrayList<>();
    }

    public void lisaaTavara(Tavara tavara) {
        if (!(this.yhteispaino() + tavara.getPaino() > this.maksimipaino)) {
            this.tavarat.add(tavara);
        }

    }

    public String tavaramaara() {
        if (this.tavarat.isEmpty()) {
            return "ei tavaroita";
        }
        if (this.tavarat.size() == 1) {
            return "1 tavara";
        }
        if (this.tavarat.size() >= 2) {
            return this.tavarat.size() + " tavaraa";
        } else {
            return "return statement";
        }
    }

    public String toString() {
        return this.tavaramaara() + " (" + this.yhteispaino() + " kg)";
    }

    public void tulostaTavarat() {
        int i = 0;
        while (i < this.tavarat.size()) {
            System.out.println(this.tavarat.get(i));
            i++;
        }
    }

    public int yhteispaino() {
        int yhtpaino = 0;
        int i = 0;
        while (i < this.tavarat.size()) {
            yhtpaino += this.tavarat.get(i).getPaino();
            i++;
        }
        return yhtpaino;
    }

    public Tavara raskainTavara() {
        int raskain = 0;
        int i = 0;
        if (this.tavarat.isEmpty()) {
            return null;
        }
        if (this.tavarat.size() == 1) {
            return this.tavarat.get(0);
        }
        while (i < this.tavarat.size()) {
            if (this.tavarat.get(i).getPaino() > this.tavarat.get(raskain).getPaino()) {
                raskain = i;
            }
            i++;
        }
        return this.tavarat.get(raskain);
    }
}
