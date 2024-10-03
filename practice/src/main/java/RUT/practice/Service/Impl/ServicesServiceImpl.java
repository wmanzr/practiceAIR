package RUT.practice.Service.Impl;

import RUT.practice.Entity.Passenger;
import RUT.practice.Entity.Services;
import RUT.practice.Service.ServicesService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ServicesServiceImpl implements ServicesService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Services> createServiceByPassenger(int passengerId) {
        Passenger passenger = entityManager.find(Passenger.class, passengerId);
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

        entityManager.persist(services);
        return services;
    }
}