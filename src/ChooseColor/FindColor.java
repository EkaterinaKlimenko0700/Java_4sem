package ChooseColor;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;



public class FindColor extends Application  {

    public void start(Stage primaryStage) {

        primaryStage.setTitle("Слайдер");


        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 400, 200));

        primaryStage.show();
    }


    private Parent createInterface() {
        HBox main = new HBox();
        VBox left = new VBox();

        Pane right = new Pane();


        main.getChildren().addAll(left, right);
        left.setMinWidth(150);
        left.setMaxWidth(150);


        right.setMaxWidth(Double.MAX_VALUE);
        right.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        HBox.setHgrow(right, Priority.ALWAYS);

        Label labelSize = new Label("   Размер круга");
        Slider sliderCircle = new Slider(0, 100, 1);
        sliderCircle.setValue(10);
        sliderCircle.setShowTickMarks(true);
        Label labelBackground = new Label("  Цвет фона");
        ColorPicker colorBackground = new ColorPicker();
        colorBackground.setValue(Color.GREEN);
        Label labelColorCircle = new Label("  Цвет круга");
        ColorPicker colorCircle = new ColorPicker();
        colorCircle.setValue(Color.DARKORANGE);

        left.getChildren().addAll(labelSize, sliderCircle, labelBackground, colorBackground, labelColorCircle, colorCircle);
        colorBackground.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                right.setBackground(new Background(new BackgroundFill(colorBackground.getValue(), CornerRadii.EMPTY, Insets.EMPTY)));
            }
        });

       //центровка круга
        Circle circle = new Circle();
        right.getChildren().addAll(circle);
        right.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                circle.setCenterX((Double)t1/2);
            }
        });

        right.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                circle.setCenterY((Double) t1 /2);
            }
        });

        circle.setRadius(10);
        circle.setFill(Color.DARKORANGE);

        //заливка
        colorCircle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                circle.setFill(colorCircle.getValue());
            }
        });

        //расширение

        sliderCircle.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                circle.setRadius((Double) t1);
            }
        });




        return main;
        

    }
}
