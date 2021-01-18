
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
public class Kirjasto {

   private ArrayList<Kirja> kirjat;

   public Kirjasto() {
       kirjat = new ArrayList<>();
   }

   public void lisaaKirja(Kirja uusiKirja) {
       kirjat.add(uusiKirja);
   }

   public void tulostaKirjat() {
       for (int i = 0; i < kirjat.size(); i++) {
           System.out.println(kirjat.get(i));
       }
   }

   public ArrayList<Kirja> haeKirjaNimekkeella(String nimeke) {
       ArrayList<Kirja> loydetyt = new ArrayList<>();
       for (Kirja kirja : kirjat) {
           if (kirja.nimeke().contains(nimeke)) {
               loydetyt.add(kirja);
           }
       }
       return loydetyt;
   }

   public ArrayList<Kirja> haeKirjaJulkaisijalla(String julkaisija) {
       ArrayList<Kirja> loydetyt = new ArrayList<>();
       for (Kirja kirja : kirjat) {
           if (kirja.julkaisija().contains(julkaisija)) {
               loydetyt.add(kirja);
           }
       }
       return loydetyt;
   }

   public ArrayList<Kirja> haeKirjaJulkaisuvuodella(int julkaisuvuosi) {
       ArrayList<Kirja> loydetyt = new ArrayList<>();
       for (Kirja kirja : kirjat) {
           if (kirja.julkaisuvuosi() == (julkaisuvuosi)) {
               loydetyt.add(kirja);
           }
       }
       return loydetyt;
   }

   public ArrayList<Kirja> haeKirjaStringilla(String merkkijono, String tyyppi) {
       ArrayList<Kirja> palautettavat = new ArrayList<>();
       if (tyyppi.equals("nimeke")) {
           for (int i = 0; i < kirjat.size(); i++) {
               if (StringUtils.sisaltaa(kirjat.get(i).nimeke(), merkkijono)) {
                   palautettavat.add(kirjat.get(i));
               }
           }
       }
       if (tyyppi.equals("julkaisija")) {
           for (int i = 0; i < kirjat.size(); i++) {
               if (StringUtils.sisaltaa(kirjat.get(i).nimeke(), merkkijono)) {
                   palautettavat.add(kirjat.get(i));
               }
           }
       }
       return palautettavat;
   }
}
