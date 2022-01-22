/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilot;

/**
 *
 * @author Peekatchu
 */
public class Opiskelija extends Henkilo {

    private int opintoPisteet;

    public Opiskelija(String nimi, String osoite) {
        super(nimi, osoite);
    }

    public int opintopisteita() {
        return opintoPisteet;
    }

    public void opiskele() {
        opintoPisteet++;
    }

    @Override
    public String toString() {
        return haeNimi() + "\n" + "  " + haeOsoite() + "\n" + "  " + "opintopisteitä " + opintoPisteet;
    }
}
