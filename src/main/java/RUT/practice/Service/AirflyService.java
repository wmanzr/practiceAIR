package RUT.practice.Service;

import RUT.practice.DTO.AirflyDTO;
import RUT.practice.Entity.Airfly;
import RUT.practice.Entity.Seats;
import RUT.practice.Repository.AirflyRepository;
import RUT.practice.Repository.SeatsRepository;
import RUT.practice.Service.AirflyService;

import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirflyService implements BaseService<AirflyDTO> {

    @Autowired
    private AirflyRepository airflyRepository;

    @Autowired
    private SeatsRepository seatsRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<Seats> getAvailableSeatsForNextAirfly(String departure, String arrival) {
        // Получаем текущую дату
        LocalDate currentDate = LocalDate.now();

        // Находим ближайший рейс из Москвы в Санкт-Петербург
        List<Airfly> upcomingAirflies = airflyRepository.findUpcomingAirfly(currentDate, departure, arrival);

        if (upcomingAirflies == null || upcomingAirflies.size() == 0) {
            // Если рейсов нет, возвращаем пустой список
            return List.of();
        }

        // Получаем первый (ближайший) рейс
        Airfly nextAirfly = upcomingAirflies.get(0);

        // Получаем ID самолета для этого рейса
        Integer airflyId = nextAirfly.getId();

        // Получаем ID самолета для этого рейса
        Integer airplaneId = nextAirfly.getAirplane().getId();

        // Находим все доступные места на этом самолете
        return seatsRepository.findFreeSeats(airplaneId, airflyId);
    }

    @Override
    public AirflyDTO create(AirflyDTO airflyDTO) {
        Airfly airfly = modelMapper.map(airflyDTO, Airfly.class);
        airfly = airflyRepository.create(airfly);
        return modelMapper.map(airfly, AirflyDTO.class);
    }

    @Override
    public List<AirflyDTO> getAll() {
        return airflyRepository.getAll().stream()
                .map(airfly -> modelMapper.map(airfly, AirflyDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AirflyDTO getById(int id) {
        Airfly airfly = airflyRepository.getById(id);
        return modelMapper.map(airfly, AirflyDTO.class);
    }

    @Override
    public AirflyDTO update(AirflyDTO airflyDTO) {
        Airfly airfly = modelMapper.map(airflyDTO, Airfly.class);
        airfly = airflyRepository.create(airfly);
        return modelMapper.map(airfly, AirflyDTO.class);
    }
}