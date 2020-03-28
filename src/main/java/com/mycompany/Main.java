package com.mycompany;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import static javafx.geometry.Pos.CENTER;
import static javafx.scene.paint.Color.*;

public class Main extends Application {

    Text t1;
    Text t2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Text info = new Text("Press button to transfer one member of the right group to the left group.");
        info.setFont(Font.font("Sans", 15));
        info.setWrappingWidth(280);

        t1 = new Text("aa");
        t1.setFont(Font.font("Consolas", 30));
        t1.setFill(BLUE);

        t2 = new Text("aaaaaaaaaaaa");
        t2.setFont(Font.font("Consolas", 30));
        t2.setFill(GREEN);

        TextFlow textDispl = new TextFlow(t1, t2);
//        textDispl.setTextAlignment(TextAlignment.CENTER); // <- doesn't help
//        textDispl.setPrefWidth(200); // <- doesn't help

        Button button = new Button("Conquer one");
        button.setOnAction(this::advance);

        VBox parent = new VBox();
        parent.setAlignment(CENTER);
        parent.setSpacing(10);
        parent.getChildren().addAll(info, textDispl, button);
        Scene scene = new Scene(parent, 300, 200);
        textDispl.setMaxWidth(parent.getWidth());
        primaryStage.setScene(scene);
        primaryStage.setTitle("The blues has you...");
        primaryStage.show();
    }

    private void advance(ActionEvent actionEvent) {
        if (t2.getText().length() == 0) {
            System.out.println("You're done");
            System.exit(0);
        }
        String text2 = t2.getText();
        String text1 = t1.getText() + text2.substring(0, 1);
        t1.setText(text1);
        t2.setText(text2.substring(1));
    }
}
