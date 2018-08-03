package sk.stevo.CiernyPeter.rozhrania;

import sk.stevo.CiernyPeter.Hra;
import sk.stevo.CiernyPeter.Hrac;

public interface IOvladanieHry {

    int vyberPocetHracov();

    Hrac getMenoHraca(int i);

    int zoberKartu(Hrac hrac1, Hrac hrac2);

    void vypisKtoPrehral(Hra hra);
}
