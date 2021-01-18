
import java.util.Scanner;

public class Nestesailiot {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        int eka = 0;
        int toka = 0;
        int poista = 0;

        while (true) {
            System.out.print("Ensimmäinen: " + eka + " /100" + "\n");
            System.out.println("Toinen: " + toka + " /100");

            String luettu = lukija.nextLine();
            String osat[] = luettu.split(" ");
            if (luettu.equals("lopeta")) {
                break;
            }
            if (osat[0].equals("lisaa")) {
                int lisattava = Integer.valueOf(osat[1]);
                if (lisattava < 0) {
                    continue;
                }
                eka += lisattava;
                if (eka > 100) {
                    eka = 100;
                }
                continue;
            }
            if (osat[0].equals("siirra")) {
                int siirrettava = Integer.valueOf(osat[1]);
                if (siirrettava < 0) {
                    continue;
                }
                if (siirrettava > eka) {
                    toka += eka;
                    eka = 0;
                    if (toka > 100) {
                        toka = 100;
                    }
                    continue;
                } else {
                    toka += siirrettava;
                    if (toka > 100) {
                        toka = 100;
                    }
                    eka -= siirrettava;
                    continue;
                }

            }
            if (osat[0].equals("poista")) {
                int poistettava = Integer.valueOf(osat[1]);
                if (poistettava < 0) {
                    continue;
                }
                if (poistettava > toka) {
                    toka += eka;
                    eka = 0;
                    continue;
                } else {
                    toka -= poistettava;
                    if (toka > 100) {
                        toka = 100;
                    }
                }
            }
        }
    }
}
