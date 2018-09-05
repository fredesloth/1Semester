package application.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import application.model.Deltager;
import application.model.Hotel;
import application.model.Konference;
import application.model.Ledsager;

public class Tilmelding {
    private LocalDate ankomstDato;
    private LocalDate afrejseDato;
    private Deltager deltager;
    private Ledsager ledsager;
    private int deltagerNr;
    private static int antalTilmeldinger;
    private boolean foredragsholder;
    private Konference konference;
    private Hotel hotel;
    private ArrayList<Tillæg> hotelTillæg;

    public Tilmelding(LocalDate ankomstDato, LocalDate afrejseDato, Deltager deltager, boolean foredragsholder,
            Konference konference) {
        this.deltager = deltager;
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
        this.foredragsholder = foredragsholder;
        this.konference = konference;
        antalTilmeldinger++;
        this.deltagerNr = antalTilmeldinger;
        deltager.addTilmelding(this);
        konference.addTilmelding(this);
    }

    @Override
    public String toString() {
        return deltager.getFornavn() + deltager.getEfternavn() + "(" + deltagerNr + "), " + konference.getNavn() + ", "
                + beregnSamletPris() + "DKK";
    }

    public int getAntalDage() {
        Period p = ankomstDato.until(afrejseDato);
        int antalDage = p.getDays();

        return antalDage;
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public Ledsager getLedsager() {
        return ledsager;
    }

    public Ledsager createLedsager(String navn) {
        Ledsager ledsager = new Ledsager(navn);
        this.ledsager = ledsager;
        ledsager.setTilmelding(this);
        return ledsager;
    }

    public void removeLedsager() {
        this.ledsager = null;
    }

    public void setLedsager(Ledsager ledsager) {
        this.ledsager = ledsager;
    }

    public int getDeltagerNr() {
        return deltagerNr;
    }

    public void fratrækTilmelding() {
        Tilmelding.antalTilmeldinger--;
    }

    public boolean isForedragsholder() {
        return foredragsholder;
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

    public void setDeltager(Deltager deltager) {
        this.deltager = deltager;
    }

    public void setForedragsholder(boolean foredragsholder) {
        this.foredragsholder = foredragsholder;
    }

    public void setKonference(Konference konference) {
        this.konference = konference;
    }

    public Konference getKonference() {
        return this.konference;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public ArrayList<Tillæg> getHotelTillæg() {
        return new ArrayList<>(hotelTillæg);
    }

    public void addHotelTillæg(Tillæg hotelTillæg) {
        this.hotelTillæg.add(hotelTillæg);
    }

    public void setHotelTillæg(ArrayList<Tillæg> tillæg) {
        this.hotelTillæg = tillæg;
    }

    public double getTillægsPris() {
        double sum = 0.0;

        if (hotelTillæg.size() > 0) {
            for (Tillæg t : hotelTillæg) {
                sum += t.getPris();
            }
        }

        return sum;
    }

    // -------------------------------------------------------------------

    public double beregnSamletPris() {
        double sum = 0.0;
        double enkeltværelse = 0.0;
        double dobbeltværelse = 0.0;
        double konferencePris = konference.getPris() * getAntalDage();
        double udflugter = 0.0;

        if (hotel != null) {
            enkeltværelse = (getHotel().getEnkeltVærelsePris() + getTillægsPris()) * getAntalDage();
            dobbeltværelse = (getHotel().getDobbeltVærelsePris() + getTillægsPris()) * getAntalDage();
        }

        if (ledsager != null) {
            udflugter = ledsager.getUdflugtPris();
        }

        if (foredragsholder) {
            if (hotel != null && ledsager == null) {
                sum = enkeltværelse;
            } else if (hotel != null && ledsager != null) {
                sum = dobbeltværelse + udflugter;
            } else if (hotel == null && ledsager != null) {
                sum = udflugter;
            }
        } else if (!foredragsholder) {
            sum = konferencePris;
            if (hotel != null && ledsager == null) {
                sum += enkeltværelse;
            } else if (hotel == null && ledsager != null) {
                sum += udflugter;
            } else if (hotel != null && ledsager != null) {
                sum += dobbeltværelse + udflugter;
            }
        }

        return sum;
    }

}
