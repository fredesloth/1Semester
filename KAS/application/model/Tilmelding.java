package application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import application.model.Deltager;
import application.model.Ledsager;
import application.model.HotelBooking;
import application.model.Udflugt;

public class Tilmelding {

    private Udflugt udflugt;
    private HotelBooking hotelBooking;
    private LocalDate ankomstDato;
    private LocalDate afrejseDato;
    private boolean foredragsholder;
    private Deltager deltager;
    private Ledsager ledsager;
    private HotelBooking HotelBooking;
    private int deltagerNr;

    public Tilmelding(Deltager deltager, boolean foredragsholder, int deltagerNr) {
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

    public Ledsager createLedsager(String navn) {
        Ledsager ledsager = new Ledsager(navn);
        setLedsager(ledsager);
        ledsager.setTilmelding(this);
        return ledsager;
    }

    public HotelBooking createHotelBooking(int antalDage, Hotel hotel) {
        HotelBooking hotelBooking = new HotelBooking(antalDage, hotel);
        setHotelBooking(hotelBooking);
        hotelBooking.setTilmelding(this);
        return hotelBooking;
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

    public HotelBooking getHotelBooking() {
        return HotelBooking;
    }

    public void setHotelBooking(HotelBooking hotelBooking) {
        HotelBooking = hotelBooking;
    }

    public boolean isForedragsholder() {
        return foredragsholder;
    }

    public Deltager getDeltager() {
        return deltager;
    }

    // ---------------------------------------------------------------------------------

    // public double beregnSamletPris() {
    // // if statement hvis det er dobbelt eller enkeltværelse
    // return 0;
    // }

    public double beregnSamletPris() {
        boolean ledsager = true;
        double sum = 0;
        if (ledsager == false) {
            sum = hotelBooking.beregnSamletHotelPris(sum) + udflugt.getPris();
        } else {
            sum = hotelBooking.beregnSamletHotelPris(sum);
        }
        return sum;
    }

}
