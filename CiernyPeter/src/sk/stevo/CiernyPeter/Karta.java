package sk.stevo.CiernyPeter;

class Karta {

    private final  int cisloKarty; //každá karta ma iné číslo
    private final int cisloParu; //každý pár má iné číslo, len dve karty majú to isté číslo páru

    Karta(int cisloKarty, int cisloParu) {
        this.cisloKarty = cisloKarty;
        this.cisloParu = cisloParu;
    }

    int getCisloKarty() {
        return cisloKarty;
    }

    int getCisloParu() {
        return cisloParu;
    }
}
