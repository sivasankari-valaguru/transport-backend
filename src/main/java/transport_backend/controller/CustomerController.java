package transport_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import transport_backend.entity.Customer;
import transport_backend.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins="http://localhost:5173")
public class CustomerController {

    @Autowired
    CustomerService service;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return service.getCustomer(id);
    }

    @PostMapping
    public Customer save(@RequestBody Customer customer){
        return service.save(customer);
    }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Long id,@RequestBody Customer customer){
        return service.update(id,customer);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.delete(id);
        return "Customer Deleted Successfully";
    }

}