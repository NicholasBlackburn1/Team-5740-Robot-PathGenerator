package org.usfirst.frc.team5740.util;

import org.checkerframework.checker.units.qual.A;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.WritableDoubleValue;
import javafx.scene.control.cell.TextFieldTreeCell;

public class WaypointCell  extends TextFieldTreeCell {

    // String name for cell
    private StringProperty name;

    public void setName(final String value) {
        nameProperty().set(value);
    }

    public String getName() {
        return nameProperty().get();
    }

    public  StringProperty nameProperty() {
        if (name == null)
            name = new SimpleStringProperty(this, "name");
        return name;
    }

    // last modified
    private LongProperty lastModified;

    public void setLastModified(final long value) {
        lastModifiedProperty().set(value);
    }

    public long getLastModified() {
        return lastModifiedProperty().get();
    }

    public LongProperty lastModifiedProperty() {
        if (lastModified == null)
            lastModified = new SimpleLongProperty(this, "lastModified");
        return lastModified;
    }

    // Distance measurement for cell
    private DoubleProperty x;
    private DoubleProperty y;
    private DoubleProperty theta;

    private DoubleProperty acc;
    private DoubleProperty jerk;
    private DoubleProperty Dt;

    public void setX(final double x) {
        distanceX().set(x);
    }

    public void setY(final double y) {
        distanceY().set(y);
    }

    public void setTheta(final double theta) {
        distanceTheta().set(theta);
    }

    public void setAcc(final double acc){
        Acceleration().set(acc);
    }  

    public void setJerk(final double jerk ){
        Jerk().set(jerk);
    }

    public void setDt(final double Dt){
        Dt().set(Dt);
    } 

    public WritableDoubleValue distanceX() {
        if (x == null)
            x = new SimpleDoubleProperty(this, "x");
        return x;
    }

    public WritableDoubleValue distanceY(){
        if (y == null) y = new SimpleDoubleProperty(this, "y");
            return y; 
    }

    public WritableDoubleValue distanceTheta(){
        if (theta == null) theta = new SimpleDoubleProperty(this, "theta");
            return  theta; 
    }
    
    public WritableDoubleValue Acceleration(){
        if (acc == null) acc = new SimpleDoubleProperty(this, "acc");
            return  acc; 
    }
    
    public WritableDoubleValue Jerk(){
        if (jerk == null) jerk = new SimpleDoubleProperty(this, "jerk");
            return  jerk; 
    }

    public WritableDoubleValue Dt(){
        if (Dt == null) Dt = new SimpleDoubleProperty(this,"Dt");
            return Dt;
    }
    
    /**
     * This Function addes all data from tree view to list for waypoints
     *   
     * @param name String name for waypoint  
     * @param x Double x value for waypoint 
     * @param y Double y
     * @param theta Double theta angle
     * @param acc Double acceleration
     * @param jerk Double Jerk Compensation
     * @param dt Double Something
     */
    public WaypointCell( String name,  double x,  double y,  double theta, double acc, double jerk, double dt) {
        
        setName(name);
        setX(x);
        setY(y);
        setTheta(theta);
        setAcc(acc);
        setJerk(jerk);
        setDt(dt);
    }
}


