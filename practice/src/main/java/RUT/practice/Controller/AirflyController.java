package RUT.practice.Controller;

import RUT.practice.DTO.SeatsDTO;
import RUT.practice.Service.AirflyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airflies")
public class AirflyController {

    private AirflyService airflyService;

    public AirflyService getAirflyService() {
        return this.airflyService;
    }

    @Autowired
    public void setAirflyService(AirflyService airflyService) {
        this.airflyService = airflyService;
    }

    @GetMapping("/free-seats")
    public List<SeatsDTO> getAvailableSeats(@RequestParam String departure, @RequestParam String arrival) {
        return airflyService.getAvailableSeatsForNextAirfly(departure, arrival);
    }
}
