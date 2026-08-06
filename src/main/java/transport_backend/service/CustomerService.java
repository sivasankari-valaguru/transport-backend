package transport_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transport_backend.entity.Customer;
import transport_backend.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }

    public Customer getCustomer(Long id){
        return repository.findById(id).orElseThrow();
    }

    public Customer save(Customer customer){
        return repository.save(customer);
    }

    public Customer update(Long id,Customer customer){

        Customer old=repository.findById(id).orElseThrow();

        old.setCustomerName(customer.getCustomerName());
        old.setCompanyName(customer.getCompanyName());
        old.setPhone(customer.getPhone());
        old.setEmail(customer.getEmail());
        old.setAddress(customer.getAddress());
        old.setCity(customer.getCity());
        old.setStatus(customer.getStatus());

        return repository.save(old);
    }

    public void delete(Long id){
        
        repository.deleteById(id);
    }

}