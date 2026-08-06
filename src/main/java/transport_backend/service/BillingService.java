package transport_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transport_backend.entity.Billing;
import transport_backend.repository.BillingRepository;

import java.util.List;

@Service
public class BillingService {

    @Autowired
    private BillingRepository repository;

    public List<Billing> getAllBills() {
        return repository.findAll();
    }

    public Billing getBillById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Billing saveBill(Billing billing) {
        return repository.save(billing);
    }

    public Billing updateBill(Long id, Billing billing) {
        billing.setId(id);
        return repository.save(billing);
    }

    public void deleteBill(Long id) {
        repository.deleteById(id);
    }
}