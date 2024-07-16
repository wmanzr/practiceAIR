package RUT.practice.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter
@Setter
public class ServicesDTO {
    private int id;
    private String type;
    private String serv;
    private LocalDate date;
    private LocalTime time;
    private int passengerId;
}