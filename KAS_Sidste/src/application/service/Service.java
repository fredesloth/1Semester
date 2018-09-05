package application.service;

import java.time.LocalDate;
import java.util.ArrayList;

import application.model.Deltager;
import application.model.Hotel;
import application.model.Konference;
import application.model.Ledsager;
import application.model.Tillæg;
import application.model.Tilmelding;
import application.model.Udflugt;
import application.service.Service;
import storage.Storage;

public class Service {
    // ----------------------------------------------------------------------------------------
    // Deltager

    public static Deltager createDeltager(String fornavn, String efternavn, String addresse, String by, String land,
            String tlf, String firmaNavn, String firmaTlf) {
        Deltager deltager = new Deltager(fornavn, efternavn, addresse, by, land, tlf, firmaNavn, firmaTlf);
        Storage.addDeltager(deltager);
        return deltager;
    }

    public static void removeDeltager(Deltager deltager) {
        Storage.removeDeltager(deltager);
    }

    public static void updateDeltager(Deltager deltager, String fornavn, String efternavn, String addresse, String by,
            String land, String tlf, String firmaNavn, String firmaTlf) {
        deltager.setAddresse(addresse);
        deltager.setBy(by);
        deltager.setEfternavn(efternavn);
        deltager.setFornavn(fornavn);
        deltager.setLand(land);
        deltager.setTlf(tlf);
        deltager.setFirmaNavn(firmaNavn);
        deltager.setFirmaTlf(firmaTlf);
    }

    public static ArrayList<Deltager> getDeltagere() {
        return Storage.getDeltagere();
    }

    public static ArrayList<Tilmelding> getDeltagerTilmeldinger(Deltager deltager) {
        return deltager.getTilmeldinger();
    }

    // ----------------------------------------------------------------------------------------
    // Hotel

    public static Hotel createHotel(String navn, double enkeltVærelsePris, double dobbeltVærelsePris, int stjerner,
            String addresse) {
        Hotel hotel = new Hotel(navn, enkeltVærelsePris, dobbeltVærelsePris, stjerner, addresse);
        Storage.addHotel(hotel);
        return hotel;
    }

    public static void removeHotel(Hotel hotel) {
        Storage.removeHotel(hotel);
    }

    public static void updateHotel(Hotel hotel, String navn, double enkeltVærelsePris, double dobbeltVærelsePris,
            int stjerner, String addresse) {
        hotel.setNavn(navn);
        hotel.setEnkeltVærelsePris(enkeltVærelsePris);
        hotel.setDobbeltVærelsePris(dobbeltVærelsePris);
        hotel.setStjerner(stjerner);
        hotel.setAddresse(addresse);
    }

    public static ArrayList<Hotel> getHoteller() {
        return Storage.getHoteller();
    }

    public static void updateHotelTillæg(Tillæg tillæg, String navn, double pris) {
        tillæg.setNavn(navn);
        tillæg.setPris(pris);
    }

    public static void createHotelTillæg(Hotel hotel, String navn, double pris) {
        hotel.createTillæg(navn, pris);
    }

    public static void removeHotelTillæg(Hotel hotel, Tillæg tillæg) {
        hotel.removeTillæg(tillæg);
    }

    // ----------------------------------------------------------------------------------------
    // Konference

    public static Konference createKonference(String navn, String beskrivelse, String addresse, LocalDate startDato,
            LocalDate slutDato, double pris, ArrayList<Hotel> hotels) {
        Konference konference = new Konference(navn, beskrivelse, addresse, startDato, slutDato, pris);
        konference.setHotels(hotels);
        Storage.addKonference(konference);
        return konference;
    }

    public static void removeKonference(Konference konference) {
        Storage.removeKonference(konference);
    }

    public static void updateKonference(Konference konference, String navn, String beskrivelse, String addresse,
            LocalDate startDato, LocalDate slutDato, double pris, ArrayList<Hotel> hotels) {
        konference.setNavn(navn);
        konference.setBeksrivelse(beskrivelse);
        konference.setAddresse(addresse);
        konference.setStartDato(startDato);
        konference.setSlutDato(slutDato);
        konference.setPris(pris);
        konference.setHotels(hotels);
    }

    public static void deleteKonferenceUdflugt(Udflugt udflugt, Konference konference) {
        konference.removeUdflugt(udflugt);
    }

    public static void updateKonferenceHoteller(Konference konference, ArrayList<Hotel> hoteller) {
        konference.setHotels(hoteller);
    }

    public static void removeHotelFromKonference(Konference konference, Hotel hotel) {
        konference.removeHotel(hotel);
    }

    public static void updateUdflugt(Udflugt udflugt, String navn, double pris, String beskrivelse, LocalDate dato,
            String tid, boolean frokost) {
        udflugt.setBeskrivelse(beskrivelse);
        udflugt.setDate(dato);
        udflugt.setFrokost(frokost);
        udflugt.setPris(pris);
        udflugt.setTid(tid);
        udflugt.setNavn(navn);
    }

    public static void createUdflugt(Konference konference, String navn, double pris, String beskrivelse,
            LocalDate dato, String tid, boolean frokost) {
        konference.createUdflugt(navn, pris, beskrivelse, dato, tid, frokost);
    }

    public static ArrayList<Udflugt> getKonferenceUdflugter(Konference konference) {
        return konference.getUdflugter();
    }

    public static ArrayList<Konference> getKonferencer() {
        return Storage.getKonferencer();
    }

    public static void addHotelToKonference(Hotel hotel, Konference konference) {
        konference.addHotel(hotel);
    }

    public static boolean checkSignUp(Konference konference, Deltager deltager) {
        return konference.checkAlreadySignedUp(deltager);
    }

    public static ArrayList<Tilmelding> getKonferenceTilmeldinger(Konference konference) {
        return konference.getTilmeldinger();
    }

    public static ArrayList<Udflugt> getLedsagerUdflugter(Ledsager ledsager) {
        return ledsager.getUdflugter();
    }

    // ----------------------------------------------------------------------------------------
    // Tilmelding

    public static Tilmelding createTilmelding(LocalDate ankomstDato, LocalDate afrejseDato, Deltager deltager,
            boolean foredragsholder, Konference konference, Hotel hotel, ArrayList<Tillæg> tillæg) {
        Tilmelding tilmelding = new Tilmelding(ankomstDato, afrejseDato, deltager, foredragsholder, konference);
        if (hotel != null) {
            tilmelding.setHotel(hotel);
            tilmelding.setHotelTillæg(tillæg);
        }
        Storage.addTilmelding(tilmelding);
        return tilmelding;
    }

    public static void removeTilmeding(Tilmelding tilmelding, Konference konference, Deltager deltager) {
        konference.removeTilmelding(tilmelding);
        deltager.removeTilmelding(tilmelding);
        Storage.removeTilmelding(tilmelding);
    }

    public static void updateTilmelding(Tilmelding tilmelding, LocalDate ankomstDato, LocalDate afrejseDato,
            boolean foredragsholder) {
        tilmelding.setAfrejseDato(afrejseDato);
        tilmelding.setAnkomstDato(ankomstDato);
        tilmelding.setForedragsholder(foredragsholder);
    }

    public static void updateTilmeldingTest(Tilmelding tilmelding, LocalDate ankomstDato, LocalDate afrejseDato,
            boolean foredragsholder, Ledsager ledsager, String ledsagernavn, ArrayList<Udflugt> udflugter, Hotel hotel,
            ArrayList<Tillæg> tillæg) {
        tilmelding.setAfrejseDato(afrejseDato);
        tilmelding.setAnkomstDato(ankomstDato);
        tilmelding.setForedragsholder(foredragsholder);
        tilmelding.setLedsager(ledsager);
        tilmelding.setHotel(hotel);
        tilmelding.setHotelTillæg(tillæg);
        if (ledsager != null) {
            ledsager.setNavn(ledsagernavn);
            ledsager.setUdflugter(udflugter);
        }
    }

    public static void updateLedsager(Tilmelding tilmelding, String navn, ArrayList<Udflugt> udflugter) {
        tilmelding.getLedsager().setNavn(navn);
        tilmelding.getLedsager().setUdflugter(udflugter);
    }

    public static void updateTilmeldingHotel(Tilmelding tilmelding, Hotel hotel, ArrayList<Tillæg> tillæg) {
        tilmelding.setHotel(hotel);
        tilmelding.setHotelTillæg(tillæg);
    }

    public static ArrayList<Tilmelding> getTilmeldinger() {
        return Storage.getTilmeldinger();
    }

    public static Ledsager createLedsager(Tilmelding tilmelding, String navn, ArrayList<Udflugt> trips) {
        Ledsager l = tilmelding.createLedsager(navn);
        l.setUdflugter(trips);
        return l;
    }

    public static Konference getKonferenceFromTilmelding(Tilmelding tilmelding) {
        return tilmelding.getKonference();
    }

    public static void removeLedsager(Tilmelding tilmelding) {
        tilmelding.removeLedsager();
    }

    public static Ledsager getLedsager(Tilmelding tilmelding) {
        return tilmelding.getLedsager();
    }

    // ----------------------------------------------------------------------------------------
    // Storage

    public static void initStorage() {
        ArrayList<Hotel> hotels = new ArrayList<>();

        Konference k1 = Service.createKonference("OmØl", "en konference om øl", "Vej 99, Aarhus",
                LocalDate.parse("2018-01-10"), LocalDate.parse("2018-01-14"), 250, hotels);
        Service.createDeltager("Tina", "Turner", "Vejen 2", "Aarhus", "Danmark", "+4521905723", "Java inc.",
                "+45 99 82 95 05");
        Hotel h1 = Service.createHotel("HotelAwesome", 500, 800, 4, "Enandenvej 8, Aarhus");
        Service.createUdflugt(k1, "test", 29.00, "Descr", LocalDate.parse("2018-01-02"), "20:00", false);
        Service.addHotelToKonference(h1, k1);

        Konference k2 = Service.createKonference("CykelFreak", "en konference om cykling", "Vejen 2, Aarhus",
                LocalDate.parse("2018-01-10"), LocalDate.parse("2018-01-14"), 250, hotels);
        Service.createDeltager("Morten", "Olsen", "Vejen 2", "Aarhus", "Danmark", "+4521905723", "", "");
        Hotel h2 = Service.createHotel("HoteAllmostAwesome", 200, 800, 4, "Pottevej 22, Aarhus");
        Service.createUdflugt(k2, "Rundt om brabrand sø", 29.00, "we walk around bb sø", LocalDate.parse("2018-01-02"),
                "10:00", true);
        Service.createUdflugt(k2, "Run yo", 20.00, "we around in circles", LocalDate.parse("2018-01-02"), "10:00",
                true);
        Service.addHotelToKonference(h2, k2);

    }
}
