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

        entityManager.persist(services);
        return services;
    }
}