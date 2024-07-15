package RUT.practice.Controller;

import RUT.practice.Entity.Seats;
import RUT.practice.Service.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatsController {

    @Autowired
    private SeatsService seatsService;

    @GetMapping
    public ResponseEntity<List<Seats>> getAllSeats() {
        List<Seats> seatsList = seatsService.findAllSeats();
        return ResponseEntity.ok().body(seatsList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seats> getSeatById(@PathVariable("id") int id) {
        Seats seats = seatsService.findSeatsById(id);
        if (seats != null) {
            return ResponseEntity.ok().body(seats);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Seats> createSeat(@RequestBody Seats seats) {
        Seats createdSeat = seatsService.saveSeats(seats);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSeat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Seats> updateSeat(@PathVariable("id") int id, @RequestBody Seats seats) {
        seats.setId(id);
        Seats updatedSeat = seatsService.updateSeats(seats);
        if (updatedSeat != null) {
            return ResponseEntity.ok().body(updatedSeat);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeat(@PathVariable("id") int id) {
        seatsService.deleteSeatsById(id);
        return ResponseEntity.noContent().build();
    }
}

