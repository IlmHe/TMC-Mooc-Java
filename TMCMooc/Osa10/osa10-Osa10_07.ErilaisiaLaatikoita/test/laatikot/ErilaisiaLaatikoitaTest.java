package laatikot;

import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import org.junit.*;
import static org.junit.Assert.*;

public class ErilaisiaLaatikoitaTest {

    Class maksimipainollinenLaatikko;
    Class yhdenTavaranLaatikko;
    Class hukkaavaLaatikko;

    @Before
    public void setUp() {
        try {
            maksimipainollinenLaatikko = ReflectionUtils.findClass("laatikot.MaksimipainollinenLaatikko");
            yhdenTavaranLaatikko = ReflectionUtils.findClass("laatikot.YhdenTavaranLaatikko");
            hukkaavaLaatikko = ReflectionUtils.findClass("laatikot.HukkaavaLaatikko");
        } catch (Throwable t) {
        }
    }

    @Test
    @Points("10-07.1")
    public void tavaranKonstruktoriHeittaaPoikkeuksenKunNegatiivinenPaino() {
        try {
            Tavara tavara = new Tavara("Hesse", -1);
        } catch (IllegalArgumentException t) {
            return;
        }

        Assert.fail("Heitäthän Tavara-luokan konstruktorissa poikkeuksen IllegalArgumentException jos paino on negativiinen?\n"
                + "Testaa koodi new Tavara(\"höyhen\",-1);");
    }

    @Test
    @Points("10-07.1")
    public void tavaranKonstruktoriEiHeitaPoikkeustaJosPainoOk() {
        try {
            Tavara tavara = new Tavara("Hesse", 0);
        } catch (Throwable t) {
            Assert.fail("Ethän heitä poikkeusta jos tavaran paino on 0?\n"
                    + "Testaa koodi new Tavara(\"höyhen\",0);");
        }
    }

    @Test
    @Points("10-07.1")
    public void equalsMetodiToteutettu() {
        Tavara tavara = new Tavara("Hesse", 5);
        Assert.assertEquals("Toteutithan Tavara-luokalle equals-metodin siten, että tarkistat että verrattavien tavaroiden nimet ovat samat mutta painolla ei ole väliä?\n"
                + "Testaa koodi\n"
                + "Tavata eka = new Tavara(\"Kivi\", 5);\n"
                + "eka.equals( new Tavara(\"Kivi\", 1) );\n", true, tavara.equals(new Tavara("Hesse")));
        Assert.assertEquals("Toteutithan Tavara-luokalle equals-metodin siten, että tarkistat että verrattavien tavaroiden nimet ovat samat mutta painolla ei ole väliä?\n"
                + "Testaa koodi\n"
                + "Tavata eka = new Tavara(\"Kivi\", 5);\n"
                + "eka.equals( new Tavara(\"Kirja\", 1) );\n", false, tavara.equals(new Tavara("Siddhartha")));
    }

    @Test
    @Points("10-07.1")
    public void hashCodeMetodiToteutettu() {
        Tavara tavara = new Tavara("Hesse", 5);
        Assert.assertEquals("Toteutithan Tavara-luokalle hashCode-metodin siten, että lasket hajautusarvon tavaran nimelle mutta et välitä painosta?\n"
                + "Testaa koodi\n"
                + "Tavata eka = new Tavara(\"Kivi\", 5);\n"
                + "Tavara toka = new Tavara(\"Kivi\", 1) );\n"
                + "eka.hashCode() == toka.hashCode();\n", true, tavara.hashCode() == new Tavara("Hesse").hashCode());
        Assert.assertEquals("Toteutithan Tavara-luokalle hashCode-metodin siten, että lasket hajautusarvon tavaran nimelle mutta et välitä painosta?\n"
                + "Testaa koodi\n"
                + "Tavata eka = new Tavara(\"Kivi\", 5);\n"
                + "Tavara toka = new Tavara(\"Kirja\", 1) );\n"
                + "eka.hashCode() == toka.hashCode();\n", false, tavara.hashCode() == new Tavara("Siddhartha").hashCode());
    }

    /*
     *
     */
    @Test
    @Points("10-07.2")
    public void tilavuudellinenLaatikko() throws Throwable {
        Assert.assertNotNull("Olethan toteuttanut luokan MaksimipainollinenLaatikko pakkaukseen laatikot?", maksimipainollinenLaatikko);
        tarkistaPerinta(maksimipainollinenLaatikko);

        saniteettitarkastus("laatikot.MaksimipainollinenLaatikko", 2, "maksimipainon ja "
                + "laatikot tallentavat oliomuuttujat");

        Constructor tilavuudellinenLaatikkoConstructor = null;
        try {
            tilavuudellinenLaatikkoConstructor = ReflectionUtils.requireConstructor(maksimipainollinenLaatikko, int.class);
        } catch (Throwable t) {
            Assert.fail("Onhan luokalla MaksimipainollinenLaatikko konstruktori public MaksimipainollinenLaatikko(int maksimipaino)?");
        }

        Laatikko laatikko = null;
        try {
            laatikko = (Laatikko) ReflectionUtils.invokeConstructor(tilavuudellinenLaatikkoConstructor, 5);
        } catch (Throwable ex) {
            Assert.fail("MaksimipainollinenLaatikko-luokan konstruktorikutsu epäonnistui maksimipainolla 5. Virhe: " + ex.getMessage());
        }

        String v = "\n"
                + "Laatikko laatikko = new MaksimipainollinenLaatikko(5);\n"
                + "laatikko.lisaa(new Tavara(\"a\", 1));\n";

        lisaaMPL(laatikko, new Tavara("a", 1), v);
        v += "laatikko.lisaa(new Tavara(\"b\", 2));\n";
        lisaaMPL(laatikko, new Tavara("b", 2), v);
        v += "laatikko.lisaa(new Tavara(\"c\", 2));\n";
        lisaaMPL(laatikko, new Tavara("c", 2), v);
        v += "laatikko.lisaa(new Tavara(\"d\", 1));\n";
        lisaaMPL(laatikko, new Tavara("d", 1), v);
        v += "laatikko.lisaa(new Tavara(\"f\", 0));\n";
        lisaaMPL(laatikko, new Tavara("f", 0), v);

        Assert.assertEquals("Meneehän tavara laatikkoon kun se lisätään sinne?\n"
                + "Testa koodi\n" + v
                + "laatikko.onkoLaatikossa(new Tavara(\"a\"))\n", true, onkoLaatikossa(laatikko, new Tavara("a"), v + "laatikko.onkoLaatikossa(new Tavara(\"a\"));\n "));
        Assert.assertEquals("Meneehän tavara laatikkoon kun se lisätään sinne?\n"
                + "Testa koodi\n" + v
                + "laatikko.onkoLaatikossa(new Tavara(\"b\"))\n", true, onkoLaatikossa(laatikko, new Tavara("b"), v + "laatikko.onkoLaatikossa(new Tavara(\"b\"));\n "));
        Assert.assertEquals("Mahtuuhan tavara laatikkoon silloin kun tavaran ja laatikon tavaroiden painojen yhteissumma on tasan laatikon maksimipaino?"
                + "\nTesta koodi\n" + v
                + "laatikko.onkoLaatikossa(new Tavara(\"c\"))\n", true, onkoLaatikossa(laatikko, new Tavara("c"), v + "laatikko.onkoLaatikossa(new Tavara(\"c\"));\n "));
        Assert.assertEquals("Tarkista ettei laatikkoon voi lisätä tavaroita jos laatikon maksimipaino ylittyisi!\n"
                + "\nTesta koodi\n" + v
                + "laatikko.onkoLaatikossa(new Tavara(\"d\"))\n", false, onkoLaatikossa(laatikko, new Tavara("d"), v + "laatikko.onkoLaatikossa(new Tavara(\"d\"));\n "));
        Assert.assertEquals("Vaikka laatikko on täynnä, sinne tulee pystyä lisäämään tavaroita joiden paino on 0.\n"
                + "\nTesta koodi\n" + v
                + "laatikko.onkoLaatikossa(new Tavara(\"f\"))\n", true, onkoLaatikossa(laatikko, new Tavara("f"), v + "laatikko.onkoLaatikossa(new Tavara(\"f\"));\n "));
        Assert.assertEquals("Eikai ylimääräisiä?\n"
                + "Testa koodi\n" + v
                + "laatikko.onkoLaatikossa(new Tavara(\"kivi\"))\n", false, onkoLaatikossa(laatikko, new Tavara("kivi"), v + "laatikko.onkoLaatikossa(new Tavara(\"kivi\"));\n "));
    }

    private void lisaaMPL(Object olio, Tavara t, String v) throws Throwable {
        String klassName = "laatikot.MaksimipainollinenLaatikko";
        Reflex.ClassRef<Object> classRef;
        classRef = Reflex.reflect(klassName);

        classRef.method(olio, "lisaa").returningVoid()
                .taking(Tavara.class).withNiceError(v).invoke(t);
    }

    private void lisaaYTL(Object olio, Tavara t, String v) throws Throwable {
        String klassName = "laatikot.YhdenTavaranLaatikko";
        Reflex.ClassRef<Object> classRef;
        classRef = Reflex.reflect(klassName);

        classRef.method(olio, "lisaa").returningVoid()
                .taking(Tavara.class).withNiceError(v).invoke(t);
    }

    private void lisaaHL(Object olio, Tavara t, String v) throws Throwable {
        String klassName = "laatikot.HukkaavaLaatikko";
        Reflex.ClassRef<Object> classRef;
        classRef = Reflex.reflect(klassName);

        classRef.method(olio, "lisaa").returningVoid()
                .taking(Tavara.class).withNiceError(v).invoke(t);
    }

    private boolean onkoLaatikossa(Object olio, Tavara t, String v) throws Throwable {
        String klassName = "laatikot.MaksimipainollinenLaatikko";
        Reflex.ClassRef<Object> classRef;
        classRef = Reflex.reflect(klassName);

        return classRef.method(olio, "onkoLaatikossa").returning(boolean.class)
                .taking(Tavara.class).withNiceError(v).invoke(t);
    }

    private boolean onkoYLaatikossa(Object olio, Tavara t, String v) throws Throwable {
        String klassName = "laatikot.YhdenTavaranLaatikko";
        Reflex.ClassRef<Object> classRef;
        classRef = Reflex.reflect(klassName);

        return classRef.method(olio, "onkoLaatikossa").returning(boolean.class)
                .taking(Tavara.class).withNiceError(v).invoke(t);
    }

    private boolean onkoHLaatikossa(Object olio, Tavara t, String v) throws Throwable {
        String klassName = "laatikot.HukkaavaLaatikko";
        Reflex.ClassRef<Object> classRef;
        classRef = Reflex.reflect(klassName);

        return classRef.method(olio, "onkoLaatikossa").returning(boolean.class)
                .taking(Tavara.class).withNiceError(v).invoke(t);
    }

    /*
     *
     */
    @Test
    @Points("10-07.3")
    public void yhdenTavaranLaatikko() throws Throwable {
        Assert.assertNotNull("Olethan toteuttanut luokan YhdenTavaranLaatikko pakkaukseen laatikot?", yhdenTavaranLaatikko);
        tarkistaPerinta(yhdenTavaranLaatikko);

 saniteettitarkastus("laatikot.YhdenTavaranLaatikko", 2, "ainoan laatikkoon mahtuvan tavaran muistavan oliomuuttujan");

        Constructor yhdenTavaranLaatikkoConstructor = null;
        try {
            yhdenTavaranLaatikkoConstructor = ReflectionUtils.requireConstructor(yhdenTavaranLaatikko);
        } catch (Throwable t) {
            Assert.fail("Onhan luokalla YhdenTavaranLaatikko konstruktori public YhdenTavaranLaatikko()?");
        }

        Laatikko laatikko = null;
        try {
            laatikko = (Laatikko) ReflectionUtils.invokeConstructor(yhdenTavaranLaatikkoConstructor);
        } catch (Throwable ex) {
            Assert.fail("YhdenTavaranLaatikko-luokan konstruktorikutsu epäonnistui. Virhe: " + ex.getMessage());
        }

        String v = "\nLaatikko laatikko = new YhdenTavaranLaatikko();\n"
                + "laatikko.onkoLaatikossa(new Tavara(\"a\"));";

        Assert.assertFalse("Eihän laatikossa ole mitään aluksi?\n"
                + "tarkasta koodi\n"
                + "", onkoYLaatikossa(laatikko, new Tavara("a"), v));

        v = "\n"
                + "Laatikko laatikko = new YhdenTavaranLaatikko();\n"
                + "laatikko.lisaa(new Tavara(\"a\", 1));\n";

        lisaaYTL(laatikko, new Tavara("a", 1), v);
        v += "laatikko.lisaa(new Tavara(\"b\", 2));\n";
        lisaaYTL(laatikko, new Tavara("b", 2), v);
        v += "laatikko.lisaa(new Tavara(\"c\", 2));\n";
        lisaaYTL(laatikko, new Tavara("c", 2), v);

        Assert.assertEquals("Meneehän tavara laatikkoon kun se lisätään sinne?\n"
                + "tarkasta koodi\n"
                + v + "laatikko.onkoLaatikossa(new Tavara(\"a\"));\n", true, onkoYLaatikossa(laatikko, new Tavara("a"), v + "laatikko.onkoLaatikossa(new Tavara(\"a\"));"));
        Assert.assertEquals("Kun yhden tavaran laatikossa on jo tavara, sinne ei pitäisi pystyä lisäämään muita tavaroita.\n"
                + "tarkasta koodi\n"
                + v + "laatikko.onkoLaatikossa(new Tavara(\"b\"));\n", false, onkoYLaatikossa(laatikko, new Tavara("b"), v + "laatikko.onkoLaatikossa(new Tavara(\"b\"));"));
        Assert.assertEquals("Kun yhden tavaran laatikossa on jo tavara, sinne ei pitäisi pystyä lisäämään muita tavaroita.\n"
                + "tarkasta koodi\n"
                + v + "laatikko.onkoLaatikossa(new Tavara(\"c\"));\n", false, onkoYLaatikossa(laatikko, new Tavara("c"), v + "laatikko.onkoLaatikossa(new Tavara(\"c\"));"));
    }

    @Test
    @Points("10-07.3")
    public void hukkaavaLaatikko() throws Throwable {
        Assert.assertNotNull("Olethan toteuttanut luokan HukkaavaLaatikko pakkaukseen laatikot?", hukkaavaLaatikko);
        tarkistaPerinta(hukkaavaLaatikko);

        Constructor hukkaavaLaatikkoConstructor = null;
        try {
            hukkaavaLaatikkoConstructor = ReflectionUtils.requireConstructor(hukkaavaLaatikko);
        } catch (Throwable t) {
            Assert.fail("Onhan luokalla HukkaavaLaatikko konstruktori public HukkaavaLaatikko()?");
        }

        Laatikko laatikko = null;
        try {
            laatikko = (Laatikko) ReflectionUtils.invokeConstructor(hukkaavaLaatikkoConstructor);
        } catch (Throwable ex) {
            Assert.fail("HukkaavaLaatikko-luokan konstruktorikutsu epäonnistui. Virhe: " + ex.getMessage());
        }

        String v = "\n"
                + "Laatikko laatikko = new HukkaavaLaatikko();\n"
                + "laatikko.onkoLaatikossa(new Tavara(\"a\", 1));\n";
        Assert.assertEquals("Hukkaahan hukkaava laatikko sinne lisättävät tavarat?\n"
                + "tarkasta koodi\n"
                + v, false, onkoHLaatikossa(laatikko, new Tavara("a"),v));

         v = "\n"
                + "Laatikko laatikko = new HukkaavaLaatikko();\n"
                + "laatikko.lisaa(new Tavara(\"a\", 1));\n";

        lisaaHL(laatikko, new Tavara("a", 1), v);
        v += "laatikko.lisaa(new Tavara(\"b\", 2));\n";
        lisaaHL(laatikko, new Tavara("b", 1), v);

        Assert.assertEquals("Hukkaahan hukkaava laatikko sinne lisättävät tavarat?\n"
                + "tarkasta koodi\n"
                + v + "laatikko.onkoLaatikossa(new Tavara(\"a\"));", false, onkoHLaatikossa(laatikko, new Tavara("a"), v + "laatikko.onkoLaatikossa(new Tavara(\"a\"));"));

        Assert.assertEquals("Hukkaahan hukkaava laatikko sinne lisättävät tavarat?\n"
                + "tarkasta koodi\n"
                + v + "laatikko.onkoLaatikossa(new Tavara(\"b\"));", false, onkoHLaatikossa(laatikko, new Tavara("b"), v + "laatikko.onkoLaatikossa(new Tavara(\"b\"));"));

    }

    private void tarkistaPerinta(Class clazz) {
        if (!(clazz.getSuperclass().equals(Laatikko.class))) {
            Assert.fail("Periihän luokka " + s(clazz.getName()) + " luokan Laatikko?");
        }
    }

    private void saniteettitarkastus(String klassName, int n, String m) throws SecurityException {
        Field[] kentat = ReflectionUtils.findClass(klassName).getDeclaredFields();

        for (Field field : kentat) {
            assertFalse("et tarvitse \"stattisia muuttujia\", poista luokalta " + s(klassName) + " muuttuja " + kentta(field.toString(), s(klassName)), field.toString().contains("static") && !field.toString().contains("final"));
            assertTrue("luokan kaikkien oliomuuttujien näkyvyyden tulee olla private, muuta luokalta " + s(klassName) + " löytyi: " + kentta(field.toString(), klassName), field.toString().contains("private"));
        }

        if (kentat.length > 1) {
            int var = 0;
            for (Field field : kentat) {
                if (!field.toString().contains("final")) {
                    var++;
                }
            }
            assertTrue("et tarvitse " + s(klassName) + "-luokalle kuin " + m + ", poista ylimääräiset", var <= n);
        }
    }

    private String kentta(String toString, String klassName) {
        return toString.replace(klassName + ".", "").replace("java.lang.", "").replace("java.util.", "");
    }

    private String s(String klassName) {
        return klassName.substring(klassName.lastIndexOf(".") + 1);
    }
}
