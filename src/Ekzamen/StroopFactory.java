package Ekzamen;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import java.util.Random;



public class StroopFactory{

    /*Создайте класс StroopFactory, который в конструкторе принимает массив или список названий цветов и массив или список самих цветов.
Кроме этого, в классе должен быть один метод, который генерирует либо метку с названием цвета, либо прямоугольник для добавления в список.
Фактически, здесь нужно только выделить логику создания текстов и прямоугольников в отдельный класс.*/



    Random rnd = new Random();

    //конструкторы цветов и названий

    Color[] colors;
    String[] strColor;

    public StroopFactory(Color[] colors, String[] strColor) {
        this.colors = colors;
        this.strColor = strColor;
    }

    public Node getElement()
    {
        int color = rnd.nextInt(colors.length);

        //рисуем прямоугольник
        if(rnd.nextBoolean())
        {
            Rectangle rectangle = new Rectangle();
            rectangle.setWidth(50);
            rectangle.setHeight(20);
            rectangle.setFill(colors[color]);
            return rectangle;
        }
        else
        {
            int str;
            do {
                str = rnd.nextInt(strColor.length);
            }

            //пишем цвет
            while (str==color);

            Label label = new Label(strColor[str]);
            label.setTextFill(colors[color]);
            label.setFont(Font.font("Tahoma", 20));
            label.setStyle("-fx-font-weight: bold;");
            label.setMaxWidth(Double.MAX_VALUE);
            label.setAlignment(Pos.CENTER);
            label.setTextAlignment(TextAlignment.CENTER);
            return label;
        }
    }
}
