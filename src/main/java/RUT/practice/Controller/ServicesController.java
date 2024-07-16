package RUT.practice.Controller;

import RUT.practice.Entity.Services;
import RUT.practice.Service.ServicesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServicesController {

    @Autowired
    private ServicesService servicesService;

    @GetMapping("/create-services")
    public List<Services> createServiceByPassenger(@RequestParam int passengerId) {
        return servicesService.createServiceByPassenger(passengerId);
    }

    @GetMapping("/{id}")
    public Services getServicesById(@PathVariable int id) {
        return servicesService.getById(id);
    }

    @GetMapping
    public List<Services> getAllServices() {
        return servicesService.getAll();
    }

    @PostMapping
    public Services createServices(@RequestBody Services services) {
        return servicesService.create(services);
    }

    @PutMapping("/{id}")
    public Services updateServices(@PathVariable int id, @RequestBody Services services) {
        services.setId(id);
        return servicesService.update(services);
    }
}