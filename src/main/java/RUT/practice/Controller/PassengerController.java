package RUT.practice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import RUT.practice.DTO.PassengerDTO;
import RUT.practice.DTO.SeatsDTO;
import RUT.practice.Service.PassengerService;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping("/budget")
    public List<SeatsDTO> getFreeSeatsForBudget(@RequestParam int airflyId, @RequestParam int passengerId) {
        return passengerService.getFreeSeatsForBudget(airflyId, passengerId);
    }

    @GetMapping("/{id}")
    public PassengerDTO getPassengerById(@PathVariable int id) {
        return passengerService.getById(id);
    }

    @GetMapping
    public List<PassengerDTO> getAllPassengers() {
        return passengerService.getAll();
    }

    @PostMapping
    public PassengerDTO createPassenger(@RequestBody PassengerDTO passengerDTO) {
        return passengerService.create(passengerDTO);
    }

    @PutMapping("/{id}")
    public PassengerDTO updatePassenger(@PathVariable int id, @RequestBody PassengerDTO passengerDTO) {
        passengerDTO.setId(id);
        return passengerService.update(passengerDTO);
    }
}