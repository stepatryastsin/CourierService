package org.example.javaFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.InputStream;

import org.example.javaFX.MainController;


public class StartApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader start_loader = new FXMLLoader(StartApplication.class.getResource("/screens/MainScreen.fxml"));

        Scene start = new Scene(start_loader.load());

        Image icon = new Image(getClass().getResource("/human.png").toExternalForm());

        stage.getIcons().add(icon);

        stage.setTitle("Courier");

        stage.setScene(start);

        stage.show();

    }

    public static void application() {
        launch();
    }

}







