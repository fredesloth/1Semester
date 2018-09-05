package application.service;

import java.util.ArrayList;

import application.model.Bil;
import application.model.Bilgruppe;
import application.model.Firma;
import storage.Storage;

public class Service {

    public static Bil createBil(String bilmærke, Bilgruppe bilgruppe, int KMkørt, int antalPladser, int pris) {
        Bil bil = new Bil(bilmærke, bilgruppe, KMkørt, antalPladser, pris);
        Storage.addBil(bil);
        return bil;

    }

    public static void removeBil(Bil bil) {
        Storage.removeBil(bil);
    }

    public static void updateBil(Bil bil, String bilmærke, Bilgruppe bilgruppe, int KMkørt, int antalPladser) {
        bil.setAntalPladser(antalPladser);
        bil.setBilgruppe(bilgruppe);
        bil.setBilmærke(bilmærke);
        bil.setKMkørt(KMkørt);
    }

    public static ArrayList<Bil> getBiler() {
        return Storage.getBiler();
    }

    public static int getPris(Bil bil) {
        return bil.getPris();
    }

}
