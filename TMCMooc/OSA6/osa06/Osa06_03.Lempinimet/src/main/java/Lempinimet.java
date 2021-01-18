
import java.util.HashMap;

public class Lempinimet {

 public static void main(String[] args) {
   // Create a HashMap object called capitalCities
   HashMap<String, String> nimet = new HashMap<String, String>();

   // Add keys and values (Country, City)
   nimet.put("matti", "mage");
   nimet.put("miakel", "mixu");
   nimet.put("Norway", "Oslo");
   nimet.put("USA", "Washington DC");
     System.out.println(nimet.get("miakel"));
 }
}
