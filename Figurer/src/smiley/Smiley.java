package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Smiley extends Application {
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

        Circle cirkel = new Circle(100, 100, 60);
        pane.getChildren().add(cirkel);
        cirkel.setFill(null);
        cirkel.setStroke(Color.BLACK);

        Circle øje1 = new Circle(80, 80, 10);
        pane.getChildren().add(øje1);
        øje1.setFill(null);
        øje1.setStroke(Color.BLACK);

        Circle øje2 = new Circle(120, 80, 10);
        pane.getChildren().add(øje2);
        øje2.setFill(null);
        øje2.setStroke(Color.BLACK);

        Line mund = new Line(85, 130, 115, 130);
        pane.getChildren().add(mund);
        mund.setStroke(Color.BLACK);
    }

}
