

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Messager extends Application {
    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Мессенджер");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 400, 400));

        primaryStage.show();
    }


    private Parent createInterface() {

        HBox hbox = new HBox();
        VBox left = new VBox();
        VBox right = new VBox();




        hbox.setMinWidth(400);

        left.setMinWidth(300);

        right.setMinWidth(100);


        hbox.getChildren().addAll(left, right);


        HBox area = new HBox();
        area.setMinHeight(300);


        HBox buttomLeft = new HBox();
        buttomLeft.setMinHeight(100);



        left.getChildren().addAll(area, buttomLeft);


        TextArea textArea = new TextArea();
        area.getChildren().add(textArea);


        VBox textFiled = new VBox();
        textFiled.setMinWidth(200);



        VBox leftRight = new VBox();

        leftRight.setMinWidth(100);

        buttomLeft.getChildren().addAll(textFiled, leftRight);

        //TextField - место ввода нового сообщения

        TextField text = new TextField();
        text.setMaxHeight(Double.MAX_VALUE);
        text.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(text, Priority.ALWAYS);
        textFiled.getChildren().add(text);

        // Button - кнопка Послать

        Button Knopka = new Button("button");

        Knopka.setOnAction(actionEvent -> {
            String messageext = text.getText();
            textArea.setText(text.getText());
            text.setText( "\n" + messageext);

        });

        Knopka.setMaxWidth(Double.MAX_VALUE);
        Knopka.setMaxHeight(Double.MAX_VALUE);
        VBox.setVgrow(Knopka, Priority.ALWAYS);

        leftRight.getChildren().add(Knopka);

        //Label - верхушка Контакты

        Label label = new Label("Контакты");
        label.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(label, Priority.ALWAYS);
        label.setAlignment(Pos.CENTER);
        label.setTextAlignment(TextAlignment.CENTER);

        //ListView<String> - список контакттов

        ObservableList<String> contacts = FXCollections.observableArrayList("Мама", "Катя Соседка", "Тетя Люда");
        ListView<String> listView = new ListView<>(contacts);
        right.getChildren().addAll(label, listView);



        return hbox;
    }
}
