package guifx;

import java.util.Optional;

import application.model.Hotel;
import application.model.Konference;
import application.model.Tillæg;
import application.model.Tilmelding;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HotelPane extends GridPane {
	private TextArea txaDetails, txaRegistrations;
	private ListView<Tillæg> lwServices; 
	private ListView<Hotel> lwHotels;
	private Button btnCreate, btnUpdate, btnDelete, btnCreateService, btnUpdateService, btnDeleteService, btnUpdateRegistrations;
	private Label lbDetails, lbHotels, lbServices, lbRegistrations;

	public HotelPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		lbHotels = new Label("Hotels");
		this.add(lbHotels, 0, 0);

		lwHotels = new ListView<>();
		this.add(lwHotels, 0, 1, 1, 6);
		lwHotels.setPrefWidth(200);
		lwHotels.setPrefHeight(200);
		lwHotels.getItems().setAll(Service.getHoteller());

		//Selected hotel listener
		ChangeListener<Hotel> listener = (ov, oldHotel, newHotel) -> this.selectedHotelChanged();
		lwHotels.getSelectionModel().selectedItemProperty().addListener(listener);

		lbDetails = new Label("Details");
		this.add(lbDetails, 1, 0);

		txaDetails = new TextArea();
		this.add(txaDetails, 1, 1, 1, 6);
		txaDetails.setPrefWidth(200);
		txaDetails.setPrefHeight(200);
		txaDetails.setEditable(false);

		lbServices = new Label("Services");
		this.add(lbServices, 2, 0);

		lwServices = new ListView<>();
		this.add(lwServices, 2, 1, 1, 6);
		lwServices.setPrefWidth(200);
		lwServices.setPrefHeight(200);

		//Selected service listener
		ChangeListener<Tillæg> serviceListener = (ov, oldService, newService) -> this.selectedServiceChanged();
		lwServices.getSelectionModel().selectedItemProperty().addListener(serviceListener);

		lbRegistrations = new Label("Registered bookings");
		this.add(lbRegistrations, 0, 7);

		txaRegistrations = new TextArea();
		this.add(txaRegistrations, 0, 8, 3, 1);
		txaRegistrations.setPrefHeight(200);
		txaRegistrations.setEditable(false);

		btnCreate = new Button("Create");
		btnCreate.setOnAction(event -> this.createAction());
		btnCreate.setMaxWidth(Double.MAX_VALUE);
		this.add(btnCreate, 3, 1);

		btnUpdate = new Button("Update");
		btnUpdate.setOnAction(event -> this.updateAction());
		btnUpdate.setMaxWidth(Double.MAX_VALUE);
		this.add(btnUpdate, 3, 2);

		btnDelete = new Button("Delete");
		btnDelete.setOnAction(event -> this.deleteAction());
		btnDelete.setMaxWidth(Double.MAX_VALUE);
		this.add(btnDelete, 3, 3);

		btnCreateService = new Button("New Service");
		btnCreateService.setOnAction(event -> this.createServiceAction());
		btnCreateService.setMaxWidth(Double.MAX_VALUE);
		btnCreateService.setDisable(true);
		this.add(btnCreateService, 3, 4);

		btnUpdateService = new Button("Udate Service");
		btnUpdateService.setOnAction(event -> this.updateServiceAction());
		btnUpdateService.setMaxWidth(Double.MAX_VALUE);
		btnUpdateService.setDisable(true);
		this.add(btnUpdateService, 3, 5);

		btnDeleteService = new Button("Delete Service");
		btnDeleteService.setOnAction(event -> this.deleteServiceAction());
		btnDeleteService.setMaxWidth(Double.MAX_VALUE);
		btnDeleteService.setDisable(true);
		this.add(btnDeleteService, 3, 6);

		btnUpdateRegistrations = new Button("Update");
		btnUpdateRegistrations.setOnAction(event -> this.updateRegistrationsAction());
		btnUpdateRegistrations.setMaxWidth(Double.MAX_VALUE);
		btnUpdateRegistrations.setDisable(true);
		this.add(btnUpdateRegistrations, 3, 8);
	}

	// ------------------------------------------------------------------
	// Hotel Actions

	public void createAction() {
		HotelWindow win = new HotelWindow("Create Hotel");
		win.showAndWait();

		// Wait for modal dialog to close

		refreshControlsCreated();
	}

	public void updateAction() {
		Hotel h = lwHotels.getSelectionModel().getSelectedItem();
		if (h == null) {
			return;
		}

		HotelWindow win = new HotelWindow("Update Hotel", h);
		win.showAndWait();


		// Wait for modal dialog to close

		refreshControls();
	}

	public void deleteAction() {
		Hotel h = lwHotels.getSelectionModel().getSelectedItem();
		if (h == null) {
			return;
		}

		if (!checkRegistrations(h)) {
			Stage owner = (Stage) this.getScene().getWindow();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Delete Hotel");
			alert.initOwner(owner);
			alert.setHeaderText("Are you sure?");

			// Wait for Modal to close

			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {	
				for (Konference k : Service.getKonferencer()) {
					Service.removeHotelFromKonference(k, h);
				}
				Service.removeHotel(h);			
				lwHotels.getItems().setAll(Service.getHoteller());
				this.updateControls();
			}
		} else {
			Stage owner = (Stage) this.getScene().getWindow();
			Alert alert = new Alert(AlertType.ERROR, "Delete Hotel");
			alert.setHeaderText("Can't delete a hotel that has participants");
			alert.initOwner(owner);
			alert.showAndWait();
		}
	}

	// ------------------------------------------------------------------
	// Service Actions

	public void createServiceAction() {
		Hotel h = lwHotels.getSelectionModel().getSelectedItem();
		ServiceWindow dia = new ServiceWindow("Create", h);
		dia.showAndWait();

		// Wait for Modal to close

		refreshControls();
	}

	public void updateServiceAction() {
		Hotel h = lwHotels.getSelectionModel().getSelectedItem();
		Tillæg s = lwServices.getSelectionModel().getSelectedItem();

		ServiceWindow dia = new ServiceWindow("Create", s, h);
		dia.showAndWait();

		// Wait for Modal to close

		refreshControls();

	}

	public void deleteServiceAction() {
		Hotel h = lwHotels.getSelectionModel().getSelectedItem();
		Tillæg s = lwServices.getSelectionModel().getSelectedItem();
		if (s == null) {
			return;
		}

		Stage owner = (Stage) this.getScene().getWindow();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Delete Hotel");
		alert.initOwner(owner);
		alert.setHeaderText("Are you sure?");

		// Wait for Modal to close

		Optional<ButtonType> result = alert.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.OK) {
			Service.removeHotelTillæg(h, s);
			lwHotels.getItems().setAll(Service.getHoteller());
			this.refreshControls();
		}

	}

	public void updateRegistrationsAction() {
		this.refreshControls();
	}

	// ------------------------------------------------------------------
	// Controls & Listeners

	public void selectedHotelChanged() {
		txaRegistrations.clear();
		updateControls();
		if(lwHotels.getSelectionModel().getSelectedItem() != null) {
			this.btnUpdateRegistrations.setDisable(false);
			this.btnCreateService.setDisable(false);		
		}			
	}

	private void selectedServiceChanged() {
		if(lwServices.getSelectionModel().getSelectedItem() != null) {
			this.btnUpdateService.setDisable(false);
			this.btnDeleteService.setDisable(false);
		}
	}

	private void refreshControls() {
		int selectedIndex = lwHotels.getSelectionModel().getSelectedIndex();
		lwHotels.getItems().setAll(Service.getHoteller());
		lwHotels.getSelectionModel().select(selectedIndex);
	}

	private void refreshControlsCreated() {
		lwHotels.getItems().setAll(Service.getHoteller());
		int index = lwHotels.getItems().size() - 1;
		lwHotels.getSelectionModel().select(index);
	}

	public void updateControls() {
		Hotel h = lwHotels.getSelectionModel().getSelectedItem();
		if (h != null) {
			txaDetails.setText(""
					+ "Double room:\n " + h.getDobbeltVærelsePris() + "DKK" + "\n"
					+ "Singel room:\n " + h.getEnkeltVærelsePris() + "DKK" + "\n"
					+ "Adress:\n " + h.getAddresse() + "\n"
					+ "Stars:\n " + h.getStjerner());
			lwServices.getItems().setAll(h.getTillæg());
			
			StringBuilder sb = new StringBuilder();
			for (Tilmelding t : Service.getTilmeldinger()) {			
				if(t.getHotel() == h && t.getLedsager() != null) {				
					sb.append(t.getDeltager() + "\n"
							+ " Companion: " + t.getLedsager() + "\n"
							+ " Additional services: " + t.getHotelTillæg() + "\n"
							+ " Arrival date: " + t.getAnkomstDato() + "\n"
							+ " Departure date: " + t.getAfrejseDato() + "\n"
							+ " Roomtype: " + getRoomType(t) + "\n"
							+ "\n");
				} else if (t.getHotel() == h && t.getLedsager() == null) {
					sb.append(t.getDeltager() + "\n"
							+ " Additional services: " + t.getHotelTillæg() + "\n"
							+ " Arrival date: " + t.getAnkomstDato() + "\n"
							+ " Departure date: " + t.getAfrejseDato() + "\n"
							+ " Roomtype: " + getRoomType(t) + "\n"
							+ "\n");
				}
			}
			this.txaRegistrations.setText("" + sb);
		} else {
			this.txaDetails.clear();
			this.lwServices.getItems().clear();
		}
	}

	private String getRoomType(Tilmelding tilmelding) {
		String roomtype = "Single";
		if (tilmelding.getLedsager() != null) {
			roomtype = "Double";
		}

		return roomtype;
	}
	
	private boolean checkRegistrations(Hotel hotel) {
		boolean hasRegistrations = false;
		
		for (Tilmelding t : Service.getTilmeldinger()) {
			if (t.getHotel() == hotel) {
				hasRegistrations = true;
			}
		}
		
		return hasRegistrations;
	}

}
