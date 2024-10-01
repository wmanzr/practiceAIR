package RUT.practice.Repository;

import java.util.List;

import RUT.practice.Entity.Seats;

public interface SeatsRepository {

public List<Seats> findFreeSeats(int airplaneId, int airflyId);

}