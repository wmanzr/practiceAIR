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

    public List<Seats> findFreeSeats(int airplaneId, int airflyId) {
        try (Session session = Hibernate.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT s FROM Seats s WHERE s.airplaneId = :airplaneId AND s.airflyId = :airflyId AND s.status = 'free'", Seats.class)
                    .setParameter("airplaneId", airplaneId)
                    .setParameter("airflyId", airflyId)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
