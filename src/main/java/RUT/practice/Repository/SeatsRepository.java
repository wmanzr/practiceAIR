package RUT.practice.Repository;

import RUT.practice.Entity.Seats;
import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SeatsRepository extends BaseRepository<Seats> {

    public SeatsRepository() {
        super(Seats.class);
    }

    @Transactional
    public List<Seats> findFreeSeats(int airplaneId, int airflyId) {
    try {
         TypedQuery<Seats> query = entityManager.createQuery(
                                    "SELECT s FROM Seats s WHERE s.airplane.id = :airplaneId AND s.airfly.id = :airflyId AND s.status = 'free'", Seats.class)
                                    .setParameter("airplaneId", airplaneId)
                                    .setParameter("airflyId", airflyId);
                                    return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}