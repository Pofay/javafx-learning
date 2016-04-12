/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dmctestfrontend;


import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author GianCarlo
 */
public class Materials {

    private SimpleStringProperty name = new SimpleStringProperty("");

    private SimpleStringProperty measurement = new SimpleStringProperty("");

    public Materials(String name, String measurement) {
        setName(name);
        setMeasurement(measurement);
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getName() {
        return name.get();
    }

    public String getMeasurement() {
        return measurement.get();
    }

    public void setMeasurement(String measurement) {
        this.measurement.set(measurement);
    }

}
