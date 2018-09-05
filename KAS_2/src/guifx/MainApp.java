package guifx;

import application.service.Service;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() {
        Service.initStorage();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Architecture Demo");
        BorderPane pane = new BorderPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        // Laver hotel tab
        Tab tabParticipant = new Tab("Participant management");
        tabPane.getTabs().add(tabParticipant);

        ParticipantPane participantPane = new ParticipantPane();
        tabParticipant.setContent(participantPane);
        tabParticipant.setOnSelectionChanged(event -> participantPane.updateControls());

        Tab tabExcursion = new Tab("Excursion overview");
        tabPane.getTabs().add(tabExcursion);

        ExcursionPane excursionPane = new ExcursionPane();
        tabExcursion.setContent(excursionPane);
        tabExcursion.setOnSelectionChanged(event -> excursionPane.updateControls());

    }

}
