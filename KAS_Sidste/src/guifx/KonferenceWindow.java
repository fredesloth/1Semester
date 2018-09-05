package guifx;

import java.time.LocalDate;
import java.util.ArrayList;
import application.model.Hotel;
import application.model.Konference;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

public class KonferenceWindow extends Stage {
	private Konference konference;

	public KonferenceWindow(String title, Konference konference) {
		this.konference = konference;
		this.initStyle(StageStyle.UTILITY);
		this.initModality(Modality.APPLICATION_MODAL);
		this.setResizable(false);

		this.setTitle(title);
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

	public KonferenceWindow(String title) {
		this(title, null);
	}

	// ---------------------------------------------------------------

	private TextField txfName, txfPrice, txfAdress;
	private DatePicker txfStartDate, txfEndDate;
	private TextArea txaDescription;
	private ListView<Hotel> lwHotels;
	private ListView<Hotel> lwHotelsToAdd;
	private Label lbError, lbName, lbPrice, lbAdress, lbStartDate, lbEndDate, lbDescription, lbHotels;
	private ArrayList<Hotel> hotelsToAdd = new ArrayList<>();

	private void initContent(GridPane pane) {
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setGridLinesVisible(false);

		lbName = new Label("Name");
		pane.add(lbName, 0, 0);

		txfName = new TextField();
		pane.add(txfName, 0, 1);

		lbPrice = new Label("Price");
		pane.add(lbPrice, 0, 2);

		txfPrice = new TextField();
		pane.add(txfPrice, 0, 3);

		lbAdress = new Label("Adress");
		pane.add(lbAdress, 0, 4);

		txfAdress = new TextField();
		pane.add(txfAdress, 0, 5);

		lbStartDate = new Label("Start date");
		pane.add(lbStartDate, 1, 0);

		txfStartDate = new DatePicker();
		pane.add(txfStartDate, 1, 1);

		lbEndDate = new Label("End date");
		pane.add(lbEndDate, 1, 2);

		txfEndDate = new DatePicker();
		pane.add(txfEndDate, 1, 3);

		lbDescription = new Label("Description");
		pane.add(lbDescription, 2, 0);

		txaDescription = new TextArea();
		pane.add(txaDescription, 2, 1, 1, 5);
		txaDescription.setPrefHeight(140);
		txaDescription.setPrefWidth(200);

		lbHotels = new Label("Select Hotels");
		pane.add(lbHotels, 0, 6);

		lwHotels = new ListView<Hotel>();
		pane.add(lwHotels, 0, 7, 1, 3);
		lwHotels.getItems().setAll(Service.getHoteller());
		lwHotels.setPrefHeight(100);
		lwHotels.setPrefWidth(200);

		lwHotelsToAdd = new ListView<Hotel>();
		pane.add(lwHotelsToAdd, 2, 7, 1, 3);
		lwHotelsToAdd.getItems().setAll(hotelsToAdd);
		lwHotelsToAdd.setPrefHeight(100);
		lwHotelsToAdd.setPrefWidth(200);

		lbError = new Label();
		pane.add(lbError, 0, 11, 2, 1);
		lbError.setStyle("-fx-text-fill: red");

		Button btnCancel = new Button("Cancel");
		pane.add(btnCancel, 1, 10);
		GridPane.setHalignment(btnCancel, HPos.LEFT);
		btnCancel.setMaxWidth(Double.MAX_VALUE);
		btnCancel.setOnAction(event -> this.cancelAction());

		Button btnOK = new Button("OK");
		pane.add(btnOK, 2, 10);
		GridPane.setHalignment(btnOK, HPos.RIGHT);
		btnOK.setMaxWidth(Double.MAX_VALUE);
		btnOK.setOnAction(event -> this.okAction());

		Button btnAdd = new Button("Add");
		pane.add(btnAdd, 1, 7);
		GridPane.setHalignment(btnAdd, HPos.RIGHT);
		btnAdd.setMaxWidth(Double.MAX_VALUE);
		btnAdd.setOnAction(event -> this.addAction());

		Button btnRemove = new Button("Remove");
		pane.add(btnRemove, 1, 8);
		GridPane.setHalignment(btnRemove, HPos.RIGHT);
		btnRemove.setMaxWidth(Double.MAX_VALUE);
		btnRemove.setOnAction(event -> this.removeAction());
		
		this.initControls();
	}
	
	// ------------------------------------------------------------------
	
	private void initControls() {
		if (konference != null) {
			txfPrice.setText("" + konference.getPris());
			txfName.setText(konference.getNavn());
			txfAdress.setText(konference.getAddresse());
			txaDescription.setText(konference.getBeksrivelse());
			lwHotelsToAdd.getItems().setAll(konference.getHoteller());
			
			txfStartDate.setValue(konference.getStartDato());
			txfEndDate.setValue(konference.getSlutDato());
		}
	}

	// ------------------------------------------------------------------

	private void addAction() {
		if (lwHotels.getSelectionModel().getSelectedItem() != null) {
			Hotel h = lwHotels.getSelectionModel().getSelectedItem();

			if (!lwHotelsToAdd.getItems().contains(h)) {
				lwHotelsToAdd.getItems().add(h);
			}
		}
	}
	
	private void removeAction() {
		if(lwHotelsToAdd.getSelectionModel().getSelectedItem() != null) {
			Hotel h = lwHotelsToAdd.getSelectionModel().getSelectedItem();
			lwHotelsToAdd.getItems().remove(h);
		}
	}

	private void okAction() {
		String name = txfName.getText().trim();
		String descr = txaDescription.getText().trim();
		String adress = txfAdress.getText().trim();		
		LocalDate start = txfStartDate.getValue();
		LocalDate end = txfEndDate.getValue();

		if (name.length() == 0 || descr.length() == 0 || adress.length() == 0 || start == null || end == null) {
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
		
		if (!checkDates()) {
			lbError.setText("Starting date must be before end date!");
			return;
		}
		
		for (Hotel h : lwHotelsToAdd.getItems()) {
			hotelsToAdd.add(h);
		}

		if (konference != null) {
			Service.updateKonference(konference, name, descr, adress, start, end, price, hotelsToAdd);
		} else {
			Service.createKonference(name, descr, adress, start, end, price, hotelsToAdd);
		}

		this.hide();
	}

	private void cancelAction() {
		this.hide();
	}
	
	private boolean checkDates () {
		boolean checkDates = false;
		if(this.txfStartDate.getValue().isBefore(this.txfEndDate.getValue())) {
			checkDates = true;
		}
		
		return checkDates;
	}

}
