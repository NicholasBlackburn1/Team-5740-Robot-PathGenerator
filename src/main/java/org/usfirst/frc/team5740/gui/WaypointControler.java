package org.usfirst.frc.team5740.gui;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXToggleButton;

import org.usfirst.frc.team5740.Main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

public class WaypointControler {
    
    @FXML
    private JFXListView<?> WaypointList;

    @FXML
    private JFXToggleButton waysave;

    @FXML
    private JFXRadioButton addway;

    @FXML
    private JFXRadioButton vars;

    @FXML
    private JFXRadioButton order;
    
    public void initialize() {
        WaypointList.setEditable(true);
      
        
        
       
        
        waysave.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

			@Override
			public void handle(final ActionEvent event) {
                // TODO Auto-generated method stub
                
                if(waysave.isSelected()){
            
                    Main.logger.warning("WaveSave is Disabed");
                }
                
                
			}
        });

        addway.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
                
                if(addway.isSelected()){
                    Main.logger.info("addway is Active");

                }else{
                    Main.logger.warning("addway is Disabed");
                }
                
			}
        });
    

        vars.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
                if(vars.isSelected()){
                    Main.logger.info("vars is Active");

                }else{
                    Main.logger.warning("vas is Disabed");
                }
                
                
			}
        });

        order.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
                
                if(order.isSelected()){
                    Main.logger.info("rder is Active");

                }else{
                    Main.logger.warning("WaveSave is Disabed");
                }
                
			}
        });

    }

}