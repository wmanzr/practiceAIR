package RUT.practice.Service.Impl;

import RUT.practice.Entity.Airfly;
import RUT.practice.Entity.Seats;
import RUT.practice.Repository.AirflyRepository;
import RUT.practice.Service.AirflyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirflyServiceImpl implements AirflyService {

    @Autowired
    private AirflyRepository airflyRepository;

    @Override
    public Airfly findAirflyById(int id) {
        return airflyRepository.findAirflyById(id);
    }

    @Override
    public List<Airfly> findAllByStatus(String status) {
        return airflyRepository.findAllByStatus(status);
    }

    @Override
    public List<Seats> findSeatsByDateAndTime(String departure, String arrival) {
        return airflyRepository.findSeatsByDateAndTime(departure, arrival);
    }
}