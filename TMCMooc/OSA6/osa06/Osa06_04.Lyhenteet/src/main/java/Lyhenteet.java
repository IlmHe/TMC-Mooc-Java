
import java.util.HashMap;

public class Lyhenteet {

   private HashMap<String, String> lyhenteet;

   public Lyhenteet() {
       this.lyhenteet = new HashMap<>();
   }

   public void lisaaLyhenne(String lyhenne, String selite) {
       lyhenteet.put(lyhenne, selite);
   }

   public boolean onkoLyhennetta(String lyhenne) {
       if (lyhenteet.containsKey(lyhenne)) {
           return true;
       }
       return false;
   }

   public String haeLyhenne(String lyhenne) {
   lyhenne = siistiMerkkijono(lyhenne);
       return this.lyhenteet.get(lyhenne);
   }
       public static String siistiMerkkijono(String merkkijono) {
       if (merkkijono == null) {
           return "";
       }
       merkkijono = merkkijono.toLowerCase();
       return merkkijono.trim();
   }
}
