package RUT.practice.Service.Impl;

import RUT.practice.DTO.SeatsDTO;
import RUT.practice.Entity.Airfly;
import RUT.practice.Entity.Seats;
import RUT.practice.Repository.AirflyRepository;
import RUT.practice.Repository.Impl.SeatsRepositoryImpl;
import RUT.practice.Service.AirflyService;
import RUT.practice.Service.Impl.AirflyServiceImpl;
import RUT.practice.Exception.NoFreeSeats;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.time.LocalTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirflyServiceImpl implements AirflyService{

    @Autowired
    private AirflyRepository airflyRepository;

    @Autowired
    private SeatsRepositoryImpl seatsRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<SeatsDTO> getAvailableSeatsForNextAirfly(String departure, String arrival) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        List<Airfly> upcomingAirflies = airflyRepository.findUpcomingAirfly(currentDate, currentTime, departure, arrival);
        if (upcomingAirflies == null || upcomingAirflies.size() == 0) {
            return List.of();
        }

        Airfly nextAirfly = upcomingAirflies.get(0);

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