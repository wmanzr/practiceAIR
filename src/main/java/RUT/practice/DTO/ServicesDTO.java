package RUT.practice.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ServicesDTO {
    private int id;
    private String type;
    private String serv;
    private LocalDate date;
    private LocalTime time;
    private int passengerId;
}