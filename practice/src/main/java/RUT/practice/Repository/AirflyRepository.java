package RUT.practice.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import RUT.practice.Entity.Airfly;

public interface AirflyRepository {

List<Airfly> findUpcomingAirfly(LocalDate currentDate, LocalTime currentTime, String departure, String arrival);
public Airfly getById(int airflyId);
}