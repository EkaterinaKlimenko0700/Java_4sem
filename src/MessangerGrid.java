import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class MessangerGrid extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        TextField textField = new TextField();
        Button btn = new Button("Button");
        TextArea textArea = new TextArea();
        Label labelContacts = new Label("Контакты");

        ObservableList<String> langs = FXCollections.observableArrayList("Мама", "Катя Соседка", "Тетя Люда");
        ListView<String> contacts = new ListView<>(langs);


        btn.setOnAction(actionEvent -> {
            String text = textField.getText();
            textArea.setText( "\n" + text);

    });

        textField.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);


        textField.setMinWidth(150);


        labelContacts.setMinWidth(100);
        labelContacts.setMaxWidth(Double.MAX_VALUE);
        labelContacts.setAlignment(Pos.CENTER);
        labelContacts.setTextAlignment(TextAlignment.CENTER);



        GridPane root = new GridPane();

        root.getColumnConstraints().add(new ColumnConstraints(100));
        root.getColumnConstraints().add(new ColumnConstraints(100));
        root.getColumnConstraints().add(new ColumnConstraints(100));

        root.getRowConstraints().add(new RowConstraints(20));
        root.getRowConstraints().add(new RowConstraints(180));
        root.getRowConstraints().add(new RowConstraints(100));
        root.getRowConstraints().add(new RowConstraints(30));
        root.getRowConstraints().add(new RowConstraints(30));


        root.add(textField,0,2);
        root.add(contacts,2,1,1,2);
        root.add(btn,1,2);
        root.add(labelContacts,2,0);
        root.add(textArea,0,0, 2,2);


        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);

        stage.setTitle("GridPane in JavaFX");

        stage.show();
    }
}

