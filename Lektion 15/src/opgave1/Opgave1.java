package opgave1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opgave1 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Opgave 1");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private TextField txfFirstName;
    private TextField txfLastName;
    private TextField txfCombined;

    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);

        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label firstName = new Label("First name:");
        pane.add(firstName, 0, 0);

        Label lastName = new Label("Last name:");
        pane.add(lastName, 0, 1);

        Label combined = new Label("Combined");
        pane.add(combined, 0, 2);

        // add a text field to the pane
        // (at col=1, row=0, extending 2 columns and 1 row)
        txfFirstName = new TextField();
        pane.add(txfFirstName, 1, 0, 2, 1);

        txfLastName = new TextField();
        pane.add(txfLastName, 1, 0, 2, 4);

        txfCombined = new TextField();
        pane.add(txfCombined, 1, 0, 2, 6);
        txfCombined.setEditable(false);

        // add a button to the pane (at col=1, row=1)
        Button btnCombine = new Button("Combine");
        pane.add(btnCombine, 1, 4);
        GridPane.setMargin(btnCombine, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnCombine.setOnAction(event -> combine());
    }

    // -----------------------------------------------------
    // Button actions

    private void combine() {
        String firstName = txfFirstName.getText().trim();
        String lastName = txfLastName.getText().trim();
        txfCombined.setText(firstName + " " + lastName);
    }

}