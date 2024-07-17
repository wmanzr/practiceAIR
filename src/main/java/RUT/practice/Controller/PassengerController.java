package RUT.practice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import RUT.practice.DTO.SeatsDTO;
import RUT.practice.Service.Impl.PassengerServiceImpl;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private PassengerServiceImpl passengerService;

    @GetMapping("/budget")
    public List<SeatsDTO> getFreeSeatsForBudget(@RequestParam int airflyId, @RequestParam int passengerId) {
        return passengerService.getFreeSeatsForBudget(airflyId, passengerId);
    }
}