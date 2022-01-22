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
public class HukkaavaLaatikko extends Laatikko {
    

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
            return false;
    }
    
    @Override
    public void lisaa(Tavara tavara) {
        
    }
}
