package guifx;

import java.time.LocalDate;

import application.model.Konference;
import application.model.Udflugt;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class UdflugtWindow extends Stage {
	private Udflugt udflugt;
	private Konference konference;
	
	public UdflugtWindow(String title, Udflugt udflugt, Konference konference) {
		this.udflugt = udflugt;
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
	
	public UdflugtWindow(String title, Konference konference) {
		this(title, null, konference);
	}
	
	// ----------------------------------------------------------------
	
	private TextField txfName, txfDescr, txfPrice, txfTime;
	private DatePicker dpDate;
	private CheckBox chbLunch;
	private Label lbName, lbDescr, lbPrice, lbTime, lbDate, lbLunch, lbError;
	
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
		pane.add(lbPrice, 0, 2);
		
		txfPrice = new TextField();
		pane.add(txfPrice, 0, 3);
		
		lbDescr = new Label("Description");
		pane.add(lbDescr, 0, 4);
		
		txfDescr = new TextField();
		pane.add(txfDescr, 0, 5);
		
		lbDate = new Label("Date");
		pane.add(lbDate, 1, 0);
		
		dpDate = new DatePicker();
		pane.add(dpDate, 1, 1);
		dpDate.setValue(konference.getStartDato());
		
		lbTime = new Label("Time");
		pane.add(lbTime, 1, 2);
		
		txfTime = new TextField();
		pane.add(txfTime, 1, 3);
		
		lbLunch = new Label("Lunch?");
		pane.add(lbLunch, 1, 4);
		
		chbLunch = new CheckBox();
		pane.add(chbLunch, 1, 5);
		
		lbError = new Label();
		pane.add(lbError, 0, 7, 2, 1);
		lbError.setStyle("-fx-text-fill: red");
		
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
		
		this.initControls();
	}
	
	// ------------------------------------------------------------------
	
	private void initControls() {
		if (udflugt != null) {
			txfPrice.setText("" + udflugt.getPris());
			txfName.setText(udflugt.getNavn());
			txfDescr.setText(udflugt.getBeskrivelse());
			txfTime.setText(udflugt.getTid());
			chbLunch.setSelected(udflugt.getFrokost());
			dpDate.setValue(udflugt.getDate());
		}
	}
	
	// ------------------------------------------------------------------
	
	public void okAction() {
		String name = txfName.getText().trim();
		String descr = txfDescr.getText().trim();
		String time = txfTime.getText().trim();		
		LocalDate date = dpDate.getValue();
		boolean lunch = chbLunch.isSelected();

		if (name.length() == 0 || descr.length() == 0 || time.length() == 0 || date == null) {
			lbError.setText("Empty fields detected, please fill out all fields");
			return;
		}
		
		if (date.isBefore(konference.getStartDato()) || date.isAfter(konference.getSlutDato())) {
			lbError.setText("Date has to be between: " + konference.getStartDato() + " and " + konference.getSlutDato());
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

		if (udflugt != null) {
			Service.updateUdflugt(udflugt, name, price, descr, date, time, lunch);
		} else {
			Service.createUdflugt(konference, name, price, descr, date, time, lunch);
		}

		this.hide();
	}
	public void cancelAction() {
		this.hide();
	}

}
