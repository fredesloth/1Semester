package personAdministrationWindow;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;

public class PersonApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Person liste");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    // -------------------------------------------------------------------------
    private CheckBox chkSenior;
    private TextField txfName;
    private TextField txfTitle;
    private ListView<Person> lvwPersons;
    private PersonWindow newPersonWindwow;

    private final Controller controller = new Controller();

    private void initContent(GridPane pane) {

        // add a listView to the pane(at col=1, row=0)
        lvwPersons = new ListView<>();
        pane.add(lvwPersons, 1, 3, 1, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(controller.persons);

        ChangeListener<Person> listener = (ov, oldPerson, newPerson) -> this.controller.selectionChanged();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwPersons.getSelectionModel().clearSelection();

        Button btnUpdate = new Button("Update");
        pane.add(btnUpdate, 6, 0);

        // connect a method to the button
        btnUpdate.setOnAction(event -> this.controller.newAction());

        Button btnDelete = new Button("Delete");
        pane.add(btnDelete, 6, 3);

        // connect a method to the button
        btnDelete.setOnAction(event -> this.controller.deleteAction());

    }

    /**
     * This class controls access to the model in this application. In this case,
     * the model is a list of Person object.
     */
    public class Controller {
        private ArrayList<Person> persons;

        public Controller() {
            initPersons();
        }

        // -------------------------------------------------------------------------
        // Button actions

        private void newAction() {
            newPersonWindwow.showAndWait();

        }

        private void deleteAction() {
            int index = lvwPersons.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                persons.remove(index);
                txfName.clear();
                lvwPersons.getItems().setAll(persons);
            }
        }

        private void initPersons() {
            persons = new ArrayList<>();
            persons.add(new Person("Jens", "Bygger", false));
            persons.add(new Person("Peter", "Murer", true));
            persons.add(new Person("Lars", "Advokat", false));

        }

        // -------------------------------------------------------------------------
        // Selectionchange actions

        private void selectionChanged() {
            Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
            if (newPerson != null) {
                txfName.setText(newPerson.getName());
            } else {
                txfName.clear();
            }
        }
    }
}
