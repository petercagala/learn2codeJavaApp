package sk.stevo.CiernyPeter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class HraCiernyPeter {

    List<Karta> vytvorKarty() {
        ArrayList<Karta> karty = new ArrayList<>();
        int j = 1;
        for (int i = 0; i < 16; i++, j = j + 2) {
            karty.add(new Karta(j, i));
            karty.add(new Karta(j + 1, i));
        }
        karty.add(new Karta(33, -1)); //Čierny Peter
        return karty;
    }

    void rozdajKarty(Hra hra) {
        BalikKariet balikKariet = hra.getBalikKariet();
        List<Hrac> hraci = hra.getHraci();
        int pocetKariet = balikKariet.getKarty().size();
        for (int i = 0; i < pocetKariet; i++) {
            Hrac hrac = hraci.get(i % hraci.size());
            hrac.getKartyVRuke().add(balikKariet.getKartu());
        }
    }

    Hrac getHracaSNajviacKartami(List<Hrac> hraci) {
        int max = 0;
        Hrac hracMax = null;
        for (Hrac hrac : hraci) {
            int size = hrac.getKartyVRuke().size();
            if (max < size) {
                max = size;
                hracMax = hrac;
            }
        }
        return hracMax;
    }

    void zlozHracomParyZRuky(Hra hra) {
        for(Hrac hrac : hra.getHraci()) {
            hrac.odstranParyZRuky();
        }
    }

    void odstranHracovZHry(Hra hra) {
        //nemôžem mazať hraca z kolekcie ak cez nu prechadzam, preto si vytvorim novy zoznam a odstranim potom
        ArrayList<Hrac> hraciNaOdstranenie = new ArrayList<>();
        for(Hrac hrac : hra.getHraci()){
            //skontrolujem ci uz niekto neskoncil, teda ma prazdnu ruku
            //ak ano odstranim ho z hry
            if(hrac.getKartyVRuke().isEmpty()){
                hraciNaOdstranenie.add(hrac);
            }
        }
        for(Hrac hrac : hraciNaOdstranenie){
            hra.odstranHracaZHry(hrac);
        }
    }

    boolean jeKoniecHry(Hra hra) {
        if (hra.getHraci().size() < 2) {
            hra.ukonciHru();
            return true;
        }
        return false;
    }

    private void zoberHracoviKartu(Hrac hrac1, Hrac hrac2, Hra hra) {
        int poradieZobranejKarty = hra.getOvladanieHry().zoberKartu(hrac1, hrac2);
        Karta vzataKarta = hrac2.getKartyVRuke().get(poradieZobranejKarty);
        hrac1.getKartyVRuke().add(vzataKarta);
        hrac2.getKartyVRuke().remove(vzataKarta);
        //pomiesam karty v ruke
        Collections.shuffle(hrac1.getKartyVRuke());
        Collections.shuffle(hrac2.getKartyVRuke());
    }

    void kolobehHry(Hra hra, int prvyHracIndex) {
        while (hra.getHraci().size() > 1) {
            int pocetHracov = hra.getHraci().size();
            Hrac hrac1 = hra.getHraci().get(prvyHracIndex % pocetHracov);
            Hrac hrac2 = hra.getHraci().get((prvyHracIndex + 1) % pocetHracov);
            zoberHracoviKartu(hrac1, hrac2, hra);
            zlozHracomParyZRuky(hra);
            odstranHracovZHry(hra);
            if (jeKoniecHry(hra)) {
                break;
            }
            prvyHracIndex++;
        }
    }
}
