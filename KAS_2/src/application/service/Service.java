package application.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import application.model.Hotel;
import application.model.Konference;
import application.model.Deltager;
import application.model.Tilmelding;
import application.model.Ledsager;
import application.model.Udflugt;
import storage.Storage;

public class Service {

    // --------------------------------------------------------------------------------------------------------------

    // Med firma
    public static Deltager createDeltager(String navn, String adresse, String by, String land, String tlf,
            String firmaNavn, String firmaTlf) {
        Deltager deltager = new Deltager(navn, adresse, by, land, tlf, firmaNavn, firmaTlf);
        Storage.addDeltager(deltager);
        return deltager;
    }

    // Uden firma
    public static Deltager createDeltager(String navn, String adresse, String by, String land, String tlf) {
        Deltager deltager = new Deltager(navn, adresse, by, land, tlf);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public static void deleteDeltager(Deltager deltager) {
        Storage.removeDeltager(deltager);
    }

    // Med firma
    public static void updateDeltager(Deltager deltager, String navn, String adresse, String by, String land,
            String tlf, String firmaNavn, String firmaTlf) {
        deltager.setNavn(navn);
        deltager.setAdresse(adresse);
        deltager.setBy(by);
        deltager.setLand(land);
        deltager.setTlf(tlf);
        deltager.setFirmaNavn(firmaNavn);
        deltager.setFirmaTlf(firmaTlf);

    }

    // Uden firma
    public static void updateDeltager(Deltager deltager, String navn, String adresse, String by, String land,
            String tlf) {
        deltager.setNavn(navn);
        deltager.setAdresse(adresse);
        deltager.setBy(by);
        deltager.setLand(land);
        deltager.setTlf(tlf);
    }

    // --------------------------------------------------------------------------------------------------------------

    public static Hotel createHotel(String navn, double enkeltVærelsePris, double dobbeltVærelsePris, int stjerner) {
        Hotel hotel = new Hotel(navn, enkeltVærelsePris, dobbeltVærelsePris, stjerner);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static void deleteHotel(Hotel hotel) {
        Storage.removeHotel(hotel);
    }

    public static void updateHotel(Hotel hotel, String navn, double enkeltVærelsePris, double dobbeltVærelsePris,
            int stjerner) {
        hotel.setDobbeltVærelsePris(dobbeltVærelsePris);
        hotel.setEnkeltVærelsePris(enkeltVærelsePris);
        hotel.setNavn(navn);
        hotel.setStjerner(stjerner);
    }

    // --------------------------------------------------------------------------------------------------------------

    public static Konference createKonference(String navn, String beskrivelse, String adresse, LocalDate startDato,
            LocalDate slutDato, double pris) {
        Konference konference = new Konference(navn, beskrivelse, adresse, startDato, slutDato, pris);
        Storage.addKonference(konference);
        return konference;
    }

    public static void deleteKonference(Konference konference) {
        Storage.removeKonference(konference);
    }

    public static void updateKonference(Konference konference, String navn, String beskrivelse, String adresse,
            LocalDate startDato, LocalDate slutDato, double pris) {
        konference.setNavn(navn);
        konference.setBeskrivelse(beskrivelse);
        konference.setStartDato(startDato);
        konference.setSlutDato(slutDato);
        konference.setPris(pris);
    }

    public static ArrayList<Konference> getKonference() {
        return Storage.getKonferencer();
    }

    // --------------------------------------------------------------------------------------------------------------

    public static Tilmelding createTilmelding(Deltager deltager, int deltagerNr, boolean foredragsholder) {
        Tilmelding tilmelding = new Tilmelding(deltager, deltagerNr, foredragsholder);
        Storage.addTilmelding(tilmelding);
        return tilmelding;
    }

    public static void deleteTilmelding(Tilmelding tilmelding) {
        Storage.removeTilmelding(tilmelding);
    }

    public static void updateTilmelding(Tilmelding tilmelding, Deltager deltager, boolean foredragsholder,
            int deltagerNr) {
        tilmelding.setDeltager(deltager);
        tilmelding.setDeltagerNr(deltagerNr);
        tilmelding.setForedragsholder(foredragsholder);

    }

    public static void updateTilmeldingLedsager(Tilmelding tilmelding, String navn) {
        tilmelding.createLedsager(navn);
    }

    public static ArrayList<Deltager> getTilmeldinger() {
        return Storage.getDeltagere();
    }

    public static Ledsager createLedsager(Tilmelding tilmelding, String navn) {
        return tilmelding.createLedsager(navn);
    }

    public static void addLedsager(Udflugt udflugt, Ledsager ledsager) {
        udflugt.addLedsager(ledsager);

    }

    public static ArrayList<Ledsager> getLedsagere(Udflugt udflugt) {
        return Storage.getLedsagere(udflugt);

    }
    // --------------------------------------------------------------------------------------------------------------

    // lav getudflugter

    public static void addUdflugt(Konference konference, Udflugt udflugt) {
        konference.addUdflugt(udflugt);
    }

    public static ArrayList<Udflugt> getUdflugter(Konference konference) {
        return Storage.getUdflugter(konference);

    }

    public static Udflugt createUdflugt(Konference konference, double pris, String navn, String beskrivelse,
            LocalDateTime tidspunkt, boolean frokost) {
        return konference.createUdfugt(pris, navn, beskrivelse, tidspunkt, frokost);
    }

    public static String getNavn(Deltager deltager, String navn) {
        return deltager.getNavn();
    }

    // --------------------------------------------------------------------------------------------------------------
    // Auto generated igennem MainApp, her er det hvor gemmer mine forskellige
    // tilmeldinger osv. (se Lektion22_Arkitektur-Opgave1 guifx.MainApp

    public static void initStorage() {

        // Service.createDeltager("Test navn", "Test adresse", "Test by", "Test land",
        // "Test tlf");
        // Deltager d1 = Service.createDeltager("Jens", "Tordenskjoldsgade", "Aarhus",
        // "Danmark", "25465501", "SuperFirma",
        // "90109010");
        // Service.createDeltager("Søren Holm", "Urmosen 19", "Hammel", "Danmark",
        // "86963517");
        // Konference k2 = Service.createKonference("Miljø", "bekæmp miljøet",
        // "AarhusVej", LocalDate.parse("2018-05-27"),
        // LocalDate.parse("2018-05-30"), 230);
        // Konference k1 = Service.createKonference("Natur", "god natur",
        // "Tordenskjoldsgade",
        // LocalDate.parse("2018-04-15"), LocalDate.parse("2018-04-20"), 3000);
        // Service.createUdflugt(k1, 250, "Gåtur", "gåtur i skov",
        // LocalDateTime.parse("2018-04-17T15:30:00"), false);
        // Tilmelding t1 = Service.createTilmelding(d1, false, 0);
        // Ledsager l1 = Service.createLedsager(t1, "Søren");
        // Udflugt u1 = Service.createUdflugt(k1, 250, "Museum", "Se på biler",
        // LocalDateTime.parse("2018-04-17T15:30:00"),
        // false);
        // Service.addLedsager(u1, l1);
        Konference k2 = Service.createKonference("Datatmaik", "Læren om data", "Aarhus Erhvervsakademi",
                LocalDate.parse("2018-02-05"), LocalDate.parse("2018-02-08"), 250);

        Konference k1 = Service.createKonference("Filosofi", "Læren om filosofisk tænkning", "Aarhus Universitet",
                LocalDate.parse("2018-05-27"), LocalDate.parse("2018-05-30"), 500);

        Deltager d1 = Service.createDeltager("Frederik Sloth", "Urmosen 39", "Hammel", "Danmark", "25465501");

        Tilmelding t1 = Service.createTilmelding(d1, 3, false);

        Ledsager l1 = Service.createLedsager(t1, "Frank Hvam");

        Udflugt u1 = Service.createUdflugt(k1, 100, "Gå tur", "Gå tur i parken",
                LocalDateTime.parse("2018-05-28T13:00:00"), false);

        Service.addLedsager(u1, l1);

    }

}
