package figurnavn;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FigurNavn extends Application {
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

        Rectangle firkant = new Rectangle(5, 100, 300, 175);
        pane.getChildren().add(firkant);
        firkant.setFill(Color.BLUE);
        firkant.setStroke(Color.BLUE);

        Text tekst = new Text(125, 180, "FREDERIK");
        pane.getChildren().add(tekst);
        tekst.setFill(Color.RED);
        tekst.setStroke(Color.RED);
        tekst.setScaleY(10);
        tekst.setScaleX(4);

    }

}
