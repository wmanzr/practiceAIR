package RUT.practice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import RUT.practice.Entity.Passenger;
import RUT.practice.Entity.Seats;
import RUT.practice.Service.PassengerService;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping("/budget")
    public List<Seats> getFreeSeatsForBudget(@RequestParam int airflyId, @RequestParam int passengerId) {
        return passengerService.getFreeSeatsForBudget(airflyId, passengerId);
    }

    @GetMapping("/{id}")
    public Passenger getPassengerById(@PathVariable int id) {
        return passengerService.getById(id);
    }

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.getAll();
    }

    @PostMapping
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passengerService.create(passenger);
    }

    @PutMapping("/{id}")
    public Passenger updatePassenger(@PathVariable int id, @RequestBody Passenger passenger) {
        passenger.setId(id);
        return passengerService.update(passenger);
    }
}