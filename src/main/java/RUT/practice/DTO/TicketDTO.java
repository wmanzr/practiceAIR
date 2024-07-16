package RUT.practice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketDTO {
    private int id;
    private int price;
    private String seat;
    private int passengerId;
    private int airflyId;
}