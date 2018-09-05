package storage;

import java.util.ArrayList;

import application.model.Bil;

public class Storage {

    private static ArrayList<Bil> biler = new ArrayList<>();

    // -------------------------------------------------------------------------------------

    public static void addBil(Bil bil) {
        biler.add(bil);
    }

    public static ArrayList<Bil> getBiler() {
        return new ArrayList<>(biler);

    }

    public static void removeBil(Bil bil) {
        biler.remove(bil);
    }

}
