package RUT.practice.Service;

import RUT.practice.Entity.Airfly;
import RUT.practice.Entity.Passenger;
import RUT.practice.Entity.Seats;
import RUT.practice.Repository.PassengerRepository;
import RUT.practice.Repository.SeatsRepository;
import RUT.practice.Repository.AirflyRepository;
import RUT.practice.Service.PassengerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PassengerService implements BaseService<Passenger> {

    @Autowired
    private PassengerRepository passengerRepository;

	@Autowired
    private SeatsRepository seatsRepository;

	@Autowired
    private AirflyRepository airflyRepository;

	public List<Seats> getFreeSeatsForBudget(int airflyId, int passengerId) {
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
        List<Seats> affordableSeats = freeSeats.stream()
                .filter(seat -> seat.getPrice() <= passengerBudget)
                .collect(Collectors.toList());

        return affordableSeats;
    }
    
    @Override
    public Passenger create(Passenger entity) {
		return passengerRepository.create(entity);
	}

    @Override
	public List<Passenger> getAll() {
		return passengerRepository.getAll();
	}

    @Override
	public Passenger getById(int id) {
		return passengerRepository.getById(id);
	}

    @Override
	public Passenger update(Passenger entity) {
		return passengerRepository.update(entity);
	}
}