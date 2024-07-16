package RUT.practice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PassengerDTO {
    private int id;
    private String firstName;
    private String lastName;
    private int budget;
    private String pass;
    private String health;
    private String preferences;
}