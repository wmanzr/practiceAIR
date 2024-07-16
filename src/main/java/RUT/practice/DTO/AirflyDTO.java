package RUT.practice.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirflyDTO {
    private int id;
    private LocalDate date;
    private LocalTime time;
    private String status;
    private int flightId;
    private int airplaneId;
}