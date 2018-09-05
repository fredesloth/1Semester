package guifx;

import java.util.ArrayList;
import java.util.Optional;

import application.model.Tilmelding;
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

public class RegistrationPane extends GridPane {
    private TextField txfName, txfAdress, txfCity, txfCountry, txfPhone, txfFirm, txfFirmPhone;
    private ListView<Deltager> lvwParticipants;
    Deltager deltager;

    public RegistrationPane() {
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
        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 11, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnRegistrate = new Button("Registrate");
        hbxButtons.getChildren().add(btnRegistrate);
        btnRegistrate.setOnAction(event -> registrateAction());

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

    private void registrateAction() {
        RegistrationWindow dia = new RegistrationWindow("Create Participant");
        dia.showAndWait();

        lvwParticipants.getItems().setAll(initAllDeltagerList());
        updateControls();

    }

    // -----------------------------------------------------------------

    private void selectedParticipantChanged() {
        updateControls();
    }

    public void updateControls() {
        Deltager deltager = lvwParticipants.getSelectionModel().getSelectedItem();
    }

}
