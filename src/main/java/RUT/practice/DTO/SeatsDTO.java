package RUT.practice.DTO;

public class SeatsDTO {
    private int price;
    private String status;
    private int airflyId;
    private int airplaneId;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAirflyId() {
        return airflyId;
    }

    public void setAirflyId(int airflyId) {
        this.airflyId = airflyId;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }
}

