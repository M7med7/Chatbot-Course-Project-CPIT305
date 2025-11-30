package com.chatbot;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        try {
            URL fxmlLocation = Main.class.getResource("chat_view.fxml");
            System.out.println("---------------------------------------------");
            System.out.println("DEBUG: Looking for FXML at: " + fxmlLocation);
            System.out.println("---------------------------------------------");

            if (fxmlLocation == null) {
                throw new IllegalStateException("FXML file not found! Check your resources folder structure.");
            }

            FXMLLoader fxmlLoader = new FXMLLoader(fxmlLocation);
            Scene scene = new Scene(fxmlLoader.load(), 450, 600);

            stage.setTitle("CPIT-305 Project");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            System.err.println("---------------------------------------------");
            System.err.println("CRITICAL ERROR DURING STARTUP:");
            e.printStackTrace();
            System.err.println("---------------------------------------------");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
