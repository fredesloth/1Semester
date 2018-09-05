package guifx;

import application.model.Deltager;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DeltagerWindow extends Stage {
	private Deltager participant;

	public DeltagerWindow(String title, Deltager deltager) {
		this.participant = deltager;
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public DeltagerWindow(String title) {
		this(title, null);
	}

	// --------------------------------------------------------------------

	private TextField txfFornavn, txfEfternavn, txfAddresse, txfBy, txfLand, txfTlf, txfFirma, txfFirmaTlf;
	private CheckBox chbCompany;
	private Label lbFornavn, lbEfternavn, lbAddresse, lbBy, lbLand, lbTlf, lbFirma, lbFirmaTlf, lbCompany, lbError;

	public void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(20);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		lbFornavn = new Label("First name");
		pane.add(lbFornavn, 0, 0);

		txfFornavn = new TextField();
		pane.add(txfFornavn, 0, 1);

		lbEfternavn = new Label("Last name");
		pane.add(lbEfternavn, 0, 2);

		txfEfternavn = new TextField();
		pane.add(txfEfternavn, 0, 3);

		lbAddresse = new Label("Adress");
		pane.add(lbAddresse, 0, 4);

		txfAddresse = new TextField();
		pane.add(txfAddresse, 0, 5);

		lbBy = new Label("City");
		pane.add(lbBy, 0, 6);

		txfBy = new TextField();
		pane.add(txfBy, 0, 7);

		lbLand = new Label("Country");
		pane.add(lbLand, 0, 8);

		txfLand = new TextField();
		pane.add(txfLand, 0, 9);

		lbTlf = new Label("Phone");
		pane.add(lbTlf, 1, 0);

		txfTlf = new TextField();
		pane.add(txfTlf, 1, 1);

		lbCompany = new Label("Register company?");
		pane.add(lbCompany, 1, 2);

		chbCompany = new CheckBox();
		pane.add(chbCompany, 1, 3);
		chbCompany.setSelected(false);
		//Selected company listener
		ChangeListener<Boolean> companyListener = (ov, oldVal, newVal) -> this.selectedCompanyChanged(newVal);
		chbCompany.selectedProperty().addListener(companyListener);

		lbFirma = new Label("Company name");
		pane.add(lbFirma, 1, 4);

		txfFirma = new TextField();
		pane.add(txfFirma, 1, 5);
		txfFirma.setDisable(true);

		lbFirmaTlf = new Label("Company phone");
		pane.add(lbFirmaTlf, 1, 6);

		txfFirmaTlf = new TextField();
		pane.add(txfFirmaTlf, 1, 7);
		txfFirmaTlf.setDisable(true);

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 11);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setMaxWidth(Double.MAX_VALUE);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 1, 11);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setMaxWidth(Double.MAX_VALUE);
		btnOK.setOnAction(event -> this.okAction());

		lbError = new Label();
		pane.add(lbError, 0, 10, 2, 1);
		lbError.setStyle("-fx-text-fill: red");

		this.initControls();
	}

	// ------------------------------------------------------------------------
	// Actions

	private void okAction() {
		String fornavn = txfFornavn.getText().trim();
		String efternavn = txfEfternavn.getText().trim();
		String addresse = txfAddresse.getText().trim();
		String by = txfBy.getText().trim();
		String land = txfLand.getText().trim();
		String tlf = txfTlf.getText().trim();
		String firma = txfFirma.getText().trim();
		String firmaTlf = txfFirmaTlf.getText().trim();

		if (fornavn.length() == 0 || efternavn.length() == 0 || addresse.length() == 0 || by.length() == 0 
				|| land.length() == 0 || tlf.length() == 0) {
			lbError.setText("Empty fields detected, please fill out all required fields");
			return;
		}

		if (participant != null) {
			Service.updateDeltager(participant, fornavn, efternavn, addresse, by, land, tlf, firma, firmaTlf);
		} else {
			Service.createDeltager(fornavn, efternavn, addresse, by, land, tlf, firma, firmaTlf);
		}

		this.hide();
	}

	private void cancelAction() {
		this.hide();
	}
	
	// ------------------------------------------------------------------------
	// Listeners
	
	private void selectedCompanyChanged(boolean checked) {
		if (checked) {
			txfFirma.setDisable(!checked);
			txfFirmaTlf.setDisable(!checked);
		} else {
			txfFirma.setDisable(!checked);
			txfFirmaTlf.setDisable(!checked);
			txfFirma.clear();
			txfFirmaTlf.clear();
		}
	}

	// ------------------------------------------------------------------------
	// Controls

	private void initControls() {
		if(participant != null) {
			txfFornavn.setText(participant.getFornavn());
			txfEfternavn.setText(participant.getEfternavn());
			txfAddresse.setText(participant.getAddresse());
			txfBy.setText(participant.getBy());
			txfLand.setText(participant.getLand());
			txfTlf.setText(participant.getTlf());			
			if(participant.getFirmaNavn().length() > 0) {
				chbCompany.setSelected(true);
				txfFirma.setText(participant.getFirmaNavn());
				txfFirmaTlf.setText(participant.getFirmaTlf());
			}	
		} 
	}
}
