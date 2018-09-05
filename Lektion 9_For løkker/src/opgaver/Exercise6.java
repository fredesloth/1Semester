package opgaver;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise6 extends Application {
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
        // Replace the statement here with your code.
        gc.strokeLine(2, 190, 190, 190);
        gc.strokeLine(190, 190, 180, 195);
        gc.strokeLine(190, 190, 180, 185);
        int y1 = 195;
        int y2 = 185;
        for (int i = 0; i <= 11; i++) {
            if (i == 0 || i == 5 || i == 10) {
                y1 = 197;
                y2 = 183;
            } else {
                int x = 10 + i * 14;
                gc.strokeLine(x, y1, x, y2);
            }

        }

    }

}
