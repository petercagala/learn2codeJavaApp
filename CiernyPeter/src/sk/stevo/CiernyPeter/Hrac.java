package sk.stevo.CiernyPeter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hrac {
    
    private final String meno;
    private final List<Karta> kartyVRuke;
    private Comparator<Karta> comparator = Comparator.comparingInt(Karta::getCisloKarty);

    public Hrac(String meno) {
        this.meno = meno;
        this.kartyVRuke = new ArrayList<>();
    }
    
    public String getMeno() {
        return meno;
    }
    
    public List<Karta> getKartyVRuke() {
        return kartyVRuke;
    }
    
    void odstranParyZRuky() {
        List<Karta> akeKartyOdstraniZRuky = new ArrayList<>();
        for (Karta karta : kartyVRuke) {
            try {
                for (Karta k : kartyVRuke) {
                    if (karta.getCisloParu()
                            == k.getCisloParu()
                            && karta.getCisloKarty() != k.getCisloKarty()) {
                        akeKartyOdstraniZRuky.add(karta);
                        break;
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        akeKartyOdstraniZRuky.sort(comparator);
        if (akeKartyOdstraniZRuky.size() > 0) {
            System.out.printf("Hrac %s sklada karty %n", this.meno);
        }
                for (Karta karta : akeKartyOdstraniZRuky) {
                    System.out.printf("Cislo karty je %d a cislo paru je %d%n", karta.getCisloKarty(), karta.getCisloParu());
        }
        kartyVRuke.removeAll(akeKartyOdstraniZRuky);
    }
}
