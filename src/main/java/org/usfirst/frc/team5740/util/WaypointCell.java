package org.usfirst.frc.team5740.util;

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

    public void setX(final double x) {
        distanceX().set(x);
    }

    public void setY(final double y) {
        distanceY().set(y);
    }

    public void setTheta(final double theta) {
        distanceTheta().set(theta);
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

    

    public WaypointCell(final String name, final double x, final double y, final double theta) {
        
        setName(name);
        setX(x);
        setY(y);
        setTheta(theta);
    }
}


