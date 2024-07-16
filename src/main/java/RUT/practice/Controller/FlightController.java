package RUT.practice.Controller;

import RUT.practice.DTO.FlightDTO;
import RUT.practice.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/{id}")
    public FlightDTO getFlightById(@PathVariable int id) {
        return flightService.getById(id);
    }

    @GetMapping
    public List<FlightDTO> getAllFlights() {
        return flightService.getAll();
    }

    @PostMapping
    public FlightDTO createFlight(@RequestBody FlightDTO flightDTO) {
        return flightService.create(flightDTO);
    }

    @PutMapping("/{id}")
    public FlightDTO updateFlight(@PathVariable int id, @RequestBody FlightDTO flightDTO) {
        flightDTO.setId(id);
        return flightService.update(flightDTO);
    }
}
