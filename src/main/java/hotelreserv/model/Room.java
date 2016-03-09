package hotelreserv.model;


/**
 * Created by Blast on 07.03.2016.
 */


class Room {
    private int id;
    private int number;
    private String name;
    private String status;
    private boolean smoke;

    public Room(int id, int number, String name, String status, boolean smoke) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.status = status;
        this.smoke = smoke;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSmoke() {
        return smoke;
    }

    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", smoke=" + smoke +
                '}';
    }

}
