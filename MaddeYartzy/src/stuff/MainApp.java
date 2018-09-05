package stuff;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    // The Yatzy game object
    private Yatzy yatzy = new Yatzy();
    // Shows the face values of the 5 dice.
    private TextField[] txfValues;
    // Shows the hold status of the 5 dice.
    private CheckBox[] chbHolds;

    private TextField txfSumSame, txfBonus, txfSumOther, txfTotal;
    private Label lblRolled;
    private Button btnRoll;
    private String[] butLbl = { "1", "2", "3", "4", "5", "6", "1P", "2P", "3Same", "4Same", "FH ", "SS", "LS", "C",
            "Y" };
    private Button[] butArray = new Button[butLbl.length];
    private TextField totalTF;
    private TextField sumTF;
    private TextField[] txfResults = new TextField[butLbl.length];
    private TextField[] txfResultTest = new TextField[butLbl.length];
    private int totalint = 0;
    private int sumint;
    private int bonus;
    private boolean allCheck = false;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        GridPane dicePane = new GridPane();
        pane.add(dicePane, 0, 0);
        dicePane.setGridLinesVisible(false);
        dicePane.setPadding(new Insets(10));
        dicePane.setHgap(10);
        dicePane.setVgap(10);
        dicePane.setStyle("-fx-border-color: black");

        // HBox box1 = new Hbox(yatzy.getValues().length-1]);
        this.txfValues = new TextField[yatzy.getValues().length];
        this.chbHolds = new CheckBox[yatzy.getValues().length];
        for (int i = 0; i < txfValues.length; i++) {
            txfValues[i] = new TextField();
            txfValues[i].setPrefSize(80.0, 80.0);
            chbHolds[i] = new CheckBox();
            chbHolds[i].setText("Hold");
            dicePane.add(txfValues[i], i, 1);
            dicePane.add(chbHolds[i], i, 2);

        }

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");

        btnRoll = new Button("ROLL!");
        dicePane.add(btnRoll, 3, 3);
        btnRoll.setOnAction(event -> rollAction());

        for (int i = 0; i < butLbl.length; i++) {
            Button bk = new Button(butLbl[i]);
            butArray[i] = bk;
            bk.setMinWidth(80.0);
            scorePane.add(butArray[i], 1, i);
            TextField td = new TextField("0");
            txfResults[i] = td;
            td.setEditable(false);
            scorePane.add(txfResults[i], 2, i);
            TextField rt = new TextField("0"); // Made
            txfResultTest[i] = rt; // Made
            rt.setEditable(false); // Made
            scorePane.add(txfResultTest[i], 3, i); // Made

        }

        sumTF = new TextField("0");
        scorePane.add(sumTF, 6, 4);

        txfBonus = new TextField("0");
        scorePane.add(this.txfBonus, 6, 5);

        totalTF = new TextField("0");
        scorePane.add(this.totalTF, 6, 6);

        for (int i = 0; i < txfResultTest.length; i++) {
            int b = i;
            butArray[i].setOnAction(event -> saveAction(b));
        }

        // TODO: Initialize labels for results, txfResults,
        // labels and text fields for sums, bonus and total.
    }

    // -------------------------------------------------------------------------

    // TODO: Create a method for btnRoll's action.
    private void rollAction() {
        boolean[] holds = new boolean[this.chbHolds.length];

        for (int i = 0; i < holds.length; i++) {
            if (this.chbHolds[i].isSelected()) {
                holds[i] = true;
            } else {
                holds[i] = false;
            }
        }
        yatzy.throwDice(holds);
        int[] rolls = yatzy.getValues();

        for (int i = 0; i < rolls.length; i++) {
            this.txfValues[i].setText("" + rolls[i]);
        }

        if (yatzy.getThrowCount() >= 3) {
            btnRoll.setDisable(true);
        }

        getPossible();

    }

    // -------------------------------------------------------------------------

    private void getPossible() {
        int[] results = yatzy.getPossibleResults();

        for (int i = 0; i < results.length; i++) {
            txfResultTest[i].setText("" + results[i]);
        }

    }

    /**
     * private void b1Action() { int score = yatzy.howManyOfFace(1);
     * txfResults[0].setText(""+ score); butArray[0].setDisable(true); this.sumint
     * += score; this.totalint += score; this.sum.setText("" + this.sumint); }
     */

    private void saveAction(int button) {
        int[] possible = yatzy.getPossibleResults();
        int score = possible[button];
        txfResults[button].setText("" + score);
        this.totalint += score;
        this.totalTF.setText(Integer.toString(this.totalint));

        if (button < 7) {
            this.sumint += score;
            if (this.sumint > 62) {
                this.bonus = 50;
                this.totalint += 50;
            }
            this.txfBonus.setText(Integer.toString(this.bonus));
        }
        this.sumTF.setText(Integer.toString(this.sumint));

        butArray[button].setDisable(true);
        this.btnRoll.setDisable(false);
        yatzy.resetThrowCount();
        for (int i = 0; i < chbHolds.length; i++) {
            chbHolds[i].setSelected(false);
        }

        this.allCheck = true;
        for (int i = 0; i < this.butArray.length; i++) {
            if (this.butArray[i].isDisable() == false) {
                this.allCheck = false;
            }
        }

        if (allCheck == true) {
            Alert print = new Alert(Alert.AlertType.INFORMATION);
            print.setContentText("GameOver! Du har " + Integer.toString(this.totalint) + "points");
            print.show();

        }
    }

    // TODO: Create a method for mouse click on one of the text fields in
    // txfResults.
    // Hint: Create small helper methods to be used in the mouse click method.

}
