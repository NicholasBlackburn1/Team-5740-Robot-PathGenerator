package org.usfirst.frc.team5740.gui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.usfirst.frc.team5740.*;

public class WaypointGui extends Application {

    public void start(Stage stage) throws Exception {
    
         // Loads fxml file
        Main.logger.info("trying to load fxml");
        try {
            final FXMLLoader loader = new FXMLLoader(getClass().getResource("/Waypointeditor.fxml"));
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

    public void Close(Stage stage){
        stage.close();
        
    }
} 


