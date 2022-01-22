package henkilot;

import java.util.List;

public class HenkiloTulostus {

    public void tulostaLaitoksenHenkilot(List<Henkilo> henkilot) {
        for (int i = 0; i < henkilot.size(); i++) {
            System.out.println(henkilot.get(i));
        }

    }
}
