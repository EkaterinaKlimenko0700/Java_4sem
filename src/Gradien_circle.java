import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Gradien_circle extends Application
{

    int w = 300;
    int h = 300;
    int x = 150;
    int y = 150;
    int r = 100;

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        Pane pane = new Pane();
        RadialGradient gradient1 = new RadialGradient(0, 0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE, new Stop[] {
                new Stop(0, Color.BLACK),
                new Stop(1, Color.WHITE)
        });
        Circle circle = new Circle(x,y, r, gradient1);
        pane.getChildren().addAll(circle);

        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                double distance = Math.sqrt(Math.pow(x-mouseEvent.getX(),2)+Math.pow(y - mouseEvent.getY(),2));
                String color = "#ffffffff";
                if(distance < r )
                    color = Color.gray(distance/r).toString();

                Alert alert = new Alert( Alert.AlertType.INFORMATION, String.format("%s (%.1f, %.1f)", color, mouseEvent.getX(), mouseEvent.getY()));
                alert.show();
            }
        });


        Scene scene = new Scene(pane, w, h);
        stage.setScene(scene);

        stage.setTitle("What Color?");

        stage.show();

    }
}
