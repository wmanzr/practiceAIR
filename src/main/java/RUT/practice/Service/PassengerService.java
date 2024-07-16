package RUT.practice.Service;

import RUT.practice.DTO.PassengerDTO;
import RUT.practice.Entity.Airfly;
import RUT.practice.Entity.Passenger;
import RUT.practice.Entity.Seats;
import RUT.practice.Exception.NoFreeSeats;
import RUT.practice.DTO.SeatsDTO;
import RUT.practice.Repository.PassengerRepository;
import RUT.practice.Repository.SeatsRepository;
import RUT.practice.Repository.AirflyRepository;
import RUT.practice.Service.PassengerService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PassengerService implements BaseService<PassengerDTO> {

    @Autowired
    private PassengerRepository passengerRepository;

	@Autowired
    private SeatsRepository seatsRepository;

	@Autowired
    private AirflyRepository airflyRepository;

    @Autowired
    private ModelMapper modelMapper;

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

    @Override
    public PassengerDTO create(PassengerDTO passengerDTO) {
        Passenger passenger = modelMapper.map(passengerDTO, Passenger.class);
        passenger = passengerRepository.create(passenger);
        return modelMapper.map(passenger, PassengerDTO.class);
    }

    @Override
    public List<PassengerDTO> getAll() {
        return passengerRepository.getAll().stream()
            .map(passenger -> modelMapper.map(passenger, PassengerDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public PassengerDTO getById(int id) {
        Passenger passenger = passengerRepository.getById(id);
        return modelMapper.map(passenger, PassengerDTO.class);
    }

    @Override
    public PassengerDTO update(PassengerDTO passengerDTO) {
        Passenger passenger = modelMapper.map(passengerDTO, Passenger.class);
        passenger = passengerRepository.create(passenger);
        return modelMapper.map(passenger, PassengerDTO.class);
    }
}