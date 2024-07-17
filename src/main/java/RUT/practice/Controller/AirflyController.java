package RUT.practice.Controller;

import RUT.practice.DTO.SeatsDTO;
import RUT.practice.Service.Impl.AirflyServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airflies")
public class AirflyController {

    @Autowired
    private AirflyServiceImpl airflyService;

    @GetMapping("/free-seats")
    public List<SeatsDTO> getAvailableSeats(@RequestParam String departure, @RequestParam String arrival) {
        return airflyService.getAvailableSeatsForNextAirfly(departure, arrival);
    }
}
