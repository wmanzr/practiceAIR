package RUT.practice.Service;

import RUT.practice.Entity.Airfly;
import RUT.practice.Entity.Seats;
import RUT.practice.Repository.AirflyRepository;
import RUT.practice.Repository.SeatsRepository;
import RUT.practice.Service.AirflyService;

import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirflyService implements BaseService<Airfly> {

    @Autowired
    private AirflyRepository airflyRepository;

    @Autowired
    private SeatsRepository seatsRepository;

    public List<Seats> getAvailableSeatsForNextAirfly(String departure, String arrival) {
        // Получаем текущую дату
        LocalDate currentDate = LocalDate.now();

        // Находим ближайший рейс из Москвы в Санкт-Петербург
        List<Airfly> upcomingFlights = airflyRepository.findUpcomingAirfly(currentDate, departure, arrival);

        if (upcomingFlights.isEmpty()) {
            // Если рейсов нет, возвращаем пустой список
            return List.of();
        }

        // Получаем первый (ближайший) рейс
        Airfly nextFlight = upcomingFlights.get(0);

        // Получаем ID самолета для этого рейса
        Integer airplaneId = nextFlight.getAirplane().getId();

        // Находим все доступные места на этом самолете
        return seatsRepository.findFreeSeats(airplaneId);
    }

    public Airfly create(Airfly entity) {
		return airflyRepository.create(entity);
	}

	public List<Airfly> getAll() {
	return airflyRepository.getAll();
	}

	public Airfly getById(int id) {
		return airflyRepository.getById(id);
	}

	public Airfly update(Airfly entity) {
		return airflyRepository.update(entity);
	}
}