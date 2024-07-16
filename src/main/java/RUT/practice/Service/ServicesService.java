package RUT.practice.Service;

import RUT.practice.Entity.Passenger;
import RUT.practice.Entity.Services;
import RUT.practice.Repository.ServicesRepository;
import RUT.practice.Repository.PassengerRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesService implements BaseService<Services> {

    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    public List<Services> createServiceByPassenger(int passengerId) {
    // Находим пассажира по его идентификатору
    Passenger passenger = passengerRepository.getById(passengerId);
    if (passenger == null) {
        // Если пассажир не найден, возвращаем пустой список
        return List.of();
    }

    List<Services> createdServices = new ArrayList<>();

    // Анализируем данные пассажира и создаем соответствующие записи в таблице Services

    // Проверяем здоровье пассажира
    String healthStatus = passenger.getHealth();
    String preferences = passenger.getPreferences();

    if (healthStatus != null && (healthStatus.contains("Инвалид") || healthStatus.contains("Лишен конечности") || healthStatus.contains("Заболевания головного мозга"))) {
        createdServices.add(createSpecialService("специальный", "Инвалидная коляска", passenger));
    } else if (healthStatus != null && (healthStatus.contains("Пожилой") || healthStatus.contains("Психологические отклонения"))) {
        createdServices.add(createSpecialService("специальный", "Сопровождение", passenger));
    }

    // Проверяем предпочтения пассажира
    if (preferences != null) {
        if (preferences.contains("Рыба")) {
            createdServices.add(createSpecialService("питание", "Рыба", passenger));
        } else if (preferences.contains("Мясо")) {
            createdServices.add(createSpecialService("питание", "Мясо", passenger));
        } else if (preferences.contains("Крепкий кофе")) {
            createdServices.add(createSpecialService("питание", "Крепкий кофе", passenger));
        }
    }

    // Дополнительные условия
    if (healthStatus != null && healthStatus.contains("Аллергия на лактозу")) {
        createdServices.add(createSpecialService("питание", "Альтернативное молоко", passenger));
    } else if (healthStatus != null && healthStatus.contains("гастрит")) {
        createdServices.add(createSpecialService("питание", "обезжиренное", passenger));
    }

    return createdServices;
}

private Services createSpecialService(String type, String serv, Passenger passenger) {
    Services services = new Services();
    services.setType(type);
    services.setServ(serv);
    services.setDate(LocalDate.now());
    services.setTime(LocalTime.now());
    services.setPassenger(passenger);

    return servicesRepository.create(services);
}

    @Override
    public Services create(Services entity) {
		return servicesRepository.create(entity);
	}

    @Override
	public List<Services> getAll() {
	return servicesRepository.getAll();
	}

    @Override
	public Services getById(int id) {
		return servicesRepository.getById(id);
	}

    @Override
	public Services update(Services entity) {
		return servicesRepository.update(entity);
	}
}
