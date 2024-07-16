package RUT.practice.Repository;

import RUT.practice.Entity.Airfly;
import RUT.practice.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class AirflyRepository extends BaseRepository<Airfly> {
    
    public AirflyRepository() {
        super(Airfly.class);
    }

    public List<Airfly> findUpcomingAirfly(LocalDate currentDate, String departure, String arrival) {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            return session.createQuery("SELECT a FROM Airfly a " +
                                        "JOIN a.flightId f " +
                                        "WHERE a.date >= :currentDate " +
                                        "AND f.departure = :departure " +
                                        "AND f.arrival = :arrival " +
                                        "ORDER BY a.date ASC, a.time ASC", Airfly.class)
                          .setParameter("currentDate", currentDate)
                          .setParameter("departure", departure)
                          .setParameter("arrival", arrival)
                          .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}