package RUT.practice.Service.Impl;

import RUT.practice.Entity.Seats;
import RUT.practice.Repository.SeatsRepository;
import RUT.practice.Service.SeatsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatsServiceImpl implements SeatsService {

    @Autowired
    private SeatsRepository seatsRepository;

    @Override
    public Seats findSeatsById(int id) {
        Optional<Seats> optionalSeats = seatsRepository.findById(id);
        return optionalSeats.orElse(null);
    }

    @Override
    public List<Seats> findAllByStatus(String status) {
        return seatsRepository.findAllByStatus(status);
    }

    @Override
    public List<Seats> findAllSeatsByAirflyAndBudget(int airflyId, int passengerId) {
        return seatsRepository.findAllSeatsByAirflyAndBudget(airflyId, passengerId);
    }

    @Override
    public List<Seats> findAllSeats() {
        return seatsRepository.findAll();
    }

    @Override
    public Seats saveSeats(Seats seats) {
        return seatsRepository.save(seats);
    }

    @Override
    public Seats updateSeats(Seats seats) {
        return seatsRepository.save(seats);
    }

    @Override
    public void deleteSeatsById(int id) {
        seatsRepository.deleteById(id);
    }
}