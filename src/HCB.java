import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HCB extends Application
{

    int w = 360;
    int h = 99;


    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        LinearGradient gradient1 = new LinearGradient(0, 0, 1.0, 1.0, true,
                CycleMethod.NO_CYCLE,
                new Stop[] {
                        new Stop(0, Color.hsb(0,0,1)),
                        new Stop(1, Color.hsb(360,1.0,1))
                }
        );

        Rectangle rect = new Rectangle(0,0,w,h);
        rect.setFill(gradient1);
        pane.getChildren().addAll(rect);


        pane.setOnMouseClicked(mouseEvent -> {

            double d1 = mouseEvent.getX()/w;
            double d2 = mouseEvent.getY()/h;
            String s = Color.hsb(d1, d2, 1).toString();

            Alert alert = new Alert( Alert.AlertType.INFORMATION, String.format("%s (%.1f, %.1f)", s, mouseEvent.getX(), mouseEvent.getY()));
            alert.show();
        });


        Scene scene = new Scene(pane, w, h);
        stage.setScene(scene);

        stage.setTitle("What Color?");

        stage.show();
    }
}
