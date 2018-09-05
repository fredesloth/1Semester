package workshop1;

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

    // private void drawShapes(GraphicsContext gc) {
    // // 5 lodrette streger:
    // int x = 10;
    // int y1 = 10;
    // int y2 = 200;
    // while (x <= 100) {
    // gc.strokeLine(x, y1, x, y2);
    // x = x + 20;
    // }
    // ------------------------------------------------------------------------

    // cirkler der udvider sig
    // private void drawShapes(GraphicsContext gc) {
    // int x = 20; // center: (x,y)
    // int y = 100;
    // int r = 10; // radius: r
    // while (x <= 90 && r <= 80) {
    // gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
    // x = x + 10;
    // r = r + 10;
    // }

    // ------------------------------------------------------------------------
    private void drawShapes(GraphicsContext gc) {
        int x = 70;
        int y = 0;
        int w = 10;
        int h = 200;
        while (w <= 100) {
            w = w + 10;
            gc.strokeOval(x - w, y, w * 2, h);
        }

    }

}
