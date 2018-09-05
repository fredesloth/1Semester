package application.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private String beskrivelse;
    private LocalDate startDato;
    private LocalDate slutDato;
    private double pris;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();
    private ArrayList<Hotel> hoteller = new ArrayList<>();
    private ArrayList<Udflugt> udflugter = new ArrayList<>();
    private ArrayList<HotelBooking> hotelBookinger = new ArrayList<>();

    public Konference(String navn, String beskrivelse, String adresse, LocalDate startDato, LocalDate slutDato,
            double pris) {
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.pris = pris;
    }
    // ---------------------------------------------------------------------

    public int getDays() {
        long days = ChronoUnit.DAYS.between(startDato, slutDato);
        return (int) days;
    }

    // ---------------------------------------------------------------------

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    public void addTilmelding(Tilmelding tilmelding) {
        tilmeldinger.add(tilmelding);
    }

    public void removeTilmelding(Tilmelding tilmelding) {
        tilmeldinger.remove(tilmelding);
    }

    // ---------------------------------------------------------------------

    public ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    public void addHotel(Hotel hotel) {
        hoteller.add(hotel);
    }

    public void remove(Hotel hotel) {
        hoteller.remove(hotel);
    }

    // ---------------------------------------------------------------------

    public ArrayList<Udflugt> getUdfluger() {
        return new ArrayList<>(udflugter);
    }

    public void addUdflugt(Udflugt udflugt) {
        udflugter.add(udflugt);
    }

    public void removeUdflugt(Udflugt udflugt) {
        udflugter.remove(udflugt);
    }

    // ---------------------------------------------------------------------

    public ArrayList<HotelBooking> getHotelBooking() {
        return new ArrayList<>(hotelBookinger);
    }

    public void addHotelBooking(HotelBooking hotelBooking) {
        hotelBookinger.add(hotelBooking);
    }

    public void remove(HotelBooking hotelBooking) {
        hotelBookinger.remove(hotelBooking);
    }

    // ---------------------------------------------------------------------

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public String getNavn() {
        return navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public LocalDate startDato() {
        return startDato;
    }

    public LocalDate slutDato() {
        return slutDato;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    // ---------------------------------------------------------------------

    public Udflugt createUdfugt(double pris, String navn, String beskrivelse, LocalDateTime tidspunkt,
            boolean frokost) {
        Udflugt udflugt = new Udflugt(pris, navn, beskrivelse, tidspunkt, frokost);
        addUdflugt(udflugt);
        return udflugt;
    }

}
