package guifx;

import application.model.Konference;
import application.model.Tilmelding;
import application.model.Deltager;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RegistrationWindow extends Stage {
    private Tilmelding tilmelding;
    private Deltager deltager;
    private Konference konference;

    public RegistrationWindow(String title, Konference konference) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        this.konference = konference;

        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    public RegistrationWindow(String title) {
        this(title, null);
    }
    // -------------------------------------------------------------------------

    private ListView<Konference> lvwConference;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblConferences = new Label("Conferences");
        pane.add(lblConferences, 0, 0);

        lvwConference = new ListView<>();
        pane.add(lvwConference, 0, 1, 1, 10);
        lvwConference.setPrefWidth(200);
        lvwConference.setPrefHeight(200);
        lvwConference.getItems().setAll(Service.getKonference());
        ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> selectedParticipantChanged();
        lvwConference.getSelectionModel().selectedItemProperty().addListener(listener);

    }
    // -------------------------------------------------------------------------

    private void selectedParticipantChanged() {
        updateControls();
    }

    public void updateControls() {
        Konference konference = lvwConference.getSelectionModel().getSelectedItem();
    }
}
