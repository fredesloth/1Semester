package guifx;

import application.model.Deltager;
import application.model.Konference;
import application.model.Ledsager;
import application.model.Udflugt;
import application.service.Service;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

public class ExcursionPane extends GridPane {
    private ListView<Konference> lvwConference;
    private ListView<Udflugt> lvwAdventures;
    private TextArea txaParticipants;

    public ExcursionPane() {
        setPadding(new Insets(20));
        setHgap(20);
        setVgap(10);
        setGridLinesVisible(false);

        Label lblConferences = new Label("Conferences:");
        this.add(lblConferences, 0, 0);

        lvwConference = new ListView<>();
        this.add(lvwConference, 0, 1, 1, 10);
        lvwConference.setPrefWidth(200);
        lvwConference.setPrefHeight(200);
        lvwConference.getItems().setAll(Service.getKonference());
        ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> selectedParticipantChanged();
        lvwConference.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblAdventures = new Label("Adventures:");
        this.add(lblAdventures, 1, 0);

        lvwAdventures = new ListView<>();
        this.add(lvwAdventures, 1, 1, 1, 10);
        lvwAdventures.setPrefWidth(200);
        lvwAdventures.setPrefHeight(200);
        // lvwAdventures.getItems().setAll(Service.getUdflugter(konference));
        ChangeListener<Udflugt> listener2 = (ov, oldUdflugt, newUdflugt) -> selectedAdventureChanged();
        lvwAdventures.getSelectionModel().selectedItemProperty().addListener(listener2);

        Label lblParticipants = new Label("Participants:");
        this.add(lblParticipants, 2, 0);

        txaParticipants = new TextArea();
        this.add(txaParticipants, 2, 1, 1, 10);
        txaParticipants.setPrefWidth(200);
        txaParticipants.setPrefHeight(200);
        txaParticipants.setEditable(false);
        // -----------------------------------------------------------------

        if (lvwConference.getItems().size() > 0) {
            lvwConference.getSelectionModel().select(0);
        }
        if (lvwAdventures.getItems().size() > 0) {
            lvwAdventures.getSelectionModel().select(0);
        }
    }

    // -----------------------------------------------------------------

    private void selectedParticipantChanged() {
        updateControls();
    }

    private void selectedAdventureChanged() {
        updateControls();
    }

    public void updateControls() {
        StringBuilder sb = new StringBuilder();
        Konference konference = lvwConference.getSelectionModel().getSelectedItem();
        if (konference != null) {
            Udflugt udflugt = lvwAdventures.getSelectionModel().getSelectedItem();
            lvwAdventures.getItems().setAll(Service.getUdflugter(konference));

            if (udflugt != null) {

                for (Ledsager led : Service.getLedsagere(udflugt)) {
                    for (Deltager del : Service.getTilmeldinger()) {
                        sb.append(led.getNavn() + " (" + del + ")" + "\n");
                        // sb.append(led.getNavn() + "\n");

                    }

                }

            }
        }
        txaParticipants.setText(sb.toString());
    }
}
