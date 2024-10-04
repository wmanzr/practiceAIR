package RUT.practice.Repository.Impl;

import RUT.practice.Entity.Seats;
import RUT.practice.Repository.SeatsRepository;
import RUT.practice.Repository.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SeatsRepositoryImpl extends BaseRepository<Seats, Integer> implements SeatsRepository{

    public SeatsRepositoryImpl() {
        super(Seats.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Seats> findFreeSeats(int airplaneId, int airflyId) {
        return entityManager.createQuery("SELECT s FROM Seats s WHERE s.airplane.id = :airplaneId " +
                                         "AND s.airfly.id = :airflyId AND s.status = 'free'", Seats.class)
                                    .setParameter("airplaneId", airplaneId)
                                    .setParameter("airflyId", airflyId)
                                    .getResultList();
    }
}