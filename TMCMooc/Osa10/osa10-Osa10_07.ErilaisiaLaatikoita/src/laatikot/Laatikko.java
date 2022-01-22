package laatikot;

import java.util.Collection;

public abstract class Laatikko {

    public abstract void lisaa(Tavara tavara);

    public void lisaa(Collection<Tavara> tavarat) {
        tavarat.stream().forEach(t -> lisaa(t));
    }

    public abstract boolean onkoLaatikossa(Tavara tavara);
}