package RUT.practice.Repository;

import RUT.practice.Entity.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatsRepository extends JpaRepository<Seats, Integer> {

    Seats findSeatsById(int id);

    List<Seats> findAllByStatus(String status);

    @Query("SELECT s FROM Seats s " +
           "JOIN s.airplane ap " +
           "JOIN Airfly af ON af.airplaneId = ap " +
           "JOIN Ticket t ON t.airfly = af " +
           "JOIN t.passenger p " +
           "WHERE af.id = :airflyId " +
           "AND s.status = 'free' " +
           "AND s.price <= p.budget " +
           "AND p.id = :passengerId")
    List<Seats> findAllSeatsByAirflyAndBudget(@Param("airflyId") int airflyId, 
                                                    @Param("passengerId") int passengerId);
}