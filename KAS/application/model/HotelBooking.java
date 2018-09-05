package application.model;

import java.util.ArrayList;
import application.model.Tilmelding;
import application.model.Hotel;
import application.model.Tillæg;

public class HotelBooking {

    private Tillæg tillæg;
    private int antalDage;
    private Tilmelding tilmelding;
    private Hotel hotel;
    private ArrayList<Tillæg> alleTillæg = new ArrayList<>();

    public HotelBooking(int antalDage, Hotel hotel) {
        this.antalDage = antalDage;
    }

    // -------------------------------------------------------------------------------

    public ArrayList<Tillæg> getTillæg() {
        return new ArrayList<>(alleTillæg);
    }

    public void addTillæg(Tillæg tillæg) {
        alleTillæg.add(tillæg);
    }

    public void removeTillæg(Tillæg tillæg) {
        alleTillæg.remove(tillæg);
    }

    public int getAntalDage() {
        return antalDage;
    }

    public void setAntalDage(int antalDage) {
        this.antalDage = antalDage;
    }

    public Tilmelding getTilmelding() {
        return tilmelding;
    }

    public void setTilmelding(Tilmelding tilmelding) {
        this.tilmelding = tilmelding;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public ArrayList<Tillæg> getAlleTillæg() {
        return alleTillæg;
    }

    public void setAlleTillæg(ArrayList<Tillæg> alleTillæg) {
        this.alleTillæg = alleTillæg;
    }

    // -------------------------------------------------------------------------------

    // ?!?!?!?!?!?!?!?!
    // beregnSamletHotelPris(ledsager : boolean) : double

    // public double beregnSamletHotelPris(double sum, boolean true)
    public double beregnSamletHotelPris(double sum) {
        boolean ledsager = true;
        sum = 0;
        if (ledsager == false) {
            sum = hotel.getEnkeltVærelsePris() + tillæg.getPris();
        } else {
            sum = hotel.getDobbeltVærelsePris() + tillæg.getPris();
        }
        return sum;
    }
}
