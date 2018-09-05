package application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Udflugt {
    private double pris;
    private String navn;
    private String beskrivelse;
    private LocalDateTime tidspunkt;
    private boolean frokost;
    private ArrayList<Ledsager> ledsagere = new ArrayList<>();

    public Udflugt(double pris, String navn, String beskrivelse, LocalDateTime tidspunkt, boolean frokost) {
        this.pris = pris;
        this.navn = navn;
        this.beskrivelse = beskrivelse;
        this.tidspunkt = tidspunkt;
        this.frokost = frokost;
        frokost = false;
    }

    // -----------------------------------------------------------------------
    public ArrayList<Ledsager> getLedsager() {
        return new ArrayList<>(ledsagere);
    }

    public void addLedsager(Ledsager ledsager) {
        ledsagere.add(ledsager);

    }

    public void removeLedsager(Ledsager ledsager) {
        ledsagere.remove(ledsager);
    }

    // -----------------------------------------------------------------------
    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public LocalDateTime getTidspunkt() {
        return tidspunkt;
    }

    public void setTidspunkt(LocalDateTime tidspunkt) {
        this.tidspunkt = tidspunkt;
    }

    public boolean isFrokost() {
        return frokost;
    }

    public void setFrokost(boolean frokost) {
        this.frokost = frokost;
    }

    public ArrayList<Ledsager> getLedsagere() {
        return new ArrayList<>(ledsagere);
    }

    public void setLedsagere(ArrayList<Ledsager> ledsagere) {
        this.ledsagere = ledsagere;
    }

    @Override
    public String toString() {
        return navn;
    }

}
