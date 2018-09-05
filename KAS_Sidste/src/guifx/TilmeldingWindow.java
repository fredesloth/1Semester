package guifx;

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
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class TilmeldingWindow extends Stage {
	private Deltager participant;
	private Konference conference;
	private Tilmelding registration;

	public TilmeldingWindow(String title, Deltager participant, Konference conference, Tilmelding tilmelding) {
		this.participant = participant;
		this.conference = conference;
		this.registration = tilmelding;
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public TilmeldingWindow(String title, Deltager participant, Konference conference) {
		this(title, participant, conference, null);
	}

	// --------------------------------------------------------------------

	private TextField txfCompanion, txfPrice;
	private DatePicker dpArrival, dpDeparture;
	private CheckBox chbCompanion, chbLecturer, chbHotel;
	private ListView<Tillæg> lwServices; 
	private ListView<Udflugt> lwTrips;
	private ComboBox<Hotel> cbbHotels;
	private Label lbCname, lbCompanion, lbPrice, lbArrival, lbDeparture, lbPresenter, lbError, lbHotel, lbSelectHotel, lbServices, lbTrips;

	public void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		lbArrival = new Label("Select arrival date");
		pane.add(lbArrival, 0, 0);

		dpArrival = new DatePicker();
		pane.add(dpArrival, 0, 1);
		dpArrival.setValue(conference.getStartDato());
		//Selected arrival date listener
		ChangeListener<LocalDate> arrivalDateListener = (ov, oldVal, newVal) -> this.selectedArrivalDateChanged();
		dpArrival.valueProperty().addListener(arrivalDateListener);

		lbDeparture = new Label("Select departure date");
		pane.add(lbDeparture, 0, 2);

		dpDeparture = new DatePicker();
		pane.add(dpDeparture, 0, 3);
		dpDeparture.setValue(conference.getSlutDato());
		//Selected arrival date listener
		ChangeListener<LocalDate> departureDateListener = (ov, oldVal, newVal) -> this.selectedDepartureDateChanged();
		dpDeparture.valueProperty().addListener(departureDateListener);

		lbPresenter = new Label("Are you a lecturer at this conference?");
		pane.add(lbPresenter, 0, 4);

		chbLecturer = new CheckBox();
		pane.add(chbLecturer, 0, 5);
		//Selected lecturer listener
		ChangeListener<Boolean> lecturerListener = (ov, oldVal, newVal) -> this.selectedLecturerChanged();
		chbLecturer.selectedProperty().addListener(lecturerListener);

		lbCompanion = new Label("Do you wish to bring a Companion?");
		pane.add(lbCompanion, 1, 0);

		chbCompanion = new CheckBox();
		pane.add(chbCompanion, 1, 1);
		//Selected companion listener
		ChangeListener<Boolean> listener = (ov2, oldVal, newVal) -> this.selectedCompanionChanged(newVal);
		chbCompanion.selectedProperty().addListener(listener);

		lbCname = new Label("Companion name");
		pane.add(lbCname, 1, 2);

		txfCompanion = new TextField();
		pane.add(txfCompanion, 1, 3);
		txfCompanion.setDisable(true);

		lbTrips = new Label("Select companion trips");
		pane.add(lbTrips, 1, 4);

		lwTrips = new ListView<>();
		pane.add(lwTrips, 1, 5, 1, 3);
		lwTrips.setPrefHeight(100);
		lwTrips.setPrefWidth(100);
		lwTrips.setDisable(true);
		lwTrips.getItems().addAll(conference.getUdflugter());
		lwTrips.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		//Selected trips listener
		ChangeListener<Udflugt> tripListener = (ov, oldTrips, newTrips) -> this.selectedTripsChanged();
		lwTrips.getSelectionModel().selectedItemProperty().addListener(tripListener);

		lbHotel = new Label("Do you wish to book a hotel?");
		pane.add(lbHotel, 2, 0);

		chbHotel = new CheckBox();
		pane.add(chbHotel, 2, 1);
		//Selected hotel listener
		ChangeListener<Boolean> wantHotelListener = (ov2, oldVal, newVal) -> this.selectedHotelChanged(newVal);
		chbHotel.selectedProperty().addListener(wantHotelListener);

		lbSelectHotel = new Label("Select a hotel");
		pane.add(lbSelectHotel, 2, 2);

		cbbHotels = new ComboBox<>();
		pane.add(cbbHotels, 2, 3);
		cbbHotels.getItems().addAll(conference.getHoteller());
		cbbHotels.setDisable(true);
		cbbHotels.setMaxWidth(Double.MAX_VALUE);
		//Selected hotel listener
		ChangeListener<Hotel> hotelListener = (ov, oldHotel, newHotel) -> this.selectedCbbHotelChanged();
		cbbHotels.getSelectionModel().selectedItemProperty().addListener(hotelListener);

		lbServices = new Label("Select additional hotel services");
		pane.add(lbServices, 2, 4);

		lwServices = new ListView<>();
		pane.add(lwServices, 2, 5, 1, 3);
		lwServices.setPrefHeight(100);
		lwServices.setPrefWidth(100);
		lwServices.setDisable(true);
		lwServices.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		//Selected services listener
		ChangeListener<Tillæg> serviceListener = (ov, oldServices, newServices) -> this.selectedServicesChanged();
		lwServices.getSelectionModel().selectedItemProperty().addListener(serviceListener);

		lbPrice = new Label("Total price");
		pane.add(lbPrice, 3, 0);

		txfPrice = new TextField();
		pane.add(txfPrice, 3, 1);
		txfPrice.setEditable(false);
		txfPrice.setText("" + this.getPrice());

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 3, 3);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setMaxWidth(Double.MAX_VALUE);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 3, 4);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setMaxWidth(Double.MAX_VALUE);
		btnOK.setOnAction(event -> this.okAction());

		lbError = new Label();
		pane.add(lbError, 0, 9, 4, 1);
		lbError.setStyle("-fx-text-fill: red");

		this.initControls();
	}

	// ------------------------------------------------------------------------
	// Listener methods

	private void selectedCompanionChanged(boolean checked) {
		if(checked) {
			this.lwTrips.setDisable(!checked);
			this.txfCompanion.setDisable(!checked);
			txfPrice.setText("" + this.getPrice());
		} else {
			this.txfCompanion.setDisable(!checked);
			this.lwTrips.setDisable(!checked);
			this.lwTrips.getSelectionModel().clearSelection();
			txfPrice.setText("" + this.getPrice());
		}
	}

	private void selectedHotelChanged(boolean checked) {		
		if(checked) {
			cbbHotels.setDisable(!checked);
			txfPrice.setText("" + this.getPrice());
			lwServices.setDisable(!checked);
		} else {
			cbbHotels.setDisable(!checked);
			lwServices.setDisable(!checked);
			cbbHotels.getSelectionModel().clearSelection();
		}
	}

	private void selectedCbbHotelChanged() {
		Hotel h = cbbHotels.getSelectionModel().getSelectedItem();
		txfPrice.setText("" + this.getPrice());
		if (h != null) {
			lwServices.getItems().setAll(h.getTillæg());
		} else {
			lwServices.getItems().clear();
		}
	}

	private void selectedServicesChanged() {
		txfPrice.setText("" + this.getPrice());
	}

	private void selectedTripsChanged() {
		txfPrice.setText("" + this.getPrice());
	}

	private void selectedLecturerChanged() {
		txfPrice.setText("" + this.getPrice());
	}

	private void selectedArrivalDateChanged() {
		txfPrice.setText("" + this.getPrice());
	}

	private void selectedDepartureDateChanged() {
		txfPrice.setText("" + this.getPrice());
	}

	// ------------------------------------------------------------------------
	// Actions

	public void okAction() {
		ArrayList<Tillæg> services = new ArrayList<>();
		ArrayList<Udflugt> trips = new ArrayList<>();
		LocalDate selectedStart = dpArrival.getValue();
		LocalDate selectedEnd = dpDeparture.getValue();
		String companionName = txfCompanion.getText().trim();
		boolean lecturer = chbLecturer.isSelected();
		boolean companion = chbCompanion.isSelected();
		LocalDate conferenceStart = conference.getStartDato();
		LocalDate conferenceEnd = conference.getSlutDato();
		Hotel h = cbbHotels.getSelectionModel().getSelectedItem();

		if (lwTrips.getSelectionModel().getSelectedItems() != null) {
			for (Udflugt u : lwTrips.getSelectionModel().getSelectedItems()) {
				trips.add(u);
			}
		}

		if (lwServices.getSelectionModel().getSelectedItems() != null) {
			for (Tillæg t : lwServices.getSelectionModel().getSelectedItems()) {
				services.add(t);
			}
		}

		if (companion && companionName.length() == 0) {
			lbError.setText("Please enter companion name");
			return;
		}

		if (validDatesSelected()) {
			if (registration != null) {
				Ledsager existingCompanion = registration.getLedsager();	
				Service.updateTilmeldingTest(registration, selectedStart, selectedEnd, lecturer, existingCompanion, companionName, trips, h, services);
				if (existingCompanion == null && companion) {
					Service.createLedsager(registration, companionName, trips);
				} else if (existingCompanion != null && !companion) {
					Service.removeLedsager(registration);
				}
			} else {
				if (Service.checkSignUp(conference, participant)) {
					lbError.setText("You have already signed up for this conference");
					return;
				}

				Tilmelding t = Service.createTilmelding(selectedStart, selectedEnd, participant, lecturer, conference, h, services);
				if (companion) {
					Service.createLedsager(t, companionName, trips);		
				}
			}
		} else {
			lbError.setText("Invalid dates selected, this conference starts: " 
					+ conferenceStart + " and ends: " + conferenceEnd);
			return;
		}

		this.hide();
	}
	public void cancelAction() {
		this.hide();
	}

	// -----------------------------------------------------------------------------
	// Controls

	private void initControls() {
		if (registration != null) {
			dpArrival.setValue(registration.getAnkomstDato());
			dpDeparture.setValue(registration.getAfrejseDato());
			chbLecturer.setSelected(registration.isForedragsholder());
			if (registration.getLedsager() != null) {
				Ledsager l = registration.getLedsager();
				chbCompanion.setSelected(true);
				txfCompanion.setText(registration.getLedsager().getNavn());
				for (Udflugt u : l.getUdflugter()) {
					lwTrips.getSelectionModel().select(u);
				}			
			}
			if (registration.getHotel() != null) {
				Hotel h = registration.getHotel();
				chbHotel.setSelected(true);
				cbbHotels.getSelectionModel().select(h);
				lwServices.setDisable(false);
				ArrayList<Tillæg> servicesToSelect = new ArrayList<>(registration.getHotelTillæg());
				for (Tillæg t : servicesToSelect) {
					lwServices.getSelectionModel().select(t);
				}
			}
		}
	}

	// -----------------------------------------------------------------------------
	// Other methods

	private double getPrice() {
		ArrayList<Tillæg> services = new ArrayList<>();
		ArrayList<Udflugt> trips = new ArrayList<>();
		LocalDate selectedStart = dpArrival.getValue();
		LocalDate selectedEnd = dpDeparture.getValue();
		String companionName = txfCompanion.getText().trim();
		boolean lecturer = chbLecturer.isSelected();
		boolean companion = chbCompanion.isSelected();
		Hotel h = cbbHotels.getSelectionModel().getSelectedItem();
		double price = 0.0;

		if (lwTrips.getSelectionModel().getSelectedItems() != null) {
			for (Udflugt u : lwTrips.getSelectionModel().getSelectedItems()) {
				trips.add(u);
			}
		}

		if (lwServices.getSelectionModel().getSelectedItems() != null) {
			for (Tillæg t : lwServices.getSelectionModel().getSelectedItems()) {
				services.add(t);
			}
		}

		if (validDatesSelected()) {
			Tilmelding temp = Service.createTilmelding(selectedStart, selectedEnd, participant, lecturer, conference, h, services);
			if (companion) {
				Service.createLedsager(temp, companionName, trips);		
			}
			
			price = temp.beregnSamletPris();
			
			Service.removeTilmeding(temp, conference, participant);
			temp.fratrækTilmelding();
		} else {
			lbError.setText("Invalid dates selected");
		}

		return price;
	}

	private boolean validDatesSelected() {
		LocalDate conferenceStart = conference.getStartDato();
		LocalDate conferenceEnd = conference.getSlutDato();
		LocalDate selectedStart = dpArrival.getValue();
		LocalDate selectedEnd = dpDeparture.getValue();
		boolean valid = true;

		if (selectedStart.isBefore(conferenceStart) || selectedEnd.isAfter(conferenceEnd) || selectedStart.isAfter(selectedEnd) || selectedStart.isEqual(selectedEnd)) {
			valid = false;
		}

		return valid;
	}

}
