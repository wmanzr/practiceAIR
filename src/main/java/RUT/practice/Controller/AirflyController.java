package RUT.practice.Controller;

import RUT.practice.Entity.Airfly;
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

    @GetMapping("/{id}")
    public Airfly getAirflyById(@PathVariable int id) {
        return airflyService.findAirflyById(id);
    }

    @GetMapping
    public List<Airfly> getAllAirflies() {
        return airflyService.findAllAirflies();
    }

    @GetMapping("/status")
    public List<Airfly> getAirfliesByStatus(@RequestParam String status) {
        return airflyService.findAllByStatus(status);
    }

    @GetMapping("/seats")
    public List<Seats> getSeatsByFlight(@RequestParam String departure, @RequestParam String arrival) {
        return airflyService.findSeatsByFlight(departure, arrival);
    }

    @PostMapping
    public Airfly createAirfly(@RequestBody Airfly airfly) {
        return airflyService.saveAirfly(airfly);
    }

    @PutMapping("/{id}")
    public Airfly updateAirfly(@PathVariable int id, @RequestBody Airfly airfly) {
        airfly.setId(id);
        return airflyService.updateAirfly(airfly);
    }

    @DeleteMapping("/{id}")
    public void deleteAirfly(@PathVariable int id) {
        airflyService.deleteAirflyById(id);
    }
}
