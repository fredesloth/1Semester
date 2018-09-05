package guifx;

import java.util.ArrayList;
import java.util.Optional;

import application.model.Hotel;
import application.model.Konference;
import application.model.Ledsager;
import application.model.Tilmelding;
import application.model.Udflugt;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KonferencePane extends GridPane {
    private TextArea txaDetails, txaRegistrations, txaTripRegistrations, txaTripDetails;
    private ListView<Konference> lwKonferences;
    private ListView<Udflugt> lwTrips;
    private Button btnCreate, btnUpdate, btnDelete, btnCreateTrip, btnUpdateTrip, btnDeleteTrip, btnUpdateRegistrations;
    private Label lbTrips, lbKonferences, lbDetails, lbRegistrations, lbTripRegistrations;

    public KonferencePane() {
        setPadding(new Insets(20));
        setHgap(20);
        setVgap(10);
        setGridLinesVisible(false);

        lbKonferences = new Label("Konferences");
        this.add(lbKonferences, 0, 0);

        lwKonferences = new ListView<>();
        this.add(lwKonferences, 0, 1, 1, 6);
        lwKonferences.setPrefWidth(200);
        lwKonferences.setPrefHeight(200);
        lwKonferences.getItems().setAll(Service.getKonferencer());

        // Selected conference listener
        ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> selectedKonferenceChanged();
        lwKonferences.getSelectionModel().selectedItemProperty().addListener(listener);

        lbDetails = new Label("Details");
        this.add(lbDetails, 1, 0);

        txaDetails = new TextArea();
        this.add(txaDetails, 1, 1, 1, 6);
        txaDetails.setPrefWidth(200);
        txaDetails.setPrefHeight(200);
        txaDetails.setEditable(false);

        lbTrips = new Label("Trips");
        this.add(lbTrips, 2, 0);

        lwTrips = new ListView<>();
        this.add(lwTrips, 2, 1, 1, 3);
        lwTrips.setPrefHeight(100);
        lwTrips.setPrefWidth(200);

        // Selected Trip listener
        ChangeListener<Udflugt> tripListener = (ov, oldTrip, newTrip) -> selectedTripChanged();
        lwTrips.getSelectionModel().selectedItemProperty().addListener(tripListener);

        txaTripDetails = new TextArea();
        this.add(txaTripDetails, 2, 4, 1, 3);
        txaTripDetails.setPrefHeight(100);
        txaTripDetails.setPrefWidth(100);

        lbRegistrations = new Label("Registrations");
        this.add(lbRegistrations, 0, 7);

        txaRegistrations = new TextArea();
        this.add(txaRegistrations, 0, 8, 2, 1);
        txaRegistrations.setPrefHeight(200);
        txaRegistrations.setPrefWidth(200);
        txaRegistrations.setEditable(false);

        lbTripRegistrations = new Label("Trip Registrations");
        this.add(lbTripRegistrations, 2, 7);

        txaTripRegistrations = new TextArea();
        this.add(txaTripRegistrations, 2, 8, 2, 1);
        txaTripRegistrations.setPrefHeight(200);
        txaTripRegistrations.setPrefWidth(250);
        txaTripRegistrations.setEditable(false);

        btnCreate = new Button("Create");
        btnCreate.setOnAction(event -> createAction());
        btnCreate.setMaxWidth(Double.MAX_VALUE);
        this.add(btnCreate, 3, 1);

        btnUpdate = new Button("Update");
        btnUpdate.setOnAction(event -> updateAction());
        btnUpdate.setMaxWidth(Double.MAX_VALUE);
        this.add(btnUpdate, 3, 2);

        btnDelete = new Button("Delete");
        btnDelete.setOnAction(event -> deleteAction());
        btnDelete.setMaxWidth(Double.MAX_VALUE);
        this.add(btnDelete, 3, 3);

        btnCreateTrip = new Button("New trip");
        btnCreateTrip.setOnAction(event -> createTripAction());
        btnCreateTrip.setMaxWidth(Double.MAX_VALUE);
        btnCreateTrip.setDisable(true);
        this.add(btnCreateTrip, 3, 4);

        btnUpdateTrip = new Button("Udate trip");
        btnUpdateTrip.setOnAction(event -> updateTripAction());
        btnUpdateTrip.setMaxWidth(Double.MAX_VALUE);
        btnUpdateTrip.setDisable(true);
        this.add(btnUpdateTrip, 3, 5);

        btnDeleteTrip = new Button("Delete trip");
        btnDeleteTrip.setOnAction(event -> deleteTripAction());
        btnDeleteTrip.setMaxWidth(Double.MAX_VALUE);
        btnDeleteTrip.setDisable(true);
        this.add(btnDeleteTrip, 3, 6);

        btnUpdateRegistrations = new Button("Update");
        btnUpdateRegistrations.setOnAction(event -> updateRegistrationsAction());
        btnUpdateRegistrations.setMaxWidth(Double.MAX_VALUE);
        btnUpdateRegistrations.setDisable(true);
        // this.add(btnUpdateRegistrations, 2, 9);
    }

    // ------------------------------------------------------------------------
    // Conference actions

    public void createAction() {
        KonferenceWindow win = new KonferenceWindow("Create Konference");
        win.showAndWait();

        // Wait for modal dialog to close

        refreshControlsCreated();
    }

    public void updateAction() {
        Konference k = lwKonferences.getSelectionModel().getSelectedItem();
        if (k == null) {
            return;
        }

        KonferenceWindow win = new KonferenceWindow("Update Konference", k);
        win.showAndWait();

        // Wait for modal dialog to close

        refreshControls();
    }

    public void deleteAction() {
        Konference k = lwKonferences.getSelectionModel().getSelectedItem();
        if (k == null) {
            return;
        }

        if (k.getTilmeldinger().size() == 0) {
            Stage owner = (Stage) getScene().getWindow();
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete Conference");
            alert.initOwner(owner);
            alert.setHeaderText("Are you sure?");

            // Wait for Modal to close

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Service.removeKonference(k);
                lwKonferences.getItems().setAll(Service.getKonferencer());
                updateControls();
            }
        } else {
            Stage owner = (Stage) getScene().getWindow();
            Alert alert = new Alert(AlertType.ERROR, "Delete Conference");
            alert.setHeaderText("Can't delete a conference that has participants");
            alert.initOwner(owner);
            alert.showAndWait();
        }
    }

    public void updateRegistrationsAction() {
        refreshControls();
    }

    // -------------------------------------------------------------------------
    // Trip action

    public void createTripAction() {
        Konference k = lwKonferences.getSelectionModel().getSelectedItem();
        UdflugtWindow win = new UdflugtWindow("Create Trip", k);
        win.showAndWait();

        // Wait for modal dialog to close

        refreshControls();
    }

    public void updateTripAction() {
        Konference k = lwKonferences.getSelectionModel().getSelectedItem();
        Udflugt u = lwTrips.getSelectionModel().getSelectedItem();
        if (u == null) {
            return;
        }

        UdflugtWindow win = new UdflugtWindow("Update Trip", u, k);
        win.showAndWait();

        // Wait for modal dialog to close

        refreshControls();
    }

    private boolean checkLedsagere(Udflugt udflugt, Konference konference) {
        boolean hasLedsagere = false;
        ArrayList<Ledsager> ledsagere = new ArrayList<>();

        for (Tilmelding t : Service.getKonferenceTilmeldinger(konference)) {
            ledsagere.add(t.getLedsager());
        }

        for (Ledsager l : ledsagere) {
            ArrayList<Udflugt> udflugter = new ArrayList<>(l.getUdflugter());
            for (Udflugt u : udflugter) {
                if (u == udflugt) {
                    hasLedsagere = true;
                }
            }
        }

        return hasLedsagere;
    }

    public void deleteTripAction() {
        Konference k = lwKonferences.getSelectionModel().getSelectedItem();
        Udflugt u = lwTrips.getSelectionModel().getSelectedItem();
        if (u == null) {
            return;
        }

        if (!checkLedsagere(u, k)) {
            Stage owner = (Stage) getScene().getWindow();
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Delete Trip");
            alert.initOwner(owner);
            alert.setHeaderText("Are you sure?");

            // Wait for Modal to close

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Service.deleteKonferenceUdflugt(u, k);
                lwKonferences.getItems().setAll(Service.getKonferencer());
                updateControls();
            }
        } else {
            Stage owner = (Stage) getScene().getWindow();
            Alert alert = new Alert(AlertType.ERROR, "Delete Trip");
            alert.setHeaderText("Can't delete a trip that has participants");
            alert.initOwner(owner);
            alert.showAndWait();
        }
    }

    // -------------------------------------------------------------------------

    private void selectedKonferenceChanged() {
        txaRegistrations.clear();
        txaTripRegistrations.clear();
        txaTripDetails.clear();
        updateControls();
        if (lwKonferences.getSelectionModel().getSelectedItem() != null) {
            btnUpdateRegistrations.setDisable(false);
            this.btnCreateTrip.setDisable(false);
        }
    }

    private void selectedTripChanged() {
        if (lwTrips.getSelectionModel().getSelectedItem() != null
                && lwKonferences.getSelectionModel().getSelectedItem() != null) {
            Konference k = lwKonferences.getSelectionModel().getSelectedItem();
            Udflugt udflugt = lwTrips.getSelectionModel().getSelectedItem();
            StringBuilder sb = new StringBuilder();

            for (Tilmelding t : Service.getKonferenceTilmeldinger(k)) {
                if (t.getLedsager() != null) {
                    ArrayList<Udflugt> udflugter = new ArrayList<>(Service.getLedsagerUdflugter(t.getLedsager()));
                    for (Udflugt u : udflugter) {
                        if (u == udflugt) {
                            sb.append(
                                    "" + t.getLedsager() + ", " + t.getDeltager() + "(" + t.getDeltagerNr() + ")\n\n");
                        }
                    }
                }
            }
            txaTripRegistrations.setText("" + sb);
            txaTripDetails.setText(
                    "Price:  " + udflugt.getPris() + "DKK" + "\nDate: " + udflugt.getDate() + ", " + udflugt.getTid()
                            + "\nDescription: " + udflugt.getBeskrivelse() + "\nLunch: " + udflugt.getFrokost());
            this.btnUpdateTrip.setDisable(false);
            this.btnDeleteTrip.setDisable(false);
        } else {
            this.btnUpdateTrip.setDisable(true);
            this.btnDeleteTrip.setDisable(true);
        }
    }

    private void refreshControls() {
        int selectedIndex = lwKonferences.getSelectionModel().getSelectedIndex();
        lwKonferences.getItems().setAll(Service.getKonferencer());
        lwKonferences.getSelectionModel().select(selectedIndex);
    }

    private void refreshControlsCreated() {
        lwKonferences.getItems().setAll(Service.getKonferencer());
        int index = lwKonferences.getItems().size() - 1;
        lwKonferences.getSelectionModel().select(index);
    }

    public void updateControls() {
        Konference k = lwKonferences.getSelectionModel().getSelectedItem();
        lwTrips.getSelectionModel().clearSelection();
        if (k != null) {
            StringBuilder sb = new StringBuilder();
            for (Hotel h : k.getHoteller()) {
                sb.append(" " + h.getNavn() + "\n");
            }
            txaDetails.setText("Adress:\n  " + k.getAddresse() + "\nStart date:\n  " + k.getStartDato()
                    + "\nEnd date:\n  " + k.getSlutDato() + "\nPrice:\n  " + k.getPris() + "DKK" + "\nDescription:\n  "
                    + k.getBeksrivelse() + "\nHotels:\n" + sb);
            lwTrips.getItems().setAll(k.getUdflugter());

            if (k.getTilmeldinger().size() > 0) {
                StringBuilder sb2 = new StringBuilder();
                for (Tilmelding t : k.getTilmeldinger()) {
                    Ledsager l = t.getLedsager();
                    if (l != null) {
                        sb2.append(t.getDeltager() + " (" + t.getDeltagerNr() + ")\n" + " Companion: " + t.getLedsager()
                                + "\n" + " Companion trips: " + t.getLedsager().getUdflugter() + "\n"
                                + " Arrival date: " + t.getAnkomstDato() + "\n" + " Departure date: "
                                + t.getAfrejseDato() + "\n" + " Lecturer: " + t.isForedragsholder() + "\n" + " Phone: "
                                + t.getDeltager().getTlf() + "\n" + " Company: " + t.getDeltager().getFirmaNavn() + "\n"
                                + "\n");
                    } else {
                        sb2.append(t.getDeltager() + " (" + t.getDeltagerNr() + ")\n" + " Arrival date: "
                                + t.getAnkomstDato() + "\n" + " Departure date: " + t.getAfrejseDato() + "\n"
                                + " Lecturer: " + t.isForedragsholder() + "\n" + " Phone: " + t.getDeltager().getTlf()
                                + "\n" + " Company: " + t.getDeltager().getFirmaNavn() + "\n" + "\n");
                    }
                }
                this.txaRegistrations.setText("" + sb2);
            }
        } else {
            txaDetails.clear();
            lwTrips.getItems().clear();
            this.btnCreateTrip.setDisable(true);
            this.btnUpdateTrip.setDisable(true);
            this.btnDeleteTrip.setDisable(true);
        }
    }
}
