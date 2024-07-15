package RUT.practice.Service.Impl;

import RUT.practice.Entity.Seats;
import RUT.practice.Repository.SeatsRepository;
import RUT.practice.Service.SeatsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatsServiceImpl implements SeatsService {

    @Autowired
    private SeatsRepository seatsRepository;

    @Override
    public Seats findSeatsById(int id) {
        return seatsRepository.findSeatsById(id);
    }

    @Override
    public List<Seats> findAllByStatus(String status) {
        return seatsRepository.findAllByStatus(status);
    }

    @Override
    public List<Seats> findAllSeatsByAirflyAndBudget(int airflyId, int passengerId) {
        return seatsRepository.findAllSeatsByAirflyAndBudget(airflyId, passengerId);
    }
}