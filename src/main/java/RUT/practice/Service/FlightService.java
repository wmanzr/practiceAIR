package RUT.practice.Service;

import RUT.practice.Repository.FlightRepository;
import RUT.practice.DTO.FlightDTO;
import RUT.practice.Entity.Flight;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService implements BaseService<FlightDTO> {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FlightDTO create(FlightDTO flightDTO) {
        Flight flight = modelMapper.map(flightDTO, Flight.class);
        flight = flightRepository.create(flight);
        return modelMapper.map(flight, FlightDTO.class);
    }

    @Override
    public List<FlightDTO> getAll() {
        return flightRepository.getAll().stream()
            .map(flight -> modelMapper.map(flight,FlightDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public FlightDTO getById(int id) {
        Flight flight = flightRepository.getById(id);
        return modelMapper.map(flight, FlightDTO.class);
    }

    @Override
    public FlightDTO update(FlightDTO flightDTO) {
        Flight flight = modelMapper.map(flightDTO, Flight.class);
        flight = flightRepository.create(flight);
        return modelMapper.map(flight, FlightDTO.class);
    }
}