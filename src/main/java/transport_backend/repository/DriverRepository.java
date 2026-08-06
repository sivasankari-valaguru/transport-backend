package transport_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transport_backend.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {

}