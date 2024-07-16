package RUT.practice.Controller;

import RUT.practice.DTO.ServicesDTO;
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
    public ServicesDTO getServicesById(@PathVariable int id) {
        return servicesService.getById(id);
    }

    @GetMapping
    public List<ServicesDTO> getAllServices() {
        return servicesService.getAll();
    }

    @PostMapping
    public ServicesDTO createServices(@RequestBody ServicesDTO servicesDTO) {
        return servicesService.create(servicesDTO);
    }

    @PutMapping("/{id}")
    public ServicesDTO updateServices(@PathVariable int id, @RequestBody ServicesDTO servicesDTO) {
        servicesDTO.setId(id);
        return servicesService.update(servicesDTO);
    }
}