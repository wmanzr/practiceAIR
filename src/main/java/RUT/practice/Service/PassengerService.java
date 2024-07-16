package RUT.practice.Service;

import RUT.practice.DTO.PassengerDTO;
import RUT.practice.Entity.Airfly;
import RUT.practice.Entity.Passenger;
import RUT.practice.Entity.Seats;
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
        // Находим пассажира по его идентификатору
        Passenger passenger = passengerRepository.getById(passengerId);
        if (passenger == null) {
            return List.of(); // Если пассажир не найден, возвращаем пустой список мест
        }
        // Получаем бюджет пассажира
        int passengerBudget = passenger.getBudget();
        // Находим самолет для указанного полёта
        Airfly airfly = airflyRepository.getById(airflyId);
        if (airfly == null || airfly.getAirplane() == null) {
            return List.of(); // Если полёт не найден или у него нет самолета, возвращаем пустой список мест
        }
        // Получаем ID самолета для указанного рейса
        Integer airplaneId = airfly.getAirplane().getId();
        // Находим все свободные места на указанном самолете
        List<Seats> freeSeats = seatsRepository.findFreeSeats(airplaneId, airflyId);
        if (freeSeats == null) {
            return List.of(); // Если свободные места не найдены, возвращаем пустой список
        }
        // Отбираем только те места, чья стоимость меньше или равна бюджету пассажира
        List<SeatsDTO> affordableSeats = freeSeats.stream()
            .filter(seat -> seat.getPrice() <= passengerBudget)
            .map(seat -> modelMapper.map(seat, SeatsDTO.class)) // Преобразуем Seats в SeatsDTO
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