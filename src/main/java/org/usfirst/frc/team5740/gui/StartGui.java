package org.usfirst.frc.team5740.gui;

import org.usfirst.frc.team5740.*;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;

import javafx.scene.Scene;
import javafx.stage.Stage;
public class StartGui extends Application {

	@Override
	public void start(Stage stage) throws Exception {
     
         // Loads fxml file
        Main.logger.info("trying to load fxml");
        try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/Main.fxml"));
            final Parent root = loader.load();

            final Scene scene = new Scene(root);

            stage.setScene(scene);

            Main.logger.info("Showing scene ");
            stage.show();
    
            Main.logger.info("Running upodate");

        } catch (final Exception e) {

            e.printStackTrace();
            Main.logger.warning("JAVAFX error" + e.getMessage());
        }

		
    }
    public static void startUI(String[] args){
        launch(args);
    } 

}