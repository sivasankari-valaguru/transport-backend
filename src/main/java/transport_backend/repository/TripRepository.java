package transport_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transport_backend.entity.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {
}