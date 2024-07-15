package RUT.practice.DTO;

public class TicketDTO {
    private int id;
    private int price;
    private String seat;
    private int passengerId;
    private int airflyId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getAirflyId() {
        return airflyId;
    }

    public void setAirflyId(int airflyId) {
        this.airflyId = airflyId;
    }
}
