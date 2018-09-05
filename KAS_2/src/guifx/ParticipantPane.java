package guifx;

import java.util.ArrayList;
import java.util.Optional;

import application.model.Deltager;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ParticipantPane extends GridPane {
    private TextField txfName, txfAdress, txfCity, txfCountry, txfPhone, txfFirm, txfFirmPhone;
    private ListView<Deltager> lvwParticipants;
    Deltager deltager;

    public ParticipantPane() {
        setPadding(new Insets(20));
        setHgap(20);
        setVgap(10);
        setGridLinesVisible(false);

        Label lblParticipants = new Label("Participants:");
        this.add(lblParticipants, 0, 0);

        lvwParticipants = new ListView<>();
        this.add(lvwParticipants, 0, 1, 1, 10);
        lvwParticipants.setPrefWidth(200);
        lvwParticipants.setPrefHeight(200);
        lvwParticipants.getItems().setAll(Service.getTilmeldinger());
        ChangeListener<Deltager> listener = (ov, oldDeltager, newDeltager) -> selectedParticipantChanged();
        lvwParticipants.getSelectionModel().selectedItemProperty().addListener(listener);

        // -----------------------------------------------------------------
        Label lblName = new Label("Name:");
        this.add(lblName, 1, 0);

        txfName = new TextField();
        this.add(txfName, 1, 1);
        txfName.setEditable(false);

        // -----------------------------------------------------------------
        Label lblAdress = new Label("Adress:");
        this.add(lblAdress, 1, 2);

        txfAdress = new TextField();
        this.add(txfAdress, 1, 3);
        txfAdress.setEditable(false);

        // -----------------------------------------------------------------
        Label lblCity = new Label("City:");
        this.add(lblCity, 1, 4);

        txfCity = new TextField();
        this.add(txfCity, 1, 5);
        txfCity.setEditable(false);

        // -----------------------------------------------------------------
        Label lblCountry = new Label("Country:");
        this.add(lblCountry, 1, 6);

        txfCountry = new TextField();
        this.add(txfCountry, 1, 7);
        txfCountry.setEditable(false);

        // -----------------------------------------------------------------
        Label lblPhone = new Label("Phone:");
        this.add(lblPhone, 1, 8);

        txfPhone = new TextField();
        this.add(txfPhone, 1, 9);
        txfPhone.setEditable(false);

        // -----------------------------------------------------------------
        Label lblFirm = new Label("Firm:");
        this.add(lblFirm, 2, 0);

        txfFirm = new TextField();
        this.add(txfFirm, 2, 1);
        txfFirm.setEditable(false);

        // -----------------------------------------------------------------
        Label lblFirmPhone = new Label("Firm phone:");
        this.add(lblFirmPhone, 2, 2);

        txfFirmPhone = new TextField();
        this.add(txfFirmPhone, 2, 3);
        txfFirmPhone.setEditable(false);

        // -----------------------------------------------------------------
        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 11, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Create");
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> createAction());

        Button btnUpdate = new Button("Update");
        hbxButtons.getChildren().add(btnUpdate);
        btnUpdate.setOnAction(event -> updateAction());

        Button btnDelete = new Button("Delete");
        hbxButtons.getChildren().add(btnDelete);
        btnDelete.setOnAction(event -> deleteAction());

        if (lvwParticipants.getItems().size() > 0) {
            lvwParticipants.getSelectionModel().select(0);
        }
    }

    private ArrayList<Deltager> initAllDeltagerList() {
        ArrayList<Deltager> list = new ArrayList<>();
        for (Deltager delt : Service.getTilmeldinger()) {
            list.add(delt);
        }
        return list;
    }

    // -----------------------------------------------------------------

    private void createAction() {
        ParticipantWindow dia = new ParticipantWindow("Create Participant");
        dia.showAndWait();

        lvwParticipants.getItems().setAll(initAllDeltagerList());
        updateControls();
    }

    private void updateAction() {
        Deltager deltager = lvwParticipants.getSelectionModel().getSelectedItem();
        if (deltager == null) {
            return;
        }

        ParticipantWindow dia = new ParticipantWindow("Update deltager", deltager);
        dia.showAndWait();

        int selectIndex = lvwParticipants.getSelectionModel().getSelectedIndex();
        lvwParticipants.getItems().setAll(initAllDeltagerList());
        lvwParticipants.getSelectionModel().select(selectIndex);
    }

    private void deleteAction() {
        Deltager deltager = lvwParticipants.getSelectionModel().getSelectedItem();
        if (deltager == null) {
            return;
        }

        Stage owner = (Stage) getScene().getWindow();
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Delete Participant");
        alert.initOwner(owner);
        alert.setHeaderText("Are you sure you want to delete " + deltager.getNavn() + "?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Service.deleteDeltager(deltager);
            lvwParticipants.getItems().setAll(initAllDeltagerList());
            updateControls();
        }

    }

    // -----------------------------------------------------------------

    private void selectedParticipantChanged() {
        updateControls();
    }

    public void updateControls() {
        Deltager deltager = lvwParticipants.getSelectionModel().getSelectedItem();
        if (deltager != null) {
            txfName.setText(deltager.getNavn());
            txfAdress.setText(deltager.getAdresse());
            txfCity.setText(deltager.getBy());
            txfCountry.setText(deltager.getLand());
            txfPhone.setText(deltager.getTlf());
            txfFirm.setText(deltager.getFirmaNavn());
            txfFirmPhone.setText(deltager.getFirmaTlf());

        } else {
            txfName.clear();
            txfAdress.clear();
            txfCity.clear();
            txfCountry.clear();
            txfPhone.clear();
            txfFirm.clear();
            txfFirmPhone.clear();
        }
    }

}
