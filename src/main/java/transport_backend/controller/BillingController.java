package transport_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import transport_backend.entity.Billing;
import transport_backend.service.BillingService;

import java.util.List;

@RestController
@RequestMapping("/api/billing")
@CrossOrigin(origins = "http://localhost:5173")
public class BillingController {

    @Autowired
    private BillingService service;

    @GetMapping
    public List<Billing> getAllBills() {
        return service.getAllBills();
    }
 
    @GetMapping("/{id}")
    public Billing getBill(@PathVariable Long id) {
        return service.getBillById(id);
    }

    @PostMapping
    public Billing addBill(@RequestBody Billing billing) {
        return service.saveBill(billing);
    }

    @PutMapping("/{id}")
    public Billing updateBill(@PathVariable Long id, @RequestBody Billing billing) {
        return service.updateBill(id, billing);
    }

    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Long id) {
        service.deleteBill(id);
    }
}