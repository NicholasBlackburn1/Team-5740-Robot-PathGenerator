package org.usfirst.frc.team5740.gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXToggleButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.usfirst.frc.team5740.*;

public class Controller {

    private final Stage stage = new Stage();
    private final WaypointGui way = new WaypointGui();
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="output"
    private JFXToggleButton output; // Value injected by FXMLLoader

    @FXML // fx:id="Gen"
    private JFXToggleButton Gen; // Value injected by FXMLLoader

    @FXML // fx:id="path"
    private JFXToggleButton path; // Value injected by FXMLLoader

    @FXML // fx:id="savetxt"
    private JFXCheckBox savetxt; // Value injected by FXMLLoader

    @FXML // fx:id="splashtext"
    private Text splashtext; // Value injected by FXMLLoader

    @FXML // fx:id="comment"
    private JFXCheckBox comment; // Value injected by FXMLLoader

    @FXML // fx:id="savejava"
    private JFXCheckBox savejava; // Value injected by FXMLLoader

    @FXML // fx:id="pathprog"
    private JFXSpinner pathprog; // Value injected by FXMLLoader

    public void initialize() {

        pathprog.progressProperty().set(0);

        // gets state of togle
        Gen.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {

                // Creates Connection

                if (Gen.isSelected()) {
                    Main.logger.info("output path save is enabled");

                    setOutputPath();

                } else {
                    Main.logger.warning("output save is Disabled");
                }
            }
        });

        output.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {

                if (output.isSelected()) {
                    Main.logger.info("output path save is enabled");

                    setOutputPath();

                } else {
                    Main.logger.warning("output save is Disabled");
                }

            }
        });

        path.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {

                // Creates Connection

                if (path.isSelected()) {
                    Main.logger.warning(" Path gen Enabled");
                    wayPointConfig();
                    
                } else {
                    Main.logger.warning(" Path gen Disabled");
                    wayPointClose();
                }

            }
        });

        comment.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {

                if (comment.isSelected()) {
                    Main.logger.info("comment for java Enabed");

                } else {
                    Main.logger.warning("comment for Disabled");
                }
            }
        });

        savejava.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {

                // Creates Connection
                if (savejava.isSelected()) {
                    Main.logger.info("Java save is enabled");
                    saveJava();

                } else {
                    Main.logger.warning("Java save is Disabled");
                }
            }
        });

        savetxt.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {

                // Creates Connection

                if (savetxt.isSelected()) {
                    Main.logger.info("Text path save is enabled");
                    saveText();

                } else {
                    Main.logger.warning("Textpath save is Disabled");
                }

            }
        });

    }

    public void pathJen() {
        Main.logger.info(" Path gen Active ");

    }

    public void saveJava() {
        Main.logger.info(" gen Java Path ");

    }

    public void saveText() {
        Main.logger.info("Saving text path");

    }

    public void splashUpdate() {

    }

    public void enableComment() {
        // Main.logger.info("Enabled coments for path ");

    }

    public void setOutputPath() {
        Main.logger.info("set Paths Output Location ");

    }

    public void wayPointConfig() {
        // \ Main.logger.info("Waypoint edit active ");
        try {
            way.start(stage);
        } catch (final Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        public void wayPointClose(){
            
            try {
                way.Close(stage);
            } catch (final Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } 
    
}