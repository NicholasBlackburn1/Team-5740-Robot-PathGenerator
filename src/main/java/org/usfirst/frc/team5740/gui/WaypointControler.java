package org.usfirst.frc.team5740.gui;

import java.util.List;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXToggleButton;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
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

    private final String name = "";
    private final double Distance = 0;
    public double x,y,theta;

    public WaypointCell cell = new WaypointCell(name, x, y, theta);
    public final TreeItem root = new TreeItem<>();
    public List<WaypointCell> WaypointList;    
    
    @FXML
    private final TreeTableView<WaypointCell> waytable = new TreeTableView<>(root);

    @FXML
    private JFXToggleButton waysave;

    @FXML
    private JFXRadioButton addway;

    @FXML
    private JFXRadioButton vars;

    @FXML
    private JFXRadioButton order;

    public void initialize() {
        waytable.setEditable(true);

        final TreeTableColumn<WaypointCell, String> fileNameCol = new TreeTableColumn<>("Waypoint name");
        final TreeTableColumn<WaypointCell, Double> XCol= new TreeTableColumn<>("X");
        final TreeTableColumn<WaypointCell, Double> YCol = new TreeTableColumn<>("Y");
        final TreeTableColumn<WaypointCell, Double> ThetaCol = new TreeTableColumn<>("Theta");
        waytable.getColumns().add(ThetaCol);
        waysave.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {
                // TODO Auto-generated method stub

                if (waysave.isSelected()) {

                } else {

                    Main.logger.warning("WaveSave is Disabed");
                }

            }
        });

        addway.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {
                // TODO Auto-generated method stub

                if (addway.isSelected()) {
                    Main.logger.info("addway is Active");
                    waytable.setShowRoot(true);
                    
                } else {
                    Main.logger.warning("addway is Disabed");
                    //WaypointList.forEach(WaypointList-> root.getChildren().add(new TreeItem<>(root)));

                }

            }
        });

        vars.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {
                // TODO Auto-generated method stub
                if (vars.isSelected()) {
                    Main.logger.info("vars is Active");

                } else {
                    Main.logger.warning("vas is Disabed");
                }

            }
        });

        order.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {
                // TODO Auto-generated method stub

                if (order.isSelected()) {
                    Main.logger.info("rder is Active");

                } else {
                    Main.logger.warning("WaveSave is Disabed");
                }

            }
        });

    }

    public void updateWaypoints() {

        final Task task = new Task<Void>() {
            @Override
            public Void call() {
                final int max = 1000000;
                for (int i = 1; i <= max; i++) {
                    if (isCancelled()) {
                        break;
                    }

                    updateProgress(i, max);
                }
                return null;
            }
        };

        new Thread(task).start();

    }

    public void getWaypointList() {

    }

    public void setWaypoints(final String Name, final Double X, final Double Y, final Double theta) {
        WaypointList = List.of(new WaypointCell(Name, X, Y, theta));
    }

}