package opgave2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opgave2 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Opgave 2");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private TextField txf1;
    private TextField txf2;

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

        // add a text field to the pane
        // (at col=1, row=0, extending 2 columns and 1 row)
        txf1 = new TextField();
        pane.add(txf1, 1, 0, 2, 1);

        txf2 = new TextField();
        pane.add(txf2, 1, 0, 2, 5);

        // add a button to the pane (at col=1, row=1)
        Button btnSwap = new Button("Swap");
        pane.add(btnSwap, 1, 4);
        GridPane.setMargin(btnSwap, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnSwap.setOnAction(event -> swap());
    }

    // -----------------------------------------------------
    // Button actions

    private void swap() {
        String textFelt1 = txf1.getText().trim();
        String textFelt2 = txf2.getText().trim();
        txf1.setText(textFelt2);
        txf2.setText(textFelt1);
    }

}