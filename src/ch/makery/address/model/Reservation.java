package ch.makery.address.model;

import sun.util.calendar.BaseCalendar;

/**
 * Created by Blast on 07.03.2016.
 */
class Reservation {
    private int id;
    private BaseCalendar.Date dateIn;
    private BaseCalendar.Date dateOut;
    private String status;
    private String made_by;

    public Reservation() {
    }

    public Reservation(int id, BaseCalendar.Date dateIn, BaseCalendar.Date dateOut, String status, String made_by) {
        this.id = id;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.status = status;
        this.made_by = made_by;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BaseCalendar.Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(BaseCalendar.Date dateIn) {
        this.dateIn = dateIn;
    }

    public BaseCalendar.Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(BaseCalendar.Date dateOut) {
        this.dateOut = dateOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMade_by() {
        return made_by;
    }

    public void setMade_by(String made_by) {
        this.made_by = made_by;
    }
}
