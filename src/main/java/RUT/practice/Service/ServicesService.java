package RUT.practice.Service;

import RUT.practice.DTO.ServicesDTO;
import RUT.practice.Entity.Passenger;
import RUT.practice.Entity.Services;
import RUT.practice.Repository.ServicesRepository;
import RUT.practice.Repository.PassengerRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesService implements BaseService<ServicesDTO> {

    @Autowired
    private ServicesRepository servicesRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Services> createServiceByPassenger(int passengerId) {
        // Находим пассажира по его идентификатору
        Passenger passenger = passengerRepository.getById(passengerId);
        if (passenger == null) {
            // Если пассажир не найден, возвращаем пустой список
            return List.of();
        }
    
        List<Services> createdServices = new ArrayList<>();
        String healthStatus = passenger.getHealth();
        String preferences = passenger.getPreferences();
    
        // Создаем специальные услуги на основе здоровья пассажира
        if (healthStatus != null) {
            if (healthStatus.contains("Инвалид") || healthStatus.contains("Лишен конечности") || healthStatus.contains("Заболевания головного мозга")) {
                createdServices.add(createSpecialService("Специальный", "Инвалидная коляска", passenger));
            }
            if (healthStatus.contains("Пожилой") || healthStatus.contains("Психологические отклонения")) {
                createdServices.add(createSpecialService("Специальный", "Сопровождение", passenger));
            }
            if (healthStatus.contains("Аллергия на лактозу")) {
                createdServices.add(createSpecialService("Питание", "Альтернативное молоко", passenger));
            }
            if (healthStatus.contains("Гастрит")) {
                createdServices.add(createSpecialService("Питание", "Обезжиренное", passenger));
            }
        }
    
        // Создаем специальные услуги на основе предпочтений пассажира
        if (preferences != null) {
            if (preferences.contains("Рыба")) {
                createdServices.add(createSpecialService("Питание", "Рыба", passenger));
            }
            if (preferences.contains("Мясо")) {
                createdServices.add(createSpecialService("Питание", "Мясо", passenger));
            }
            if (preferences.contains("Крепкий кофе")) {
                createdServices.add(createSpecialService("Питание", "Крепкий кофе", passenger));
            }
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
    public ServicesDTO create(ServicesDTO servicesDTO) {
        Services services = modelMapper.map(servicesDTO, Services.class);
        services = servicesRepository.create(services);
        return modelMapper.map(services, ServicesDTO.class);
    }

    @Override
    public List<ServicesDTO> getAll() {
        return servicesRepository.getAll().stream()
                .map(services -> modelMapper.map(services, ServicesDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ServicesDTO getById(int id) {
        Services services = servicesRepository.getById(id);
        return modelMapper.map(services, ServicesDTO.class);
    }

    @Override
    public ServicesDTO update(ServicesDTO servicesDTO) {
        Services services = modelMapper.map(servicesDTO, Services.class);
        services = servicesRepository.create(services);
        return modelMapper.map(services, ServicesDTO.class);
    }
}
