package personAdministration;

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
        stage.setTitle("ListView Demo3");
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

    private final Controller controller = new Controller();

    private void initContent(GridPane pane) {

        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 3);

        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0, 1);

        txfName = new TextField();
        pane.add(txfName, 1, 0, 2, 1);

        txfTitle = new TextField();
        pane.add(txfTitle, 1, 0, 2, 4);

        // add a listView to the pane(at col=1, row=0)
        lvwPersons = new ListView<>();
        pane.add(lvwPersons, 1, 3, 1, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(controller.persons);

        ChangeListener<Person> listener = (ov, oldPerson, newPerson) -> this.controller.selectionChanged();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwPersons.getSelectionModel().clearSelection();

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 6, 0);

        chkSenior = new CheckBox();
        pane.add(chkSenior, 7, 1);

        Label lblSenior = new Label("Senior:");
        pane.add(lblSenior, 6, 1);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.controller.addAction());

        Button btnDelete = new Button("Delete");
        pane.add(btnDelete, 6, 3);

        // connect a method to the button
        btnDelete.setOnAction(event -> this.controller.deleteAction());

    }

    /**
     * This class controls access to the model in this application. In this case,
     * the model is a list of Person object.
     */
    private class Controller {
        private ArrayList<Person> persons;

        public Controller() {
            initPersons();
        }

        // -------------------------------------------------------------------------
        // Button actions

        private void addAction() {
            String name = txfName.getText().trim();
            String title = txfTitle.getText().trim();
            if (name.length() > 0 && title.length() > 0) {
                Person p = new Person(txfName.getText().trim(), txfTitle.getText().trim(), chkSenior.isSelected());
                persons.add(p);
                lvwPersons.getItems().setAll(persons);
            }
            if (name.length() == 0 || title.length() == 0) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Mangel af input");
                alert.setHeaderText("Du har ikke intastet navn eller titel");
                alert.setContentText("Du skal derfor intaste et navn og titel");
                alert.show();
            }
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
