package opgave3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Opgave3 extends Application {

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
        // Sætter tekstfeltet til 15h
        txf1.setText("15");
        pane.add(txf1, 1, 0, 2, 1);

        // add a button to the pane (at col=1, row=1)
        Button btnUp = new Button("Up");
        pane.add(btnUp, 1, 1);
        GridPane.setMargin(btnUp, new Insets(10, 10, 0, 10));

        Button btnDown = new Button("Down");
        pane.add(btnDown, 2, 1);
        GridPane.setMargin(btnDown, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnUp.setOnAction(event -> up());

        btnDown.setOnAction(event -> down());
    }

    // -----------------------------------------------------
    // Button actions

    // Integer.parseInt gør at man veksler det fra String til int
    private void up() {
        int textFelt1 = Integer.parseInt(txf1.getText().trim());
        textFelt1++;
        txf1.setText(textFelt1 + "");
    }

    private void down() {
        int textFelt1 = Integer.parseInt(txf1.getText().trim());
        textFelt1--;
        txf1.setText(textFelt1 + "");
    }

}