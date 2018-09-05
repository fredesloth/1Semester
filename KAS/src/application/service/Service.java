package application.service;

import java.time.LocalDate;

import application.model.Hotel;
import application.model.Konference;
import application.model.Deltager;
import application.model.Tilmelding;
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

    // --------------------------------------------------------------------------------------------------------------

    public static Tilmelding createTilmelding(Deltager deltager, boolean foredragsholder, int deltagerNr) {
        Tilmelding tilmelding = new Tilmelding(deltager, foredragsholder, deltagerNr);
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
}
