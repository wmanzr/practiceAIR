package RUT.practice.Service.Impl;

import RUT.practice.Entity.Passenger;
import RUT.practice.Entity.Services;
import RUT.practice.Repository.PassengerRepository;
import RUT.practice.Repository.ServicesRepository;
import RUT.practice.Service.ServicesService;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicesServiceImpl implements ServicesService {

    private PassengerRepository passengerRepository;
    private ServicesRepository servicesRepository;

    public PassengerRepository getPassengerRepository() {
        return this.passengerRepository;
    }

    @Autowired
    public void setPassengerRepository(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public ServicesRepository getServicesRepository() {
        return this.servicesRepository;
    }

    @Autowired
    public void setServicesRepository(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    @Override
    @Transactional
    public List<Services> createServiceByPassenger(int passengerId) {
        Passenger passenger = passengerRepository.getById(passengerId);
        if (passenger == null) {
            return List.of();
        }
    
        List<Services> createdServices = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
    
        addHealthBasedServices(createdServices, passenger, currentDate, currentTime);
        addPreferenceBasedServices(createdServices, passenger, currentDate, currentTime);

        return createdServices;
    }

    private void addHealthBasedServices(List<Services> services, Passenger passenger, LocalDate currentDate, LocalTime currentTime) {
        String healthStatus = passenger.getHealth();
        if (healthStatus == null) return;

        if (healthStatus.contains("Инвалид") || healthStatus.contains("Лишен конечности") || healthStatus.contains("Заболевания головного мозга")) {
            services.add(createSpecialService("Специальный", "Инвалидная коляска", passenger, currentDate, currentTime));
        }
        if (healthStatus.contains("Пожилой") || healthStatus.contains("Психологические отклонения")) {
            services.add(createSpecialService("Специальный", "Сопровождение", passenger, currentDate, currentTime));
        }
        if (healthStatus.contains("Аллергия на лактозу")) {
            services.add(createSpecialService("Питание", "Альтернативное молоко", passenger, currentDate, currentTime));
        }
        if (healthStatus.contains("Гастрит")) {
            services.add(createSpecialService("Питание", "Обезжиренное", passenger, currentDate, currentTime));
        }
    }

    private void addPreferenceBasedServices(List<Services> services, Passenger passenger, LocalDate currentDate, LocalTime currentTime) {
        String preferences = passenger.getPreferences();
        if (preferences == null) return;

        if (preferences.contains("Рыба")) {
            services.add(createSpecialService("Питание", "Рыба", passenger, currentDate, currentTime));
        }
        if (preferences.contains("Мясо")) {
            services.add(createSpecialService("Питание", "Мясо", passenger, currentDate, currentTime));
        }
        if (preferences.contains("Крепкий кофе")) {
            services.add(createSpecialService("Питание", "Крепкий кофе", passenger, currentDate, currentTime));
        }
    }

    private Services createSpecialService(String type, String serv, Passenger passenger, LocalDate currentDate, LocalTime currentTime) {
        Services services = new Services();
        services.setType(type);
        services.setServ(serv);
        services.setDate(currentDate);
        services.setTime(currentTime);
        services.setPassenger(passenger);

        servicesRepository.create(services);
        return services;
    }
}