package RUT.practice.Service.Impl;

import RUT.practice.Entity.Airfly;
import RUT.practice.Entity.Seats;
import RUT.practice.Repository.AirflyRepository;
import RUT.practice.Service.AirflyService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirflyServiceImpl implements AirflyService {

    @Autowired
    private AirflyRepository airflyRepository;

    @Override
    public Airfly findAirflyById(int id) {
        Optional<Airfly> optionalAirfly = airflyRepository.findById(id);
        return optionalAirfly.orElse(null);
    }

    @Override
    public List<Airfly> findAllAirflies() {
        return airflyRepository.findAll();
    }

    @Override
    public List<Airfly> findAllByStatus(String status) {
        return airflyRepository.findAllByStatus(status);
    }

    @Override
    public List<Seats> findSeatsByFlight(String departure, String arrival) {
        return airflyRepository.findSeatsByFlight(departure, arrival);
    }

    @Override
    public Airfly saveAirfly(Airfly airfly) {
        return airflyRepository.save(airfly);
    }

    @Override
    public Airfly updateAirfly(Airfly airfly) {
        return airflyRepository.save(airfly);
    }

    @Override
    public void deleteAirflyById(int id) {
        airflyRepository.deleteById(id);
    }
}