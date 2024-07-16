package RUT.practice.Repository;

import org.springframework.stereotype.Repository;
import RUT.practice.Entity.Flight;

@Repository
public class FlightRepository extends BaseRepository<Flight>{

    public FlightRepository() {
        super(Flight.class);
    }
}