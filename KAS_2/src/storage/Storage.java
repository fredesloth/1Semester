package storage;

import java.util.ArrayList;
import application.model.Hotel;
import application.model.Konference;
import application.model.Ledsager;
//import application.model.Ledsager;
import application.model.Deltager;
import application.model.Tilmelding;
import application.model.Udflugt;

public class Storage {
    private static ArrayList<Hotel> hoteller = new ArrayList<>();
    private static ArrayList<Konference> konferencer = new ArrayList<>();
    private static ArrayList<Deltager> deltagere = new ArrayList<>();
    private static ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private static ArrayList<Udflugt> udflugter = new ArrayList<>();
    // private static ArrayList<Ledsager> ledsagere = new ArrayList<>();

    // ---------------------------------------------------------------------------

    public static ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    public static void addHotel(Hotel hotel) {
        hoteller.add(hotel);
    }

    public static void removeHotel(Hotel hotel) {
        hoteller.remove(hotel);

    }

    // ---------------------------------------------------------------------------

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    public static void addKonference(Konference konference) {
        konferencer.add(konference);
    }

    public static void removeKonference(Konference konference) {
        konferencer.remove(konference);
    }

    // ---------------------------------------------------------------------------

    public static ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    public static void addDeltager(Deltager deltager) {
        deltagere.add(deltager);
    }

    public static void removeDeltager(Deltager deltager) {
        deltagere.remove(deltager);
    }

    // ---------------------------------------------------------------------------

    public static ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public static void addTilmelding(Tilmelding tilmelding) {
        tilmeldinger.add(tilmelding);
    }

    public static void removeTilmelding(Tilmelding tilmelding) {
        tilmeldinger.remove(tilmelding);
    }

    // ---------------------------------------------------------------------------

    // public static ArrayList<Ledsager> getLedsager() {
    // return new ArrayList<>(ledsagere);
    // }
    //
    // public static void addTilmelding(Ledsager ledsager) {
    // ledsagere.add(ledsager);
    // }
    //
    // public static void removeTilmelding(Ledsager ledsager) {
    // ledsagere.remove(ledsager);
    // }

    public static ArrayList<Udflugt> getUdflugter(Konference konference) {
        return konference.getUdflugter();
    }

    public static ArrayList<Ledsager> getLedsagere(Udflugt udflugt) {
        return udflugt.getLedsagere();
    }
}
