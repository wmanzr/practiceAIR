package RUT.practice.Repository.Impl;

import org.springframework.stereotype.Repository;
import RUT.practice.Entity.Passenger;
import RUT.practice.Repository.BaseRepository;
import RUT.practice.Repository.PassengerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PassengerRepositoryImpl extends BaseRepository<Passenger, Integer> implements PassengerRepository {

    public PassengerRepositoryImpl() {
        super(Passenger.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Passenger getById(int passengerId) {
        return super.getById(passengerId);
    }
}
