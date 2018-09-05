package model;

public class PlayingCardP418 {
    // Attributer (egenskaber) ved kortet
    private String nummer;
    private String type;

    // Constructor hvor man skal indtaste nummer og type
    public PlayingCardP418(String nummer, String type) {
        this.nummer = nummer;
        this.type = type;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public String getNummer() {
        return nummer;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String setType() {
        return type;
    }
}
