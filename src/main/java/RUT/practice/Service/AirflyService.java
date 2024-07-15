package RUT.practice.Service;

import RUT.practice.Entity.Airfly;
import RUT.practice.Entity.Seats;
import java.util.List;

public interface AirflyService {
    Airfly findAirflyById(int id);

    List<Airfly> findAllByStatus(String status);

    List<Seats> findSeatsByDateAndTime(String departure, String arrival);
}
