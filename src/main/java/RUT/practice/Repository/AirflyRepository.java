package RUT.practice.Repository;

import RUT.practice.Entity.Airfly;
import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public class AirflyRepository extends BaseRepository<Airfly> {
    
    public AirflyRepository() {
        super(Airfly.class);
    }

@Transactional
public List<Airfly> findUpcomingAirfly(LocalDate currentDate, String departure, String arrival) {
    try {
         TypedQuery<Airfly> query = entityManager.createQuery("SELECT a FROM Airfly a " +
                                        "WHERE a.date >= :currentDate " +
                                        "AND a.flight.departure = :departure " +
                                        "AND a.flight.arrival = :arrival " +
                                        "ORDER BY a.date ASC, a.time ASC", Airfly.class)
                          .setParameter("currentDate", currentDate)
                          .setParameter("departure", departure)
                          .setParameter("arrival", arrival);
                          return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}