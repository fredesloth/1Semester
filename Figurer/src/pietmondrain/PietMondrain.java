package pietmondrain;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PietMondrain extends Application {
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

        Ellipse feet = new Ellipse(500, 705, 150, 10);
        pane.getChildren().add(feet);
        feet.setStroke(Color.DARKGREY);

        Rectangle legs = new Rectangle(380, 600, 235, 100);
        pane.getChildren().add(legs);
        legs.setFill(Color.ORANGE);
        legs.setStroke(Color.GRAY);

        Rectangle body = new Rectangle(350, 250, 300, 400);
        pane.getChildren().add(body);
        body.setFill(Color.ORANGE);
        body.setStroke(Color.GRAY);

        Circle hoodie = new Circle(500, 250, 250);
        pane.getChildren().add(hoodie);
        hoodie.setFill(Color.ORANGE);
        hoodie.setStroke(Color.GRAY);

        Ellipse detailHoodie = new Ellipse(500, 280, 200, 180);
        pane.getChildren().add(detailHoodie);
        detailHoodie.setFill(null);
        detailHoodie.setStroke(Color.BLACK);

        Circle inerHoodie = new Circle(500, 250, 150);
        pane.getChildren().add(inerHoodie);
        inerHoodie.setFill(Color.ROSYBROWN);

        Arc headL = new Arc(500, 250, 100, 150, 90, 180);
        headL.setType(ArcType.ROUND);
        pane.getChildren().add(headL);
        headL.setFill(Color.MOCCASIN);

        Arc headH = new Arc(500, 250, 100, 150, 270, 180);
        headH.setType(ArcType.ROUND);
        pane.getChildren().add(headH);
        headH.setFill(Color.MOCCASIN);

        Circle eyesL = new Circle(460, 200, 50);
        pane.getChildren().add(eyesL);
        eyesL.setFill(Color.WHITE);

        Circle eyesH = new Circle(540, 200, 50);
        pane.getChildren().add(eyesH);
        eyesH.setFill(Color.WHITE);

        Line spaceEyes = new Line(500, 210, 500, 190);
        pane.getChildren().add(spaceEyes);
        spaceEyes.setStroke(Color.BLACK);

        Circle pupilL = new Circle(470, 200, 10);
        pane.getChildren().add(pupilL);
        pupilL.setFill(Color.BLACK);

        Circle pupilH = new Circle(530, 200, 10);
        pane.getChildren().add(pupilH);
        pupilH.setFill(Color.BLACK);

        Line snorL = new Line(500, 400, 480, 440);
        pane.getChildren().add(snorL);
        snorL.setStroke(Color.BLACK);

        Line snorH = new Line(500, 400, 520, 440);
        pane.getChildren().add(snorH);
        snorH.setStroke(Color.BLACK);

        Line zipper = new Line(500, 502, 500, 648);
        pane.getChildren().add(zipper);
        zipper.setStroke(Color.BLACK);
        zipper.setStrokeWidth(5);

        Line legGaps = new Line(500, 648, 500, 700);
        pane.getChildren().add(legGaps);
        legGaps.setStroke(Color.GRAY);

        Rectangle armL = new Rectangle(100, 450, 250, 50);
        pane.getChildren().add(armL);
        armL.setFill(Color.ORANGE);
        armL.setStroke(Color.GRAY);

        Rectangle armH = new Rectangle(650, 450, 250, 50);
        pane.getChildren().add(armH);
        armH.setFill(Color.ORANGE);
        armH.setStroke(Color.GRAY);

        Circle handL = new Circle(85, 475, 40);
        pane.getChildren().add(handL);
        handL.setFill(Color.ROSYBROWN);

        Circle handH = new Circle(900, 475, 40);
        pane.getChildren().add(handH);
        handH.setFill(Color.ROSYBROWN);

        Circle fingerL = new Circle(90, 500, 10);
        pane.getChildren().add(fingerL);
        fingerL.setFill(Color.ROSYBROWN);
        fingerL.setStroke(Color.BLACK);

        Circle fingerH = new Circle(895, 500, 10);
        pane.getChildren().add(fingerH);
        fingerH.setFill(Color.ROSYBROWN);
        fingerH.setStroke(Color.BLACK);

        Polygon mouth = new Polygon(460, 300, 540, 300, 500, 330);
        pane.getChildren().add(mouth);
        mouth.setFill(Color.BLACK);

    }

}
