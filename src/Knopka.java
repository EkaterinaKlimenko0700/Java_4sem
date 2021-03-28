
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.File;
import java.net.MalformedURLException;



public class Knopka extends Application {
    int limit = 4;
    String[] dontPressFrase = new String[]{
            "Не нажимай", "Don't touch", "Не прикасайся", "Сказали же", "Я предупредил"
    };

    @Override
    public void start(Stage primaryStage) throws MalformedURLException {
        primaryStage.setTitle("Кнопка");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 300, 300));

        primaryStage.show();
    }


    private Parent createInterface() throws MalformedURLException {
        Group group = new Group();
        group.minHeight(300);
        group.minWidth(300);


        Rectangle r = new Rectangle();
        r.setY(0);
        r.setX(0);
        r.setHeight(300);
        r.setWidth(300);
        r.setX(0);


        //кнопка
        Button b = new Button("Кнопка");
        b.setLayoutX(110);
        b.setLayoutY(60);

        //текст
        Text text = new Text();
        text.setLayoutY(150);
        text.setLayoutX(30);
        text.setFill(Color.WHITE);

        //гифка
        File file = new File("1387635538_yadernyy-vzryv.gif");
        Image image = new Image(file.toURI().toURL().toString(), 300,300, false, true);
        ImageView img = new ImageView(image);
        img.setFitHeight(300);
        img.setFitWidth(300);
        img.setLayoutX(0);
        img.setLayoutY(0);
        img.setVisible(false);
        img.setPreserveRatio(true);


        group.getChildren().add(r);
        group.getChildren().add(text);
        group.getChildren().add(b);
        group.getChildren().add(img);




        //добавление слушателя. Универсальный метод.
        //b кнопка, источник событий. Причем источник разных типов событий
        //Указываем тип события и обработчик, это функция из Event в void
        //обычно переменную события называют e
        b.addEventHandler(ActionEvent.ACTION, actionEvent -> {
            //любое событие всегда имеет дополнительную информацию
            //Обязательно указыавается источник. В нашем случае это точно b

            if (limit < 0){

                b.setVisible(false);
                text.setVisible(false);
                img.setVisible(true);
            }
            else{
                text.setText(dontPressFrase[4 - limit]);
            }
            limit--;

        });


        //Mouse_entered - событие наведения
        b.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            //в информации о событии есть координаты
            text.setText( "Уведи мышь, эту кнопку нельзя нажимать");
        });


        return group;
    }
}

