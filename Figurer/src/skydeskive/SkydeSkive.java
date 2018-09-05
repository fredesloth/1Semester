package skydeskive;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SkydeSkive extends Application {
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

        Circle c1 = new Circle(150, 150, 100);
        pane.getChildren().add(c1);
        c1.setStroke(Color.BLACK);
        c1.setFill(null);
        c1.setStrokeWidth(25);

        Circle c2 = new Circle(150, 150, 55);
        pane.getChildren().add(c2);
        c2.setFill(null);
        c2.setStroke(Color.BLACK);
        c2.setStrokeWidth(25);

        Circle c3 = new Circle(150, 150, 20);
        pane.getChildren().add(c3);
        c3.setFill(Color.BLACK);

    }

}
