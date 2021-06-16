package Fractals;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.stage.Stage;

public class Main extends Application
{

    int w = 640;
    int h = 640;


    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Fractal f = new FractalGray(10,1000);
        Palette p = new PaletteGray();
        Pane pane = new Pane();

        final Canvas canvas = new Canvas(w,h);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        pane.getChildren().add(canvas);
        PixelWriter pixelWriter = gc.getPixelWriter();

        for(int i=-h/2; i < h/2; i++)
        {
            for(int j=-w/2; j < w/2; j++)
            {

                Color color = p.color(f.steps(j,i));
                pixelWriter.setColor(j+w/2,i+h/2, color);
            }
        }


        pane.setOnMouseClicked(mouseEvent -> {

            double x = mouseEvent.getX()-(w/2);
            double y = mouseEvent.getY()-(h/2);

            double s = f.steps(x, y);
            String str = p.color(s).toString();


            Alert alert = new Alert( Alert.AlertType.INFORMATION, String.format("%s (%.1f, %.1f)", str, x , y));
            alert.show();
        });


        Scene scene = new Scene(pane, w, h);

        stage.setScene(scene);


        stage.setTitle("What Color?");

        stage.show();
    }
}

