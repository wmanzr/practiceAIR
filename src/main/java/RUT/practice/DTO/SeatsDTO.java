package RUT.practice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatsDTO {
    private int id;
    private int price;
    private String status;
    private int airplaneId;
    private int airflyId;
}