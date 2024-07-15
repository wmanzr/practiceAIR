package RUT.practice.Repository;

import RUT.practice.Entity.Airfly;
import RUT.practice.Entity.Seats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirflyRepository extends JpaRepository <Airfly, Integer> {

    Airfly findAirflyById(int id);
    List<Airfly> findAllByStatus(String status);

    @Query(value = "SELECT s FROM Seats s " +
                   "JOIN s.airfly af " +
                   "JOIN af.flight f " +
                   "JOIN s.airplane ap " +
                   "WHERE f.departure = :departure " +
                   "AND f.arrival = :arrival " +
                   "AND s.status = 'free' " +
                   "AND af.date = (SELECT MIN(af2.date) FROM Airfly af2 " +
                                  "JOIN af2.flight f2 " +
                                  "WHERE f2.departure = :departure " +
                                  "AND f2.arrival = :arrival) " +
                   "AND af.time = (SELECT MIN(af3.time) FROM Airfly af3 " +
                                  "JOIN af3.flight f3 " +
                                  "WHERE f3.departure = :departure " +
                                  "AND f3.arrival = :arrival " +
                                  "AND af3.date = af.date))")
    List<Seats> findSeatsByFlight(@Param(value = "departure") String departure, @Param(value = "arrival") String arrival);
}