package RUT.practice.Service.Impl;

import RUT.practice.Entity.Airfly;
import RUT.practice.Entity.Passenger;
import RUT.practice.Entity.Seats;
import RUT.practice.Exception.NoFreeSeats;
import RUT.practice.DTO.SeatsDTO;
import RUT.practice.Service.PassengerService;
import RUT.practice.Repository.AirflyRepository;
import RUT.practice.Repository.PassengerRepository;
import RUT.practice.Repository.SeatsRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService {

    private PassengerRepository passengerRepository;
	private SeatsRepository seatsRepository;
    private AirflyRepository airflyRepository;
    private ModelMapper modelMapper;

    public PassengerRepository getPassengerRepository() {
        return this.passengerRepository;
    }

    @Autowired
    public void setPassengerRepository(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public SeatsRepository getSeatsRepository() {
        return this.seatsRepository;
    }

    @Autowired
    public void setSeatsRepository(SeatsRepository seatsRepository) {
        this.seatsRepository = seatsRepository;
    }

    public AirflyRepository getAirflyRepository() {
        return this.airflyRepository;
    }

    @Autowired
    public void setAirflyRepository(AirflyRepository airflyRepository) {
        this.airflyRepository = airflyRepository;
    }

    public ModelMapper getModelMapper() {
        return this.modelMapper;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

	public List<SeatsDTO> getFreeSeatsForBudget(int airflyId, int passengerId) {
        Passenger passenger = passengerRepository.getById(passengerId);
        if (passenger == null) {
            return List.of();
        }

        int passengerBudget = passenger.getBudget();
        Airfly airfly = airflyRepository.getById(airflyId);
        if (airfly == null || airfly.getAirplane() == null) {
            return List.of();
        }

        Integer airplaneId = airfly.getAirplane().getId();
        List<Seats> freeSeats = seatsRepository.findFreeSeats(airplaneId, airflyId);
        if (freeSeats == null || freeSeats.size() == 0) {
            throw new NoFreeSeats(airplaneId);
        }

        List<SeatsDTO> affordableSeats = freeSeats.stream()
            .filter(seat -> seat.getPrice() <= passengerBudget)
            .map(seat -> modelMapper.map(seat, SeatsDTO.class))
            .collect(Collectors.toList());
        return affordableSeats;
    }
}