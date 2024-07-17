package RUT.practice.Controller;

import RUT.practice.Entity.Services;
import RUT.practice.Service.Impl.ServicesServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {

    @Autowired
    private ServicesServiceImpl servicesService;

    @GetMapping("/create-services")
    public List<Services> createServiceByPassenger(@RequestParam int passengerId) {
        return servicesService.createServiceByPassenger(passengerId);
    }
}