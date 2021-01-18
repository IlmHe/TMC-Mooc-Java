
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
public class Resepti {

    private String nimi;
    private int keittoaika;
    private ArrayList<String> raakaAineet;

    public Resepti(String nimi, int keittoaika) {
        this.nimi = nimi;
        this.keittoaika = keittoaika;
        this.raakaAineet = new ArrayList<>();
    }

    public boolean keittoaikaKorkeintaan(int ylaraja) {
        return this.keittoaika <= ylaraja;
    }

    public boolean nimiSisaltaa(String haettu) {
        return this.nimi.contains(haettu);
    }

    public boolean sisaltaaRaakaAineen(String aine) {
        return this.raakaAineet.contains(aine);
    }

    public void lisaaRaakaAine(String aine) {
        this.raakaAineet.add(aine);
    }

    @Override
    public String toString() {
        return this.nimi + ", keittoaika: " + keittoaika;
    }

}
