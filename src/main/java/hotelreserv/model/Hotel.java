package hotelreserv.model;

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

    public void setHotelName(String hotelName) {
        this.hotelName.set(hotelName);
    }

    public StringProperty hotelNameProperty() {
        return hotelName;
    }

    public String getLocation() {
        return location.get();
    }

    public void setLocation(String location) {
        this.location.set(location);
    }

    public StringProperty locationProperty() {
        return location;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName=" + hotelName +
                ", location=" + location +
                '}';
    }
}
