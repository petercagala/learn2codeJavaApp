package sk.stevo.CiernyPeter;

import sk.stevo.CiernyPeter.gui.OvladanieHry;

import java.util.ArrayList;
import java.util.List;

public final class Hra {

    private BalikKariet balikKariet;
    private final int pocetHracov;
    private final List<Hrac> hraci;
    private final OvladanieHry ovladanieHry;

    Hra() {
        this.ovladanieHry = new OvladanieHry();
        this.pocetHracov = ovladanieHry.vyberPocetHracov();
        this.hraci = vytvorHracov();
    }

    BalikKariet getBalikKariet() {
        return balikKariet;
    }

    public List<Hrac> getHraci() {
        return hraci;
    }

    OvladanieHry getOvladanieHry() {
        return ovladanieHry;
    }

    private List<Hrac> vytvorHracov() {
        List<Hrac> hraci = new ArrayList<>();
        for (int i = 0; i < pocetHracov; i++) {
            Hrac hrac = ovladanieHry.getMenoHraca(i + 1);
            hraci.add(hrac);
        }
        return hraci;
    }

    private BalikKariet vytvorBalik(List<Karta> karty) {
        return new BalikKariet(karty);
    }

    void odstranHracaZHry(Hrac hrac) {
        //ak ma prazdnu ruku odstranim ho
        if (hrac.getKartyVRuke().isEmpty()) {
            System.out.printf("Hru opusta hrac %s%n", hrac.getMeno());
            getHraci().remove(hrac);
        }
    }

    void ukonciHru() {
        ovladanieHry.vypisKtoPrehral(this);
    }

    void zacniHru() {
        HraCiernyPeter ciernyPeter = new HraCiernyPeter();
        //vseobecna logika ku kazdej hre
        balikKariet = vytvorBalik(ciernyPeter.vytvorKarty());
        balikKariet.zamiesajKarty();
        //rozdaj karty z baliku
        ciernyPeter.rozdajKarty(this);
        // pre hru urcim prveho hraca
        // v ciernom petrovi je to hrac s najviac kartami a od toho sa zacina tahat
        Hrac prvyHrac = ciernyPeter.getHracaSNajviacKartami(getHraci());
        //vseobecne na zaklade prveho hraca zistim jeho poradie v zozname hracov v hre
        int prvyHracIndex = (getHraci().indexOf(prvyHrac) + 1)% pocetHracov;
        ciernyPeter.zlozHracomParyZRuky(this);
        ciernyPeter.odstranHracovZHry(this);
        if (!ciernyPeter.jeKoniecHry(this)) {
            //idu do kruhu az kym hraju aspon dvaja hraci
            ciernyPeter.kolobehHry(this, prvyHracIndex);
        }
    }
}
