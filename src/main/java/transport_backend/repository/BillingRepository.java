package transport_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transport_backend.entity.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long> {

}