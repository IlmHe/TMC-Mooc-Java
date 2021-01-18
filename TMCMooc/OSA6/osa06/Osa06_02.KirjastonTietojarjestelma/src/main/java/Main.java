
public class Main {

   public static void main(String[] args) {
Kirjasto kirjasto = new Kirjasto();

kirjasto.lisaaKirja(new Kirja("Cheese Problems Solved", "Woodhead Publishing", 2007));
kirjasto.lisaaKirja(new Kirja("The Stinky Cheese Man and Other Fairly Stupid Tales", "Penguin Group", 1992));
kirjasto.lisaaKirja(new Kirja("NHL Hockey", "Stanley Kupp", 1952));
kirjasto.lisaaKirja(new Kirja("Battle Axes", "Tom A. Hawk", 1851));

for (Kirja kirja: kirjasto.haeKirjaNimekkeella("Cheese")) {
   System.out.println(kirja);
}

System.out.println("---");

for (Kirja kirja: kirjasto.haeKirjaJulkaisijalla("Pong Group")) {
   System.out.println(kirja);
}

System.out.println("---");

for (Kirja kirja: kirjasto.haeKirjaJulkaisuvuodella(1851)) {
   System.out.println(kirja);
}
   }
}
