package yatzy;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private String[] butlbl = { "1-s", "2-s", "3-s", "4-s", "5-s", "6-s", "One pair", "Two pair", "Three same",
            "Four same", "Full house", "Small straight", "Large straight", "Chance", "Yatzy" };
    private Button[] buttonArray = new Button[butlbl.length];
    private TextField[] txfResults = new TextField[butlbl.length];
    private int totalInt = 0;
    private int sumInt;
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

        this.chbHolds = new CheckBox[yatzy.getValues().length];
        this.txfValues = new TextField[yatzy.getValues().length];
        for (int i = 0; i < yatzy.getValues().length; i++) {
            txfValues[i] = new TextField();
            chbHolds[i] = new CheckBox();
            txfValues[i].setPrefHeight(80);
            txfValues[i].setPrefWidth(80);
            chbHolds[i].setText("Hold");
            dicePane.add(txfValues[i], i, 1);
            dicePane.add(chbHolds[i], i, 2);

        }

        btnRoll = new Button("Roll");
        dicePane.add(btnRoll, 2, 3);
        btnRoll.setOnAction(event -> rollAction());

        lblRolled = new Label("You have rolled: ");
        dicePane.add(lblRolled, 3, 3);

        // private void getThrownCount(){
        // if (yatzy.getThrowCount() >= 3) {
        //
        // }
        // }

        // TODO: initialize txfValues, chbHolds, btnRoll and lblRolled

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        scorePane.setGridLinesVisible(false);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");

        Label lblSumOther = new Label("Sum:");
        scorePane.add(lblSumOther, 3, 2);
        TextField txfSumOther = new TextField("0");
        scorePane.add(txfSumOther, 3, 3);

        Label lblTotal = new Label("Total:");
        scorePane.add(lblTotal, 3, 4);
        txfTotal = new TextField("0");
        scorePane.add(this.txfTotal, 3, 5);

        Label lblSumSame = new Label("Sum:");
        scorePane.add(lblSumSame, 3, 11);
        TextField txfSumSame = new TextField("0");
        scorePane.add(txfSumSame, 3, 12);

        Label lblBonus = new Label("Bonus:");
        scorePane.add(lblBonus, 3, 13);
        TextField txfBonus = new TextField("0");
        scorePane.add(txfBonus, 3, 14);
        // TODO: Initialize labels for results, txfResults,
        // labels and text fields for sums, bonus and total.

        for (int i = 0; i < butlbl.length; i++) {
            Button bk = new Button(butlbl[i]);
            // scorePane.add(buttonArray[i], 1, i); skal slettes
            bk.setMinWidth(80.0);
            buttonArray[i] = bk;
            // bk.setMinWidth(80.0); skal slettes
            scorePane.add(buttonArray[i], 0, i);
            TextField td = new TextField();
            txfResults[i] = td;
            td.setEditable(false);
            scorePane.add(txfResults[i], 2, i);

        }

        for (int i = 0; i < txfResults.length; i++) {
            int b = i;
            buttonArray[i].setOnAction(event -> saveAction(b));
        }
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

    // Hint: Create small helper methods to be used in the action method.

    // -------------------------------------------------------------------------

    // TODO: Create a method for mouse click on one of the text fields in
    // txfResults.

    private void getPossible() {
        int[] results = yatzy.getPossibleResults();

        for (int i = 0; i < results.length; i++) {
            txfResults[i].setText("" + results[i]);

        }
    }

    private void saveAction(int button) {
        int[] possible = yatzy.getPossibleResults();
        int score = possible[button];
        txfResults[button].setText("" + score);
        this.totalInt += score;
        this.txfTotal.setText(Integer.toString(this.totalInt));
        if (button < 7) {
            this.sumInt += score;
            if (this.sumInt > 62) {
                this.bonus = 50;
                this.totalInt += 50;
            }
            this.txfBonus.setText(Integer.toString(this.bonus));
        }
        this.txfSumOther.setText(Integer.toString(this.sumInt));

        buttonArray[button].setDisable(true);
        this.btnRoll.setDisable(false);
        yatzy.resetThrowCount();
        for (int i = 0; i < chbHolds.length; i++) {
            chbHolds[i].setSelected(false);
        }

        this.allCheck = true;
        for (int i = 0; i < this.buttonArray.length; i++) {
            if (this.buttonArray[i].isDisable() == false) {
                this.allCheck = false;
            }
        }

        if (allCheck == true) {
            Alert print = new Alert(Alert.AlertType.INFORMATION);
            print.setContentText("GameOver! Du har " + Integer.toString(this.totalInt) + "points");
            print.show();

        }
    }

    // Hint: Create small helper methods to be used in the mouse click method.

}
