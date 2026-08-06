package transport_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transport_backend.entity.Payment;
import transport_backend.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public List<Payment> getAllPayments() {
        return repository.findAll();
    }

    public Payment getPayment(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment Not Found"));
    }

    public Payment savePayment(Payment payment) {
        return repository.save(payment);
    }

    public Payment updatePayment(Long id, Payment payment) {

        Payment old = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment Not Found"));

        old.setPaymentNumber(payment.getPaymentNumber());
        old.setAmount(payment.getAmount());
        old.setPaymentMethod(payment.getPaymentMethod());
        old.setPaymentStatus(payment.getPaymentStatus());
        old.setPaymentDate(payment.getPaymentDate());
        old.setBooking(payment.getBooking());

        return repository.save(old);
    }

    public void deletePayment(Long id) {
        repository.deleteById(id);
    }
}