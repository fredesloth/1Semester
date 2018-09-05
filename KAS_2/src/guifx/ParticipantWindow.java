package guifx;

import application.model.Deltager;
import application.service.Service;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ParticipantWindow extends Stage {
    private Deltager deltager;

    public ParticipantWindow(String title, Deltager deltager) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        this.deltager = deltager;

        setTitle(title);
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    public ParticipantWindow(String title) {
        this(title, null);

    }

    // -------------------------------------------------------------------------

    private TextField txfName, txfAdress, txfCity, txfCountry, txfPhone, txfFirm, txfFirmPhone;
    private Label lblError;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        // -----------------------------------------------------------------
        Label lblName = new Label("Name:");
        pane.add(lblName, 1, 0);

        txfName = new TextField();
        pane.add(txfName, 1, 1);

        // -----------------------------------------------------------------
        Label lblAdress = new Label("Adress:");
        pane.add(lblAdress, 1, 2);

        txfAdress = new TextField();
        pane.add(txfAdress, 1, 3);

        // -----------------------------------------------------------------
        Label lblCity = new Label("City:");
        pane.add(lblCity, 1, 4);

        txfCity = new TextField();
        pane.add(txfCity, 1, 5);

        // -----------------------------------------------------------------
        Label lblCountry = new Label("Country:");
        pane.add(lblCountry, 1, 6);

        txfCountry = new TextField();
        pane.add(txfCountry, 1, 7);

        // -----------------------------------------------------------------
        Label lblPhone = new Label("Phone:");
        pane.add(lblPhone, 2, 0);

        txfPhone = new TextField();
        pane.add(txfPhone, 2, 1);

        // -----------------------------------------------------------------
        Label lblFirm = new Label("Firm:");
        pane.add(lblFirm, 2, 2);

        txfFirm = new TextField();
        pane.add(txfFirm, 2, 3);

        // -----------------------------------------------------------------
        Label lblFirmPhone = new Label("Firm phone:");
        pane.add(lblFirmPhone, 2, 4);

        txfFirmPhone = new TextField();
        pane.add(txfFirmPhone, 2, 5);

        // -----------------------------------------------------------------
        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 1, 8);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 2, 8);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> okAction());

        lblError = new Label();
        pane.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");

        initControls();
    }

    private void initControls() {
        if (deltager != null) {
            txfName.setText(deltager.getNavn());
            txfAdress.setText(deltager.getAdresse());
            txfCity.setText(deltager.getBy());
            txfCountry.setText(deltager.getLand());
            txfPhone.setText(deltager.getTlf());
            if (deltager != null && txfFirm != null && txfFirmPhone != null) {
                txfName.setText(deltager.getNavn());
                txfAdress.setText(deltager.getAdresse());
                txfCity.setText(deltager.getBy());
                txfCountry.setText(deltager.getLand());
                txfPhone.setText(deltager.getTlf());
                txfFirm.setText(deltager.getFirmaNavn());
                txfFirmPhone.setText(deltager.getFirmaTlf());
            }
        } else {
            txfName.clear();
            txfAdress.clear();
            txfCity.clear();
            txfCountry.clear();
            txfPhone.clear();
            txfFirm.clear();
            txfFirmPhone.clear();
        }
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        hide();
    }

    private void okAction() {
        String name = txfName.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Name is empty");
            return;
        }
        String adress = txfAdress.getText().trim();
        if (adress.length() == 0) {
            lblError.setText("Adress is empty");
            return;
        }
        String city = txfCity.getText().trim();
        if (city.length() == 0) {
            lblError.setText("City is empty");
            return;
        }
        String country = txfCountry.getText().trim();
        if (country.length() == 0) {
            lblError.setText("Country is empty");
            return;
        }
        String phone = txfPhone.getText().trim();
        if (phone.length() == 0) {
            lblError.setText("Phone is empty");
            return;
        }

        String firm = txfFirm.getText().trim();

        String firmPhone = txfFirmPhone.getText().trim();

        if (deltager != null) {
            Service.updateDeltager(deltager, name, adress, city, country, phone, firm, firmPhone);
            if (deltager != null && txfFirm == null && txfFirmPhone == null) {
                Service.updateDeltager(deltager, name, adress, city, country, phone);
            }
        } else {
            Service.createDeltager(name, adress, city, country, phone, firm, firmPhone);
            if (txfFirm == null && txfFirmPhone == null) {
                Service.createDeltager(name, adress, city, country, phone);
            }
        }
        hide();
    }

}

// -------------------------------------------------------------------------
