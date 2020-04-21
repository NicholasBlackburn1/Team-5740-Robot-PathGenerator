package org.usfirst.frc.team5740.gui;

import java.util.List;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.JFXTreeView;
import com.jfoenix.controls.cells.editors.base.JFXTreeTableCell;

import org.usfirst.frc.team5740.Main;


import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Cell;
import javafx.scene.control.ListCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;

import org.usfirst.frc.team5740.util.*;

public class WaypointControler {

    public String name;  
    public double x,y,theta,acc,jerk,dt;

    public WaypointCell cell = new WaypointCell(name, x, y, theta, acc, jerk, dt);
    public List<WaypointCell> WaypointList;    
    
    
    @FXML
    private JFXToggleButton waysave;

    @FXML
    private TreeTableColumn<WaypointCell, Double > waypointAcc;

    @FXML
    private TreeTableColumn<WaypointCell, Double> waypointY;

    @FXML
    private TreeTableColumn<WaypointCell, Double> waypointX;

    @FXML
    private TreeTableColumn<WaypointCell, Double> waypointJerk;

    @FXML 
    private TreeTableColumn<WaypointCell, String> waypoints;

    @FXML
    private TreeTableColumn<WaypointCell, Double> waypointDt;

    @FXML
    private TreeTableColumn<WaypointCell, Double> waaypointTheta;

    @FXML
    private TreeTableView<WaypointCell> waytable;

    @FXML
    public void initialize() {


        waysave.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

          
            @Override
            public void handle(final ActionEvent event) {
                // TODO Auto-generated method stub

                if (waysave.isSelected()) {
                    Main.logger.info("addway is Active");
                    
                    
                } else {
                    Main.logger.warning("addway is Disabed");
                    //WaypointList.forEach(WaypointList-> root.getChildren().add(new TreeItem<>(root)));

                }

            }
        });
    }

    
    public void setWaypoints(final String Name, final Double X, final Double Y, final Double theta, final Double acc,final Double Jerk, final double dt ) {
        WaypointList = List.of(new WaypointCell(Name, X, Y, theta,acc,Jerk,dt));
    }



}