package application.model;

import java.util.ArrayList;

public class Bil {

    private Bilgruppe bilgruppe;
    private String bilmærke;
    private int KMkørt;
    private int antalPladser;
    private int pris;

    private ArrayList<Bil> biler;

    public Bil(String bilmærke, Bilgruppe bilgruppe, int KMkørt, int antalPladser, int pris) {
        this.bilmærke = bilmærke;
        this.bilgruppe = bilgruppe;
        this.KMkørt = KMkørt;
        this.antalPladser = antalPladser;
        this.biler.add(this);

        if (bilgruppe == Bilgruppe.A) {
            this.pris = 2500;
        }
        if (bilgruppe == Bilgruppe.B) {
            this.pris = 1500;
        }
        if (bilgruppe == Bilgruppe.C) {
            this.pris = 1000;
        }
        if (bilgruppe == Bilgruppe.D) {
            this.pris = 500;
        }
    }

    public Bilgruppe getBilgruppe() {
        return bilgruppe;
    }

    public void setBilgruppe(Bilgruppe bilgruppe) {
        this.bilgruppe = bilgruppe;
    }

    public String getBilmærke() {
        return bilmærke;
    }

    public void setBilmærke(String bilmærke) {
        this.bilmærke = bilmærke;
    }

    public int getKMkørt() {
        return KMkørt;
    }

    public void setKMkørt(int kMkørt) {
        KMkørt = kMkørt;
    }

    public int getAntalPladser() {
        return antalPladser;
    }

    public void setAntalPladser(int antalPladser) {
        this.antalPladser = antalPladser;
    }

    public int getPris() {
        return pris;
    }

}
