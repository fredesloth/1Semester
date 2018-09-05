package guifx;

import java.util.Optional;

import application.model.Deltager;
import application.model.Konference;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TilmeldingManagementPane extends GridPane {
	private ListView<Deltager> lwParticipants;
	private ListView<Tilmelding> lwRegistrations;
	private Button btnUpdate, btnDelete, btnCreateDeltager, btnUpdateDeltager, btnRemoveDeltager;
	private Label lbParticipants, lbRegistrations;

	public TilmeldingManagementPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		lbParticipants = new Label("Select person");
		this.add(lbParticipants, 0, 0);

		lwParticipants = new ListView<>();
		this.add(lwParticipants, 0, 1, 1, 5);
		lwParticipants.setPrefWidth(200);
		lwParticipants.setPrefHeight(200);
		lwParticipants.getItems().setAll(Service.getDeltagere());

		//Selected participant listener
		ChangeListener<Deltager> pListener = (ov, oldP, newP) -> this.selectedPChange();
		lwParticipants.getSelectionModel().selectedItemProperty().addListener(pListener);

		lbRegistrations = new Label("Registrations");
		this.add(lbRegistrations, 1, 0);

		lwRegistrations = new ListView<>();
		this.add(lwRegistrations, 1, 1, 2, 5);
		lwRegistrations.setPrefWidth(400);
		lwRegistrations.setPrefHeight(200);

		//Selected participant listener
		ChangeListener<Tilmelding> signupListener = (ov, oldP, newP) -> this.selectedSignupChange();
		lwRegistrations.getSelectionModel().selectedItemProperty().addListener(signupListener);

		btnUpdate = new Button("Update");
		btnUpdate.setOnAction(event -> this.updateAction());
		btnUpdate.setMaxWidth(Double.MAX_VALUE);
		btnUpdate.setDisable(true);
		this.add(btnUpdate, 3, 1);

		btnDelete = new Button("Delete");
		btnDelete.setOnAction(event -> this.deleteAction());
		btnDelete.setMaxWidth(Double.MAX_VALUE);
		btnDelete.setDisable(true);
		this.add(btnDelete, 3, 2);
		
		btnCreateDeltager = new Button("Create user");
		btnCreateDeltager.setOnAction(event -> this.createUserAction());
		btnCreateDeltager.setMaxWidth(Double.MAX_VALUE);
		this.add(btnCreateDeltager, 3, 3);

		btnUpdateDeltager = new Button("Update user");
		btnUpdateDeltager.setOnAction(event -> this.updateUserAction());
		btnUpdateDeltager.setMaxWidth(Double.MAX_VALUE);
		btnUpdateDeltager.setDisable(true);
		this.add(btnUpdateDeltager, 3, 4);
		
		btnRemoveDeltager = new Button("Delete user");
		btnRemoveDeltager.setOnAction(event -> this.deleteUserAction());
		btnRemoveDeltager.setMaxWidth(Double.MAX_VALUE);
		btnRemoveDeltager.setDisable(true);
		this.add(btnRemoveDeltager, 3, 5);

		this.updateControls();
	}

	// ----------------------------------------------------------------
	// Actions - Tilmelding

	public void updateAction() {
		Deltager d = lwParticipants.getSelectionModel().getSelectedItem();
		Tilmelding t = lwRegistrations.getSelectionModel().getSelectedItem();
		Konference k = Service.getKonferenceFromTilmelding(t);
		if (t == null || k == null || d == null) {
			return;
		}

		TilmeldingWindow dia = new TilmeldingWindow("Sign up", d , k, t);
		dia.showAndWait();

		// Wait for modal dialog to close

		this.refreshControls();
	}

	public void deleteAction() {
		Tilmelding t = lwRegistrations.getSelectionModel().getSelectedItem();
		Deltager d = lwParticipants.getSelectionModel().getSelectedItem();
		Konference k = Service.getKonferenceFromTilmelding(t);

		if (t == null || d == null)
			return;

		Stage owner = (Stage) this.getScene().getWindow();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Delete Registration");
		alert.initOwner(owner);
		alert.setHeaderText("Are you sure?");

		// Wait for Modal to close

		Optional<ButtonType> result = alert.showAndWait();
		if (result.isPresent() && result.get() == ButtonType.OK) {
			Service.removeTilmeding(t, k, d);
			this.refreshControls();
		}
	}
	
	// ----------------------------------------------------------------
	// Actions - Deltager
	
	public void createUserAction () {
		DeltagerWindow dia = new DeltagerWindow("Create User");
		dia.showAndWait();

		// Wait for Modal to close

		refreshControls();
	}
	
	public void updateUserAction () {
		Deltager d = lwParticipants.getSelectionModel().getSelectedItem();
		DeltagerWindow dia = new DeltagerWindow("Update user", d);
		dia.showAndWait();

		// Wait for Modal to close

		refreshControls();
	}
	
	public void deleteUserAction () {
		Deltager d = lwParticipants.getSelectionModel().getSelectedItem();
		if (d == null) {
			return;
		}

		if (d.getTilmeldinger().size() == 0) {
			Stage owner = (Stage) this.getScene().getWindow();
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Delete Hotel");
			alert.initOwner(owner);
			alert.setHeaderText("Are you sure?");

			// Wait for Modal to close

			Optional<ButtonType> result = alert.showAndWait();
			if (result.isPresent() && result.get() == ButtonType.OK) {	
				Service.removeDeltager(d);
				this.refreshControls();
			}
		} else {
			Stage owner = (Stage) this.getScene().getWindow();
			Alert alert = new Alert(AlertType.ERROR, "Delete User");
			alert.setHeaderText("Can't delete a user that has registrations");
			alert.initOwner(owner);
			alert.showAndWait();
		}
	}

	// ----------------------------------------------------------------
	// Selection methods

	private void selectedPChange() {
		this.updateControls();
	}

	private void selectedSignupChange() {
		if (lwParticipants.getSelectionModel().getSelectedItem() != null) {
			this.btnUpdate.setDisable(false);
			this.btnDelete.setDisable(false);
		} else {
			this.btnUpdate.setDisable(true);
			this.btnDelete.setDisable(true);
			this.updateControls();
		}
	}

	// ----------------------------------------------------------------
	// Controls

	private void refreshControls() {
		int selectedIndex = lwParticipants.getSelectionModel().getSelectedIndex();
		lwParticipants.getItems().setAll(Service.getDeltagere());
		lwParticipants.getSelectionModel().select(selectedIndex);
	}

	public void updateControls() {
		Deltager p = lwParticipants.getSelectionModel().getSelectedItem();		
		if (p != null) {
			btnUpdateDeltager.setDisable(false);
			btnRemoveDeltager.setDisable(false);
			this.lwRegistrations.getItems().clear();
			if (p.getTilmeldinger() != null) {
				this.lwRegistrations.getItems().addAll(Service.getDeltagerTilmeldinger(p));
			}		
		} else {
			this.lwRegistrations.getItems().clear();
			btnUpdateDeltager.setDisable(true);
			btnRemoveDeltager.setDisable(true);
		}
	}

}
