package hotelreserv.model;

import sun.util.calendar.BaseCalendar;

/**
 * Created by Blast on 07.03.2016.
 */

class Guest {
    private int id;
    private String firstName;
    private String lastName;
    private BaseCalendar.Date member_since;

    public Guest() {
    }

    public Guest(int id, String firstName, String lastName, BaseCalendar.Date member_since) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.member_since = member_since;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BaseCalendar.Date getMember_since() {
        return member_since;
    }

    public void setMember_since(BaseCalendar.Date member_since) {
        this.member_since = member_since;
    }
}
