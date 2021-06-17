package Ekzamen;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;




public class Strup extends Application
{
    //названия и цвета
    Color[] colors = new Color[]
            {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.DARKBLUE, Color.PURPLE, Color.BLACK};

    String[] strColor = new String[]
            {"КРАСНЫЙ", "ОРАНЖЕВЫЙ", "ЖЁЛТЫЙ", "ЗЕЛЕНЫЙ", "ГОЛУБОЙ", "СИНИЙ", "ФИОЛЕТОВЫЙ", "ЧЁРНЫЙ"};

    StroopFactory factory = new StroopFactory(colors, strColor);

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Эффект Струпа");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 400, 200));

        primaryStage.show();
    }


    private Parent createInterface() {


        HBox hbox = new HBox();
        VBox left = new VBox();
        VBox right = new VBox();

        hbox.setMinWidth(400);

        left.setMinWidth(300);
        left.setAlignment(Pos.CENTER);

        right.setMinWidth(100);
        right.setMaxWidth(100);

        hbox.getChildren().addAll(left, right);


        HBox.setHgrow(left, Priority.ALWAYS);

//LABEL1
        Label label1 = new Label("СИНИЙ");
        label1.setTextFill(Color.web("#fa0aee"));
        label1.setFont(Font.font("Tahoma", 20));
        label1.setStyle("-fx-font-weight: bold;");
        label1.setMaxWidth(Double.MAX_VALUE);
        label1.setAlignment(Pos.CENTER);
        label1.setTextAlignment(TextAlignment.CENTER);

        left.getChildren().addAll(label1);

//LABEL2
        Label label2 = new Label("ЖЕЛТЫЙ");
        label2.setTextFill(Color.web("#15a517"));
        label2.setFont(Font.font("Tahoma", 20));
        label2.setStyle("-fx-font-weight: bold;");
        label2.setMaxWidth(Double.MAX_VALUE);
        label2.setAlignment(Pos.CENTER);
        label2.setTextAlignment(TextAlignment.CENTER);

        left.getChildren().addAll(label2);


//LABEL3
        Label label3 = new Label("ФИОЛЕТОВЫЙ");
        label3.setFont(Font.font("Tahoma", 20));
        label3.setTextFill(Color.web("#fd7805"));
        label3.setStyle("-fx-font-weight: bold;");
        label3.setMaxWidth(Double.MAX_VALUE);
        label3.setAlignment(Pos.CENTER);
        label3.setTextAlignment(TextAlignment.CENTER);

        left.getChildren().addAll(label3);

//RECTANGLE1

        Rectangle rectangle1 = new Rectangle();
        rectangle1.setWidth(50);
        rectangle1.setHeight(20);
        rectangle1.setFill(Color.DARKBLUE);

        left.getChildren().addAll(rectangle1);

//LABEL4
        Label label4 = new Label("ЧЕРНЫЙ");
        label4.setTextFill(Color.web("#f90002"));
        label4.setFont(Font.font("Tahoma", 20));
        label4.setStyle("-fx-font-weight: bold;");
        label4.setMaxWidth(Double.MAX_VALUE);
        label4.setAlignment(Pos.CENTER);
        label4.setTextAlignment(TextAlignment.CENTER);

        left.getChildren().addAll(label4);

//RECTANGLE2

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setWidth(50);
        rectangle2.setHeight(20);
        rectangle2.setFill(Color.MAGENTA);
        left.getChildren().addAll(rectangle2);

        //КНОПКА


        Button Knopka = new Button("Добавить");
        Knopka.setMaxWidth(Double.MAX_VALUE);
        VBox.setVgrow(Knopka, Priority.ALWAYS);
        right.getChildren().addAll(Knopka);

       //ДЕЙСТВИЕ КНОПКИ

        Knopka.setOnAction(actionEvent -> {
            Node n = factory.getElement();
            if(left.getChildren().size()>10)
            {
                left.getChildren().remove(0);
            }
            left.getChildren().addAll(n);
        });

        return hbox;
    }
    /*В левой части окна по центру расположены названия цветов, большим жирным шрифтом. Кроме названий встречаются просто прямоугольники какого-то цвета.

Используйте javafx.scene.control.Label для создания текста, а для прямоугольника используйте javafx.scene.shape.Rectangle.
Все цвета должны быть внутри javafx.scene.layout.VBox.
Справа от цветов находится только одна кнопка «добавить». В этой части она не должна ничего делать, только находиться в окне.
Кнопка должна иметь размер, соответствующий размеру текста внутри.
Она не должна тянуться ни по горизонтали, ни по вертикали. А вот левый VBox с цветами должен растягиваться в ширину.*/
}
