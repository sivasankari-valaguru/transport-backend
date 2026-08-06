package transport_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transport_backend.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}