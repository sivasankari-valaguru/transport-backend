package transport_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transport_backend.entity.Driver;
import transport_backend.repository.DriverRepository;
import java.util.List;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repository;

    public List<Driver> getAllDrivers() {
        return repository.findAll();
    }

    public Driver getDriverById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    public Driver saveDriver(Driver driver) {
        return repository.save(driver);
    }

    public Driver updateDriver(Long id, Driver driver) {

        Driver old = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        old.setDriverName(driver.getDriverName());
        old.setLicenseNumber(driver.getLicenseNumber());
        old.setPhone(driver.getPhone());
        old.setEmail(driver.getEmail());
        old.setAddress(driver.getAddress());
        old.setExperience(driver.getExperience());
        old.setStatus(driver.getStatus());

        return repository.save(old);
    }

    public void deleteDriver(Long id) {
        repository.deleteById(id);
    }
}