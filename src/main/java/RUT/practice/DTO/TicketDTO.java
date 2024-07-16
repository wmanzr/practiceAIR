package RUT.practice.DTO;

import lombok.Data;

@Data
public class TicketDTO {
    private int id;
    private int price;
    private String seat;
    private int passengerId;
    private int airflyId;
}