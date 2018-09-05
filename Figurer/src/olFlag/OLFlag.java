package olFlag;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class OLFlag extends Application {
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

        Circle blå = new Circle(150, 150, 80);
        pane.getChildren().add(blå);
        blå.setFill(null);
        blå.setStroke(Color.BLUE);
        blå.setStrokeWidth(5);

        Circle sort = new Circle(310, 150, 80);
        pane.getChildren().add(sort);
        sort.setFill(null);
        sort.setStroke(Color.BLACK);
        sort.setStrokeWidth(5);

        Circle rød = new Circle(470, 150, 80);
        pane.getChildren().add(rød);
        rød.setFill(null);
        rød.setStroke(Color.RED);
        rød.setStrokeWidth(5);

        Circle gul = new Circle(230, 225, 80);
        pane.getChildren().add(gul);
        gul.setFill(null);
        gul.setStroke(Color.YELLOW);
        gul.setStrokeWidth(5);

        Circle grøn = new Circle(390, 225, 80);
        pane.getChildren().add(grøn);
        grøn.setFill(null);
        grøn.setStroke(Color.GREEN);
        grøn.setStrokeWidth(5);

    }

}
