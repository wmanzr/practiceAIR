package RUT.practice.Service;

import RUT.practice.Entity.Seats;

import java.util.List;

public interface SeatsService {
    
    Seats findSeatsById(int id);

    List<Seats> findAllByStatus(String status);

    List<Seats> findAllSeatsByAirflyAndBudget(int airflyId, int passengerId);

    List<Seats> findAllSeats();

    Seats saveSeats(Seats seats);

    Seats updateSeats(Seats seats);

    void deleteSeatsById(int id);
}