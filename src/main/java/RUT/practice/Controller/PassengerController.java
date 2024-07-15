package RUT.practice.Controller;

import RUT.practice.Entity.Passenger;
import RUT.practice.Service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers() {
        List<Passenger> passengers = passengerService.findAllPassenger();
        return ResponseEntity.ok().body(passengers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable("id") int id) {
        Passenger passenger = passengerService.findPassengerById(id);
        if (passenger != null) {
            return ResponseEntity.ok().body(passenger);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {
        Passenger createdPassenger = passengerService.savePassenger(passenger);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPassenger);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable("id") int id, @RequestBody Passenger passenger) {
        passenger.setId(id);
        Passenger updatedPassenger = passengerService.updatePassenger(passenger);
        if (updatedPassenger != null) {
            return ResponseEntity.ok().body(updatedPassenger);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable("id") int id) {
        passengerService.deletePassengerById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{passengerId}/provideSpecialServices")
    public ResponseEntity<Void> provideSpecialServices(@PathVariable("passengerId") int passengerId) {
        passengerService.ProvidingServicesSpecial(passengerId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{passengerId}/provideFoodServices")
    public ResponseEntity<Void> provideFoodServices(@PathVariable("passengerId") int passengerId) {
        passengerService.ProvidingServicesFood(passengerId);
        return ResponseEntity.ok().build();
    }
}
