package transport_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import transport_backend.entity.Vehicle;
import transport_backend.service.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@CrossOrigin(origins = "http://localhost:5173")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return service.getAllVehicles();
    }
    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
          return service.getVehicleById(id);
}

    @PostMapping
    public Vehicle save(@RequestBody Vehicle vehicle) {
        return service.saveVehicle(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle update(@PathVariable Long id,
                          @RequestBody Vehicle vehicle) {
        return service.updateVehicle(id, vehicle);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteVehicle(id);
        return "Vehicle Deleted Successfully";
    }
}