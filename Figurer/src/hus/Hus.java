package hus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Hus extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane root = initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private Pane initContent() {
        Pane pane = new Pane();
        pane.setPrefSize(400, 400);
        drawShapes(pane);
        return pane;
    }

    // ------------------------------------------------------------------------
    private void drawShapes(Pane pane) {

        Rectangle firkant = new Rectangle(50, 200, 120, 120);
        pane.getChildren().add(firkant);
        firkant.setFill(Color.RED);

        Polygon tag = new Polygon(40, 200, 180, 200, 110, 100);
        pane.getChildren().add(tag);
        tag.setFill(Color.GREEN);

        Rectangle vindue = new Rectangle(80, 220, 40, 40);
        pane.getChildren().add(vindue);
        vindue.setFill(Color.BLACK);

        Circle sol = new Circle(300, 100, 50);
        pane.getChildren().add(sol);
        sol.setFill(Color.YELLOW);
        sol.setStroke(Color.BLACK);

        Line linje = new Line(40, 320, 400, 320);
        pane.getChildren().add(linje);

        Line græs = new Line(30, 320, 400, 320);
        pane.getChildren().add(græs);
        græs.setStroke(Color.LIGHTGREEN);
        græs.setStrokeWidth(10);

    }

}
