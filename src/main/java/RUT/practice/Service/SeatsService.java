package RUT.practice.Service;

import RUT.practice.DTO.SeatsDTO;
import RUT.practice.Entity.Seats;
import RUT.practice.Repository.SeatsRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatsService implements BaseService<SeatsDTO> {

    @Autowired
    private SeatsRepository seatsRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SeatsDTO create(SeatsDTO seatsDTO) {
        Seats seats = modelMapper.map(seatsDTO, Seats.class);
        seats = seatsRepository.create(seats);
        return modelMapper.map(seats, SeatsDTO.class);
    }

    @Override
    public List<SeatsDTO> getAll() {
        return seatsRepository.getAll().stream()
            .map(airfly -> modelMapper.map(airfly, SeatsDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public SeatsDTO getById(int id) {
        Seats seats = seatsRepository.getById(id);
        return modelMapper.map(seats, SeatsDTO.class);
    }

    @Override
    public SeatsDTO update(SeatsDTO seatsDTO) {
        Seats seats = modelMapper.map(seatsDTO, Seats.class);
        seats = seatsRepository.create(seats);
        return modelMapper.map(seats, SeatsDTO.class);
    }

    public List<Seats> findFreeSeats(int airplaneId, int airflyId) {
        return seatsRepository.findFreeSeats(airplaneId, airflyId);
    }
}
