package example2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        GridPane root = initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent() {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(GraphicsContext gc) {
        // draw an arrowhead at (50,30)
        int x = 50;
        int y = 30;
        gc.strokeLine(x, y, x + 10, y - 4);
        gc.strokeLine(x, y, x + 10, y + 4);

        // draw an arrowhead at (25,140)
        x = 25;
        y = 140;
        gc.strokeLine(x, y, x + 10, y - 4);
        gc.strokeLine(x, y, x + 10, y + 4);

        // Make an application that draws two arrowheads at (100,75) and (100,125).
        x = 100;
        y = 75;
        gc.strokeLine(x, y, x + 10, y - 4);
        gc.strokeLine(x, y, x + 10, y + 4);

        x = 100;
        y = 125;
        gc.strokeLine(x, y, x + 10, y - 4);
        gc.strokeLine(x, y, x + 10, y + 4);

        // Change the code, so all the arrowheads have twice the length. Ændre fra 10
        // til 20.
    }

}
