package transport_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transport_backend.entity.Booking;
import transport_backend.repository.BookingRepository;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository repository;

    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    public Booking getBooking(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking Not Found"));
    }

    public Booking saveBooking(Booking booking) {
        return repository.save(booking);
    }

    public Booking updateBooking(Long id, Booking booking) {

        Booking old = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking Not Found"));

        old.setBookingNumber(booking.getBookingNumber());
        old.setBookingDate(booking.getBookingDate());
        old.setPickupLocation(booking.getPickupLocation());
        old.setDropLocation(booking.getDropLocation());
        old.setFreightAmount(booking.getFreightAmount());
        old.setPaymentStatus(booking.getPaymentStatus());
        old.setBookingStatus(booking.getBookingStatus());
        old.setCustomer(booking.getCustomer());
        old.setTrip(booking.getTrip());

        return repository.save(old);
    }

    public void deleteBooking(Long id) {
        
        repository.deleteById(id);
    }
}