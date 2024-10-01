package RUT.practice.Repository.Impl;

import RUT.practice.Entity.Airfly;
import RUT.practice.Repository.AirflyRepository;
import RUT.practice.Repository.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public class AirflyRepositoryImpl extends BaseRepository<Airfly, Integer> implements AirflyRepository{
    
    public AirflyRepositoryImpl() {
        super(Airfly.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Airfly> findUpcomingAirfly(LocalDate currentDate, LocalTime currentTime, String departure, String arrival) {
        return entityManager.createQuery("SELECT a FROM Airfly a " +
                                        "WHERE a.date >= :currentDate " +
                                        "AND a.time >= :currentTime " +
                                        "AND a.flight.departure = :departure " +
                                        "AND a.flight.arrival = :arrival " +
                                        "ORDER BY a.date ASC, a.time ASC", Airfly.class)
                                    .setParameter("currentDate", currentDate)
                                    .setParameter("currentTime", currentTime)
                                    .setParameter("departure", departure)
                                    .setParameter("arrival", arrival)
                                    .getResultList();
                                }
    
    @Override
    public Airfly getById(int airflyId) {
        return entityManager.createQuery("from Airfly a where a.id = :airflyId", Airfly.class)
                                    .setParameter("airflyId", airflyId)
                                    .getSingleResult();
    }
}