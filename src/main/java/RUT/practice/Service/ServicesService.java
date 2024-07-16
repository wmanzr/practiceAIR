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
        Passenger passenger = passengerRepository.getById(passengerId);
        if (passenger == null) {
            return List.of();
        }
    
        List<Services> createdServices = new ArrayList<>();
        String healthStatus = passenger.getHealth();
        String preferences = passenger.getPreferences();

        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
    
        if (healthStatus != null) {
            if (healthStatus.contains("Инвалид") || healthStatus.contains("Лишен конечности") || healthStatus.contains("Заболевания головного мозга")) {
                createdServices.add(createSpecialService("Специальный", "Инвалидная коляска", passenger, currentDate, currentTime));
            }
            if (healthStatus.contains("Пожилой") || healthStatus.contains("Психологические отклонения")) {
                createdServices.add(createSpecialService("Специальный", "Сопровождение", passenger, currentDate, currentTime));
            }
            if (healthStatus.contains("Аллергия на лактозу")) {
                createdServices.add(createSpecialService("Питание", "Альтернативное молоко", passenger, currentDate, currentTime));
            }
            if (healthStatus.contains("Гастрит")) {
                createdServices.add(createSpecialService("Питание", "Обезжиренное", passenger, currentDate, currentTime));
            }
        }
    
        if (preferences != null) {
            if (preferences.contains("Рыба")) {
                createdServices.add(createSpecialService("Питание", "Рыба", passenger, currentDate, currentTime));
            }
            if (preferences.contains("Мясо")) {
                createdServices.add(createSpecialService("Питание", "Мясо", passenger, currentDate, currentTime));
            }
            if (preferences.contains("Крепкий кофе")) {
                createdServices.add(createSpecialService("Питание", "Крепкий кофе", passenger, currentDate, currentTime));
            }
        }
        return createdServices;
    }

    private Services createSpecialService(String type, String serv, Passenger passenger, LocalDate currentDate, LocalTime currentTime) {
        Services services = new Services();
        services.setType(type);
        services.setServ(serv);
        services.setDate(currentDate);
        services.setTime(currentTime);
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
