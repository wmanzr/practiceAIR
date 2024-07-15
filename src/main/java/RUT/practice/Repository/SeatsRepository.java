package RUT.practice.Repository;

import RUT.practice.Entity.Seats;
import org.hibernate.Session;
import RUT.practice.Hibernate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatsRepository extends BaseRepository<Seats> {

    public SeatsRepository() {
        super(Seats.class);
    }

    public List<Seats> findFreeSeats(int airplaneId) {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT s FROM Seats s WHERE s.airplaneId = :airplaneId AND s.status = 'AVAILABLE'", Seats.class)
                    .setParameter("airplaneId", airplaneId)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
