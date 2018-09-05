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

        // Laver tab companies
        Tab tabCompanies = new Tab("Companies");
        tabPane.getTabs().add(tabCompanies);

        // Sætter tabCompany til at være klassen companyPane
        CompanyPane companyPane = new CompanyPane();
        tabCompanies.setContent(companyPane);
        tabCompanies.setOnSelectionChanged(event -> companyPane.updateControls());

        // Laver tab employees
        Tab tabEmployees = new Tab("Employees");
        tabPane.getTabs().add(tabEmployees);

        // Sætter tabEmployee til at være klassen employeePane
        EmployeePane employeePane = new EmployeePane();
        tabEmployees.setContent(employeePane);
        tabEmployees.setOnSelectionChanged(event -> employeePane.updateControls());

    }

}
