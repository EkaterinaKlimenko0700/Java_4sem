import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MessangerGrid extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        TextField first = new TextField("First");
        Button second = new Button("Button");
        TextArea sixth = new TextArea("Sixth");
        Label labelContacts = new Label("Контакты");
        ListView<String> contacts = new ListView<>();

        /* second.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
           public void handle(ActionEvent actionEvent) {
                String text = third.getText();
                third.setText(first.getText());
                sixth.setText(sixth.getText() + "\n" + text);
            }
        });



        first.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        second.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);


        first.setMinWidth(150);
        first.setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));

        third.setMinWidth(150);
        third.setBackground(new Background(new BackgroundFill(Color.AZURE, CornerRadii.EMPTY, Insets.EMPTY)));

        GridPane root = new GridPane();

        root.getColumnConstraints().add(new ColumnConstraints(100));
        root.getColumnConstraints().add(new ColumnConstraints(100));
        root.getColumnConstraints().add(new ColumnConstraints(100));

        root.getRowConstraints().add(new RowConstraints(100));
        root.getRowConstraints().add(new RowConstraints(100));
        root.getRowConstraints().add(new RowConstraints(100));
        root.getRowConstraints().add(new RowConstraints(100));
        root.getRowConstraints().add(new RowConstraints(100));

        root.add(first,0,0,2,1);
        root.add(second,0,1);
        root.add(labelContacts,2,0,1,3);
        root.add(sixth,2,3, 1,2);


        Scene scene = new Scene(root, 300, 500);
        stage.setScene(scene);

        stage.setTitle("GridPane in JavaFX");

        stage.show();
    }*/
}
}


