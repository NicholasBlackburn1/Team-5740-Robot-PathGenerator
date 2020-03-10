package org.usfirst.frc.team5740.gui;

import java.net.URL;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXToggleButton;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

import org.usfirst.frc.team5740.*;
public class Controller {
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


            }
        });
        
        output.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {

                // Creates Connection


            }
        });

        path.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {

                // Creates Connection


            }
        });
        
        comment.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {

                // Creates Connection


            }
        });

        savejava.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {

                // Creates Connection


            }
        });

        savetxt.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {

                // Creates Connection


            }
        });

        
    }  
        
    public void pathJen(){
        Main.logger.info(" Path gen Active ");

        if(path.isPressed()){
            Main.logger.warning(" Path gen Enabled");
            

        } else{
            Main.logger.warning(" Path gen Disabled");
        }

    }

    public void saveJava(){
        Main.logger.info(" gen Java Path ");

        if(savejava.isPressed()){
            Main.logger.info("Java save is enabled");
            
            
        } else{
            Main.logger.warning("Java save is Disabled");
        }
    }

    public void saveText(){
        Main.logger.info("Saving text path");
        
        if(savetxt.isPressed()){
            Main.logger.info("Text path save is enabled");
            
            
        } else{
            Main.logger.warning("Textpath save is Disabled");
        }
    }  

    public void splashUpdate(){

    }

    public void enableComment(){
        Main.logger.info("Enabled coments for path ");

    }

    public void setOutputPath(){
        Main.logger.info("set Paths Output Location ");

    } 
}