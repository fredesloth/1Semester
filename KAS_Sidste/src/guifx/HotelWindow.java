package guifx;

import application.model.Hotel;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HotelWindow extends Stage {
	private Hotel hotel;

	public HotelWindow(String title, Hotel hotel) {
		this.hotel = hotel;
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public HotelWindow(String title) {
		this(title, null);
	}

	// ----------------------------------------------------------------

	private Label lbName, lbAdress, lbSingleRoom, lbDoubleRoom, lbStars, lbError;
	private TextField txfName, txfAdress, txfSingleRoom, txfDoubleRoom, txfStars;

	public void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		lbName = new Label("Name");
		pane.add(lbName, 0, 0);

		txfName = new TextField();
		pane.add(txfName, 0, 1);

		lbAdress = new Label("Adress");
		pane.add(lbAdress, 0, 2);

		txfAdress = new TextField();
		pane.add(txfAdress, 0, 3);

		lbStars = new Label("Stars");
		pane.add(lbStars, 0, 4);

		txfStars = new TextField();
		pane.add(txfStars, 0, 5);

		lbSingleRoom = new Label("Single room price");
		pane.add(lbSingleRoom, 1, 0);

		txfSingleRoom = new TextField();
		pane.add(txfSingleRoom, 1, 1);

		lbDoubleRoom = new Label("Double room price");
		pane.add(lbDoubleRoom, 1, 2);

		txfDoubleRoom = new TextField();
		pane.add(txfDoubleRoom, 1, 3);

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 0, 6);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setMaxWidth(Double.MAX_VALUE);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 1, 6);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setMaxWidth(Double.MAX_VALUE);
		btnOK.setOnAction(event -> this.okAction());
		
		lbError = new Label();
		pane.add(lbError, 0, 8, 2, 1);
		lbError.setStyle("-fx-text-fill: red");

		this.initControls();
	}

	// ------------------------------------------------------------------
	// Controls
	
	private void initControls() {
		if (hotel != null) {
			txfAdress.setText(hotel.getAddresse());
			txfName.setText(hotel.getNavn());
			txfSingleRoom.setText("" + hotel.getEnkeltVærelsePris());
			txfDoubleRoom.setText("" + hotel.getDobbeltVærelsePris());
			txfStars.setText("" + hotel.getStjerner());
		}
	}

	// ------------------------------------------------------------------
	// Actions

	public void okAction() {
		String name = txfName.getText().trim();
		String adress = txfAdress.getText().trim();

		if (name.length() == 0 || adress.length() == 0) {
			lbError.setText("Empty fields detected, please fill out all fields");
			return;
		}

		double singlePrice = -1;
		double doublePrice = -1;
		int stars = -1;
		try {
			singlePrice = Double.parseDouble(txfSingleRoom.getText().trim());
			doublePrice = Double.parseDouble(txfDoubleRoom.getText().trim());
			stars = Integer.parseInt(txfStars.getText().trim());
		} catch (NumberFormatException ex) {
			// do nothing
		}
		if (singlePrice < 0 && doublePrice < 0 && stars < 0) {
			lbError.setText("Price is not a positive number");
			return;
		}

		if (hotel != null) {
			Service.updateHotel(hotel, name, singlePrice, doublePrice, stars, adress);
		} else {
			Service.createHotel(name, singlePrice, doublePrice, stars, adress);
		}

		this.hide();
	}
	public void cancelAction() {
		this.hide();
	}
}
