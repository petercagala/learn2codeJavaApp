package sk.stevo.CiernyPeter.gui;

import sk.stevo.CiernyPeter.rozhrania.IOvladanieHry;

import java.util.Scanner;

import sk.stevo.CiernyPeter.Hra;
import sk.stevo.CiernyPeter.Hrac;

public class OvladanieHry implements IOvladanieHry {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public int vyberPocetHracov() {
        int pocetHracov = 0;
        System.out.println("Zadaj počet hráčov (3 až 6):");
        try {
            pocetHracov = scanner.nextInt();
            if (pocetHracov < 3 || pocetHracov > 6) {
                System.out.println("Nepodarilo sa načítať počet hráčov. Zadal si správne číslo?");
                pocetHracov = vyberPocetHracov();
            }
        } catch (Exception ex) {
            scanner.nextLine();
            System.out.println("Nepodarilo sa načítať počet hráčov. Zadal si správne číslo?");
            pocetHracov = vyberPocetHracov();
        }
        return pocetHracov;
    }

    @Override
    public Hrac getMenoHraca(int i) {
        Hrac hrac = null;
        System.out.printf("Zadaj meno pre hráča %d :%n", i);
        String meno = scanner.next();
        scanner.nextLine();
        hrac = new Hrac(meno);
        return hrac;
    }

    @Override
    public int zoberKartu(Hrac hrac1, Hrac hrac2) {
        int zoberKartuCislo = 0;
        System.out.printf("Hrac %s,ktorú kartu cheš zobrať hračovi %s?: ", hrac1.getMeno(), hrac2.getMeno());
        for (int i = 0; i < hrac2.getKartyVRuke().size(); i++) {
            System.out.print(i);
            if (i < hrac2.getKartyVRuke().size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
        try {
            zoberKartuCislo = scanner.nextInt();
            if (zoberKartuCislo < 0 || zoberKartuCislo >= hrac2.getKartyVRuke().size()) {
                System.out.println("Nepodarilo sa získať akú kartu chceš zobrať. Zadal si správne číslo?");
                zoberKartuCislo = zoberKartu(hrac1, hrac2);
            }
        } catch (Exception ex) {
            scanner.nextLine();
            System.out.println("Nepodarilo sa získať akú kartu chceš zobrať. Zadal si správne číslo?");
            zoberKartuCislo = zoberKartu(hrac1, hrac2);
        }
        return zoberKartuCislo;
    }

    @Override
    public void vypisKtoPrehral(Hra hra) {
        System.out.printf("Čierny Peter je hráč %s%n", hra.getHraci().get(0).getMeno());
        scanner.close();
    }
}
