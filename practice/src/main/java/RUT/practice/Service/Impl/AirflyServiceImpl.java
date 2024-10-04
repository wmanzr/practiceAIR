package RUT.practice.Service.Impl;

import RUT.practice.DTO.SeatsDTO;
import RUT.practice.Entity.Airfly;
import RUT.practice.Entity.Seats;
import RUT.practice.Repository.AirflyRepository;
import RUT.practice.Repository.SeatsRepository;
import RUT.practice.Service.AirflyService;
import RUT.practice.Exception.NoFreeSeats;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.LocalTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirflyServiceImpl implements AirflyService {

    private AirflyRepository airflyRepository;
    private SeatsRepository seatsRepository;
    private ModelMapper modelMapper;

    public AirflyRepository getAirflyRepository() {
        return this.airflyRepository;
    }

    @Autowired
    public void setAirflyRepository(AirflyRepository airflyRepository) {
        this.airflyRepository = airflyRepository;
    }

    public SeatsRepository getSeatsRepository() {
        return this.seatsRepository;
    }

    @Autowired
    public void setSeatsRepository(SeatsRepository seatsRepository) {
        this.seatsRepository = seatsRepository;
    }

    public ModelMapper getModelMapper() {
        return this.modelMapper;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SeatsDTO> getAvailableSeatsForNextAirfly(String departure, String arrival) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        List<Airfly> upcomingAirflies = airflyRepository.findUpcomingAirfly(currentDate, currentTime, departure, arrival);
        if (upcomingAirflies == null || upcomingAirflies.size() == 0) {
            return List.of();
        }

        Airfly nextAirfly = airflyRepository.getById(upcomingAirflies.get(0).getId());

        int airflyId = nextAirfly.getId();

        int airplaneId = nextAirfly.getAirplane().getId();

        List<Seats> freeSeats = seatsRepository.findFreeSeats(airplaneId, airflyId);

        if (freeSeats == null || freeSeats.size() == 0) {
            throw new NoFreeSeats(airplaneId);
        }

        return freeSeats.stream()
                .map(seats -> modelMapper.map(seats, SeatsDTO.class))
                .collect(Collectors.toList());
    }
}