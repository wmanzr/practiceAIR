package RUT.practice.Service;

import RUT.practice.Entity.Seats;
import RUT.practice.Repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatsService implements BaseService<Seats> {

    @Autowired
    private SeatsRepository seatsRepository;

    @Override
    public Seats create(Seats entity) {
        return seatsRepository.create(entity);
    }

    @Override
    public List<Seats> getAll() {
        return seatsRepository.getAll();
    }

    @Override
    public Seats getById(int id) {
        return seatsRepository.getById(id);
    }

    @Override
    public Seats update(Seats entity) {
        return seatsRepository.update(entity);
    }

    public List<Seats> findFreeSeats(int airplaneId, int airflyId) {
        return seatsRepository.findFreeSeats(airplaneId, airflyId);
    }
}
