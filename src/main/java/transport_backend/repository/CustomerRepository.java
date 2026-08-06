package transport_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transport_backend.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

}