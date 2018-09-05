package personAdministrationWindow;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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

public class PersonWindow extends Stage {
    public PersonWindow(String title, Stage owner) {
        initOwner(owner);
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setMinHeight(100);
        setMinWidth(200);
        setResizable(false);

        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    // ------------------------------------------------------------------------------------------------
    private CheckBox chkSenior;
    private TextField txfName;
    private TextField txfTitle;
    private ListView<Person> lvwPersons;

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

        lvwPersons.getItems().setAll(controller.persons);

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 6, 0);

        chkSenior = new CheckBox();
        pane.add(chkSenior, 7, 1);

        Label lblSenior = new Label("Senior:");
        pane.add(lblSenior, 6, 1);

        chkSenior = new CheckBox();
        pane.add(chkSenior, 7, 1);

    }

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

    private void selectionChanged() {
        Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
        if (newPerson != null) {
            txfName.setText(newPerson.getName());
        } else {
            txfName.clear();
        }
    }

}
