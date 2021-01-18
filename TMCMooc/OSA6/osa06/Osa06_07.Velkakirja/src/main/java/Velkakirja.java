
import java.util.HashMap;
public class Velkakirja {
       private HashMap<String, Double> velka;

       public Velkakirja () {
           this.velka = new HashMap<>();
       }

       public void asetaLaina(String kenelle, double maara) {
           this.velka.put(kenelle, maara * 1.0);
       }
       public double paljonkoVelkaa(String kenelle) {
           return this.velka.getOrDefault(kenelle, 0.0);
       }
     }
