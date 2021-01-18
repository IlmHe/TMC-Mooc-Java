public class Tehtava {
    private String nimi;
    private boolean tehty;

    public Tehtava () {
        this.nimi = null;
        this.tehty = false;
    }

    public Tehtava(String nimi) {
        this.nimi = nimi;
        this.tehty = false;
    }

    public String getNimi() {
        return this.nimi;
    }

    public void setTehty(boolean tehty) {
        this.tehty = tehty;
    }

    public boolean onTehty() {
        return tehty;
    }

    public void poista() {
        this.nimi = null;
    }


}
