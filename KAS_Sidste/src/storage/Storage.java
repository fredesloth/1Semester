package storage;

import java.util.ArrayList;

import application.model.Deltager;
import application.model.Hotel;
import application.model.Konference;
import application.model.Tilmelding;

public class Storage {
	private static ArrayList<Hotel> hoteller = new ArrayList<>();
	private static ArrayList<Konference> konferencer = new ArrayList<>();
	private static ArrayList<Deltager> deltagere = new ArrayList<>();
	private static ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

	// --------------------------------------------------------------------------

	public static void addHotel(Hotel hotel) {
		hoteller.add(hotel);
	}

	public static ArrayList<Hotel> getHoteller() {
		return new ArrayList<Hotel>(hoteller);
	} 

	public static void removeHotel(Hotel hotel) {
		hoteller.remove(hotel);
	}

	// --------------------------------------------------------------------------

	public static void addKonference(Konference konference) {
		konferencer.add(konference);
	}

	public static ArrayList<Konference> getKonferencer() {
		return new ArrayList<Konference>(konferencer);
	}

	public static void removeKonference(Konference konference) {
		konferencer.remove(konference);
	}

	// --------------------------------------------------------------------------

	public static void addDeltager(Deltager deltager) {
		deltagere.add(deltager);
	}

	public static ArrayList<Deltager> getDeltagere() {
		return new ArrayList<Deltager>(deltagere);
	}

	public static void removeDeltager(Deltager deltager) {
		deltagere.remove(deltager);
	}

	// --------------------------------------------------------------------------

	public static void addTilmelding(Tilmelding tilmelding) {
		tilmeldinger.add(tilmelding);
	}

	public static ArrayList<Tilmelding> getTilmeldinger() {
		return new ArrayList<Tilmelding>(tilmeldinger);
	}

	public static void removeTilmelding(Tilmelding tilmelding) {
		tilmeldinger.remove(tilmelding);
	}
}
