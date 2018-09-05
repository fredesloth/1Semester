package guifx;

import application.model.Deltager;
import application.model.Konference;
import application.model.Tilmelding;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;

public class TilmeldingPane extends GridPane {
	private ListView<Konference> lwConferences; 
	private ListView<Deltager> lwParticipants;
	private ListView<Tilmelding> lwRegistrations;
	private Button btnSignUp;
	private Label lbConferences, lbParticipants, lbRegistrations;

	public TilmeldingPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false);

		lbParticipants = new Label("Select person");
		this.add(lbParticipants, 0, 0);

		lwParticipants = new ListView<>();
		this.add(lwParticipants, 0, 1, 1, 1);
		lwParticipants.setPrefWidth(200);
		lwParticipants.setPrefHeight(200);
		lwParticipants.getItems().setAll(Service.getDeltagere());

		//Selected participant listener
		ChangeListener<Deltager> pListener = (ov, oldP, newP) -> this.selectedPChange();
		lwParticipants.getSelectionModel().selectedItemProperty().addListener(pListener);

		lbConferences = new Label("Select Conference");
		this.add(lbConferences, 1, 0);

		lwConferences = new ListView<>();
		this.add(lwConferences, 1, 1, 1, 1);
		lwConferences.setPrefWidth(200);
		lwConferences.setPrefHeight(200);
		lwConferences.getItems().setAll(Service.getKonferencer());

		//Selected conference listener
		ChangeListener<Konference> listener = (ov2, oldConference, newConference) -> this.selectedConferenceChanged();
		lwConferences.getSelectionModel().selectedItemProperty().addListener(listener);

		lbRegistrations = new Label("Newly added registrations");
		this.add(lbRegistrations, 3, 0);

		lwRegistrations = new ListView<>();
		this.add(lwRegistrations, 3, 1, 1, 1);
		lwRegistrations.setPrefWidth(200);
		lwRegistrations.setPrefHeight(200);

		btnSignUp = new Button("Sign up");
		btnSignUp.setOnAction(event -> this.signUpAction());
		btnSignUp.setMaxWidth(Double.MAX_VALUE);
		btnSignUp.setDisable(true);
		this.add(btnSignUp, 2, 1);

		this.updateControls();
	}

	// ----------------------------------------------------------------
	// Actions

	public void signUpAction() {
		Deltager d = lwParticipants.getSelectionModel().getSelectedItem();
		Konference k = lwConferences.getSelectionModel().getSelectedItem();

		if (d != null && k != null) {
			TilmeldingWindow dia = new TilmeldingWindow("Sign up", d, k);
			dia.showAndWait();
		}

		// Wait for dialog to close

		this.refreshControls();
	}

	// ----------------------------------------------------------------
	// Selection methods

	public void selectedPChange() {
		this.updateControls();
	}

	public void selectedConferenceChanged() {
		if (lwParticipants.getSelectionModel().getSelectedItem() != null && lwConferences.getSelectionModel().getSelectedItem() != null) {
			this.btnSignUp.setDisable(false);
		} else {
			this.btnSignUp.setDisable(true);
			lwRegistrations.getItems().clear();
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
		lwRegistrations.getItems().clear();
		lwRegistrations.getItems().addAll(Service.getTilmeldinger());
		
		Deltager p = lwParticipants.getSelectionModel().getSelectedItem();
		if (p != null) {
			this.lwConferences.getItems().setAll(Service.getKonferencer());
		} else {
			this.lwConferences.getItems().clear();
		}
	}
}
