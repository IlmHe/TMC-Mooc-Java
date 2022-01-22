/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikot;

/**
 *
 * @author Peekatchu
 */
import java.util.*;

public class MaksimipainollinenLaatikko extends Laatikko {
    private int maksimipaino;
    private List<Tavara> lista;
    
    public MaksimipainollinenLaatikko(int maksimipaino) {
        this.maksimipaino = maksimipaino;
        this.lista = new ArrayList();
    }

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
        if (lista.contains(tavara)) {
            return true;
        }
        return false;
    }
    
    @Override
    public void lisaa(Tavara tavara) {
        int yhteispaino = lista.stream().mapToInt(t -> t.getPaino()).sum();
        if (yhteispaino + tavara.getPaino() <= maksimipaino) {
            lista.add(tavara);
        }
    }
    
}
