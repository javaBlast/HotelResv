package ch.makery.address.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.bson.Document;

import java.io.Serializable;

/**
 * Created by Blast on 07.03.2016.
 */
public class Hotel extends Document implements Serializable {
    private final StringProperty hotelName;
    private final StringProperty location;

    public Hotel() {
        this(null, null);
    }

    public Hotel(String hotelName, String location) {
        this.hotelName = new SimpleStringProperty(hotelName);
        this.location = new SimpleStringProperty(location);
    }

    public String getHotelName() {
        return hotelName.get();
    }

    public StringProperty hotelNameProperty() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName.set(hotelName);
    }

    public String getLocation() {
        return location.get();
    }

    public StringProperty locationProperty() {
        return location;
    }

    public void setLocation(String location) {
        this.location.set(location);
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName=" + hotelName +
                ", location=" + location +
                '}';
    }
}
