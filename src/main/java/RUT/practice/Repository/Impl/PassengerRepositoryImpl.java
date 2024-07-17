package RUT.practice.Repository.Impl;

import RUT.practice.Entity.Passenger;
import RUT.practice.Repository.BaseRepository;
import RUT.practice.Repository.PassengerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PassengerRepositoryImpl extends BaseRepository<Passenger, Integer> implements PassengerRepository{

    public PassengerRepositoryImpl() {
        super(Passenger.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Passenger getById(int passengerId) {
        return entityManager.createQuery("from Passenger p where p.id = :passengerId", Passenger.class)
                                    .setParameter("passengerId", passengerId)
                                    .getSingleResult();
    }
}