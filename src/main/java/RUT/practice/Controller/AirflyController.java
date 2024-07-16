package RUT.practice.Controller;

import RUT.practice.DTO.AirflyDTO;
import RUT.practice.Entity.Seats;
import RUT.practice.Service.AirflyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airflies")
public class AirflyController {

    @Autowired
    private AirflyService airflyService;

    @GetMapping("/free-seats")
    public List<Seats> getAvailableSeats(@RequestParam String departure, @RequestParam String arrival) {
        return airflyService.getAvailableSeatsForNextAirfly(departure, arrival);
    }

    @GetMapping("/{id}")
    public AirflyDTO getAirflyById(@PathVariable int id) {
        return airflyService.getById(id);
    }

    @GetMapping
    public List<AirflyDTO> getAllAirflies() {
        return airflyService.getAll();
    }

    @PostMapping
    public AirflyDTO createAirfly(@RequestBody AirflyDTO airflyDTO) {
        return airflyService.create(airflyDTO);
    }

    @PutMapping("/{id}")
    public AirflyDTO updateAirfly(@PathVariable int id, @RequestBody AirflyDTO airflyDTO) {
        airflyDTO.setId(id);
        return airflyService.update(airflyDTO);
    }
}
