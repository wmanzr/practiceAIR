package RUT.practice.Controller;

import RUT.practice.Entity.Services;
import RUT.practice.Service.ServicesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServicesController {

    private ServicesService servicesService;

    public ServicesService getServicesService() {
        return this.servicesService;
    }

    @Autowired
    public void setServicesService(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @GetMapping("/create-services")
    public List<Services> createServiceByPassenger(@RequestParam int passengerId) {
        return servicesService.createServiceByPassenger(passengerId);
    }
}