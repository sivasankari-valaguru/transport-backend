package transport_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transport_backend.entity.Vehicle;
import transport_backend.repository.VehicleRepository;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }
    public Vehicle getVehicleById(Long id) {
    return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Vehicle not found"));
}

    public Vehicle saveVehicle(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        Vehicle old = repository.findById(id).orElseThrow();

        old.setVehicleNumber(vehicle.getVehicleNumber());
        old.setVehicleName(vehicle.getVehicleName());
        old.setVehicleType(vehicle.getVehicleType());
        old.setModel(vehicle.getModel());
        old.setCapacity(vehicle.getCapacity());
        old.setFuelType(vehicle.getFuelType());
        old.setStatus(vehicle.getStatus());

        return repository.save(old);
    }

    public void deleteVehicle(Long id) {
        repository.deleteById(id);
    }
}