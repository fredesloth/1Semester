package application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import application.model.Tillæg;
import application.model.Deltager;
import application.model.Ledsager;
import application.model.Udflugt;

public class Tilmelding {

    private Udflugt udflugt;
    private Tillæg tillæg;

    private LocalDate ankomstDato;
    private LocalDate afrejseDato;
    private boolean foredragsholder;
    private Deltager deltager;
    private Ledsager ledsager;
    private int deltagerNr;
    private Hotel hotel;
    private ArrayList<Tillæg> hotelTillæg = new ArrayList<>();
    private Konference konference;

    public Tilmelding(Deltager deltager, int deltagerNr, boolean foredragsholder) {
        this.deltager = deltager;
        this.foredragsholder = foredragsholder;
        this.deltagerNr = deltagerNr;
        deltagerNr++;
        foredragsholder = false;
    }

    // ---------------------------------------------------------------------------------
    public int getDays() {
        long days = ChronoUnit.DAYS.between(ankomstDato, afrejseDato);
        return (int) days;

    }

    // ---------------------------------------------------------------------------------
    public Ledsager createLedsager(String navn) {
        Ledsager ledsager = new Ledsager(navn);
        setLedsager(ledsager);
        ledsager.setTilmelding(this);
        return ledsager;
    }

    // ---------------------------------------------------------------------------------
    public ArrayList<Tillæg> getTillæg() {
        return new ArrayList<>(hotelTillæg);
    }

    public void addTillæg(Tillæg tillæg) {
        hotelTillæg.add(tillæg);
    }

    public void removeTillæg(Tillæg tillæg) {
        hotelTillæg.remove(tillæg);
    }

    // ---------------------------------------------------------------------------------
    public void setDeltager(Deltager deltager) {
        this.deltager = deltager;
    }

    public void setForedragsholder(boolean foredragsholder) {
        this.foredragsholder = foredragsholder;
    }

    public void setDeltagerNr(int deltagerNr) {
        this.deltagerNr = deltagerNr;
    }

    public int getDeltagerNr() {
        return deltagerNr;
    }

    public Ledsager getLedsager() {
        return ledsager;
    }

    public void setLedsager(Ledsager ledsager) {
        this.ledsager = ledsager;
    }

    public LocalDate getAnkomstDato() {
        return ankomstDato;
    }

    public void setAnkomstDato(LocalDate ankomstDato) {
        this.ankomstDato = ankomstDato;
    }

    public LocalDate getAfrejseDato() {
        return afrejseDato;
    }

    public void setAfrejseDato(LocalDate afrejseDato) {
        this.afrejseDato = afrejseDato;
    }

    public boolean isForedragsholder() {
        return foredragsholder;
    }

    public Deltager getDeltager() {
        return deltager;
    }

    // ---------------------------------------------------------------------------------
    // Auto generated get/setters

    public Udflugt getUdflugt() {
        return udflugt;
    }

    public void setUdflugt(Udflugt udflugt) {
        this.udflugt = udflugt;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public ArrayList<Tillæg> getHotelTillæg() {
        return hotelTillæg;
    }

    public void setHotelTillæg(ArrayList<Tillæg> hotelTillæg) {
        this.hotelTillæg = hotelTillæg;
    }

    public Konference getKonference() {
        return konference;
    }

    public void setKonference(Konference konference) {
        this.konference = konference;
    }

    // ---------------------------------------------------------------------------------

    // public double beregnSamletPris() {
    // // if statement hvis det er dobbelt eller enkeltværelse
    // return 0;
    // }

    public double beregnSamletPris() {
        boolean ledsager = false;
        boolean foredragsholder = false;
        boolean hotelValgt = false;
        double sum = 0;
        if (ledsager == true && foredragsholder == false && hotelValgt == true) {
            sum = hotel.getDobbeltVærelsePris() + udflugt.getPris() + konference.getPris() + tillæg.getPris();
        } else if (ledsager == false && foredragsholder == false && hotelValgt == true) {
            sum = hotel.getEnkeltVærelsePris() + konference.getPris() + tillæg.getPris();
        } else if (ledsager == true && foredragsholder == true && hotelValgt == true) {
            sum = hotel.getDobbeltVærelsePris() + udflugt.getPris() + tillæg.getPris();
        } else if (ledsager == false && foredragsholder == true && hotelValgt == true) {
            sum = hotel.getEnkeltVærelsePris() + tillæg.getPris();
        } else if (ledsager == true && foredragsholder == true && hotelValgt == false) {
            sum = udflugt.getPris();
        } else if (ledsager == true && foredragsholder == false && hotelValgt == false) {
            sum = udflugt.getPris() + konference.getPris();
        } else if (ledsager == false && foredragsholder == true && hotelValgt == false) {
            sum = 0;
        }
        return sum;
    }

}
