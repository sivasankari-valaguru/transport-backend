package transport_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transport_backend.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}