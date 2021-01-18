
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Peekatchu
 */
public class Kellari {

    private HashMap<String, ArrayList<String>> koppi;

    public Kellari() {
        koppi = new HashMap<>();
    }

    public void lisaa(String komero, String tavara) {
        koppi.putIfAbsent(komero, new ArrayList<>());
        koppi.get(komero).add(tavara);
    }

    public void poista(String komero, String tavara) {
        if (koppi.get(komero).contains(tavara)) {
            koppi.get(komero).remove(tavara);
        }
        if (koppi.get(komero).isEmpty()) {
            koppi.remove(komero);
            komerot();

        }
    }

    public ArrayList<String> sisalto(String komero) {
        ArrayList<String> palautettavalista = new ArrayList<>();
        if (koppi == null) {
            return palautettavalista;
        }
        if (koppi.get(komero) == null) {
            return palautettavalista;
        }
        return koppi.get(komero);

    }

    public ArrayList<String> komerot() {
        ArrayList<String> palautettavat = new ArrayList<>();
    for (String listattavat : koppi.keySet()) {
    palautettavat.add(listattavat);
    }
   return palautettavat;
    }

}
