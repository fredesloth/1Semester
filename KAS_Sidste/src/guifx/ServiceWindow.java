package guifx;

import application.model.Hotel;
import application.model.Tillæg;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ServiceWindow extends Stage {
	private Hotel hotel;
	private Tillæg service;
	
	public ServiceWindow(String title, Tillæg service, Hotel hotel) {
		this.hotel = hotel;
		this.service = service;
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}
	
	public ServiceWindow(String title, Hotel hotel) {
		this(title, null, hotel);
	}
	
	// ----------------------------------------------------------------
	
	private Label lbName, lbPrice, lbError;
	private TextField txfName, txfPrice;
	
	public void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);
		
		lbName = new Label("Name");
		pane.add(lbName, 0, 0);
		
		txfName = new TextField();
		pane.add(txfName, 0, 1);
		
		lbPrice = new Label("Price");
		pane.add(lbPrice, 1, 0);
		
		txfPrice = new TextField();
		pane.add(txfPrice, 1, 1);
		
		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 2);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setMaxWidth(Double.MAX_VALUE);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 1, 2);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setMaxWidth(Double.MAX_VALUE);
		btnOK.setOnAction(event -> this.okAction());
		
		lbError = new Label();
		pane.add(lbError, 0, 5, 2, 1);
		lbError.setStyle("-fx-text-fill: red");
		
		this.initControls();
	}
	
	// ------------------------------------------------------------------
	// Controls
	
	private void initControls() {
		if (service != null) {
			txfName.setText(service.getNavn());
			txfPrice.setText("" + service.getPris());
		}
	}

	// ------------------------------------------------------------------
	// Actions

	public void okAction() {
		String name = txfName.getText().trim();

		if (name.length() == 0) {
			lbError.setText("Empty fields detected, please fill out all fields");
			return;
		}

		double price = -1;
		try {
			price = Double.parseDouble(txfPrice.getText().trim());
		} catch (NumberFormatException ex) {
			// do nothing
		}
		if (price < 0) {
			lbError.setText("Price is not a positive number");
			return;
		}

		if (service != null) {
			Service.updateHotelTillæg(service, name, price);
		} else {
			Service.createHotelTillæg(hotel, name, price);
		}

		this.hide();
	}
	public void cancelAction() {
		this.hide();
	}

}
