package sk.stevo.CiernyPeter;

/**
 * 33 kariet 32 kariet tvori pary, tak 16 párov
 *
 * 3-6 hráčov
 *
 * Vsetky karty sa rozdajú medzi hráčov. Ten čo má najviac kariet, nechá ťahať
 * hráča po svojej pravici, v našom prípade, čo bude napravo v zozname/poli.
 *
 * Automaticky na začiatku hry si hráči zložia všetky dvojice z ruky.
 *
 * Postupne si každý ťahá a skladá z ruky dvojice.
 *
 * Komu ostane posledná karta - čierny peter, ktorá nemá dvojicu, tak prehráva.
 *
 */

public class Main {

    public static void main(String[] args) {

        Hra hra = new Hra();
        hra.zacniHru();
    }
}
