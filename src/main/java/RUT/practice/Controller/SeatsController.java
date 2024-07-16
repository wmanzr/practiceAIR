package RUT.practice.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import RUT.practice.DTO.SeatsDTO;
import RUT.practice.Service.SeatsService;

@RestController
@RequestMapping("/api/seats")
public class SeatsController {
@Autowired
    private SeatsService seatsService;

    @GetMapping("/{id}")
    public SeatsDTO getSeatsById(@PathVariable int id) {
        return seatsService.getById(id);
    }

    @GetMapping
    public List<SeatsDTO> getAllSeats() {
        return seatsService.getAll();
    }

    @PostMapping
    public SeatsDTO createSeats(@RequestBody SeatsDTO seatsDTO) {
        return seatsService.create(seatsDTO);
    }

    @PutMapping("/{id}")
    public SeatsDTO updateSeats(@PathVariable int id, @RequestBody SeatsDTO seatsDTO) {
        seatsDTO.setId(id);
        return seatsService.update(seatsDTO);
    }
}