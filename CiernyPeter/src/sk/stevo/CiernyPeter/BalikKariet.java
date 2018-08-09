package sk.stevo.CiernyPeter;

import java.util.Collections;
import java.util.List;

class BalikKariet {

    private final List<Karta> karty; //implementacia listu pre zachovanie poradia

    BalikKariet(List<Karta> karty) {
        this.karty = karty;
    }

    List<Karta> getKarty() {
        return karty;
    }

    void zamiesajKarty() {
        if (jeBalikPrazdny()) {
            Collections.shuffle(karty);
        }
    }

    private boolean jeBalikPrazdny() {
        return karty != null && !karty.isEmpty();
    }

    Karta getKartu() {
        Karta karta = null;
        if (jeBalikPrazdny()) {
            karta = karty.get(0); //vytiahnem prvú kartu
            karty.remove(karta); //kartu odstránim z balíku
        }
        return karta;
    }
}
