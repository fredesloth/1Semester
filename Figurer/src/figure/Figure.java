package figure;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Figure extends Application {
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

        Circle circle = new Circle(150, 150, 50);
        pane.getChildren().add(circle);
        circle.setFill(Color.LIME);
        circle.setStroke(Color.LIGHTSALMON);

        Rectangle firkant = new Rectangle(200, 200, 50, 70);
        pane.getChildren().add(firkant);
        firkant.setFill(Color.STEELBLUE);
        firkant.setStroke(Color.BLACK);

        Line linje = new Line(200, 200, 250, 270);
        pane.getChildren().add(linje);
        linje.setFill(Color.AQUA);
        linje.setStroke(Color.BISQUE);

        // Lav igen ændringer til programmet, så alle figurer nu tegnes 100 pixels til
        // højre

        firkant.setX(firkant.getX() + 100);
        circle.setCenterX(circle.getCenterX() + 100);
        linje.setEndX(linje.getEndX() + 100);
        linje.setStartX(linje.getStartX() + 100);

        firkant.setFill(Color.YELLOW);
        circle.setFill(Color.YELLOW);
        linje.setStroke(Color.YELLOW);
    }
}
