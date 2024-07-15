package RUT.practice.Repository;

import RUT.practice.Entity.Passenger;
import org.springframework.stereotype.Repository;

@Repository
public class PassengerRepository extends BaseRepository<Passenger> {

    public PassengerRepository() {
        super(Passenger.class);
    }
}