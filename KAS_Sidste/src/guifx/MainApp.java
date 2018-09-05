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
		stage.setTitle("KAS Demo");
		BorderPane pane = new BorderPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private void initContent(BorderPane pane) {
		TabPane tabPane = new TabPane();
		this.initTabPane(tabPane);
		pane.setCenter(tabPane);
	}

	private void initTabPane(TabPane tabPane) {
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

		// -----------------------------------------------------------------------------------
		Tab tabKonferences = new Tab("Conference Management");
		tabPane.getTabs().add(tabKonferences);

		KonferencePane konferenceManagementPane = new KonferencePane();
		tabKonferences.setContent(konferenceManagementPane);
		tabKonferences.setOnSelectionChanged(event -> konferenceManagementPane.updateControls());
		
		// -----------------------------------------------------------------------------------
		Tab tabHotels = new Tab("Hotel Management");
		tabPane.getTabs().add(tabHotels);
		
		HotelPane hotelPane = new HotelPane();
		tabHotels.setContent(hotelPane);
		tabHotels.setOnSelectionChanged(event -> hotelPane.updateControls());
		
		// -----------------------------------------------------------------------------------
		Tab tabTilmelding = new Tab("Conference sign up");
		tabPane.getTabs().add(tabTilmelding);
		
		TilmeldingPane tilmeldingPane = new TilmeldingPane();
		tabTilmelding.setContent(tilmeldingPane);
		tabTilmelding.setOnSelectionChanged(event -> tilmeldingPane.updateControls());
		
		// -----------------------------------------------------------------------------------
		Tab tabTilmeldingManagement = new Tab("Manage registrations");
		tabPane.getTabs().add(tabTilmeldingManagement);
		
		TilmeldingManagementPane tilmeldingManagementPane = new TilmeldingManagementPane();
		tabTilmeldingManagement.setContent(tilmeldingManagementPane);
		tabTilmeldingManagement.setOnSelectionChanged(event -> tilmeldingManagementPane.updateControls());
		
	}

}
