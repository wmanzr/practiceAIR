package RUT.practice.DTO;

import lombok.Data;

@Data
public class SeatsDTO {
    private int id;
    private int price;
    private String status;
    private int airplaneId;
    private int airflyId;
}