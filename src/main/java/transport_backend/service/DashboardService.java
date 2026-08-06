package transport_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transport_backend.dto.DashboardResponse;
import transport_backend.repository.*;

@Service
public class DashboardService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public DashboardResponse getDashboard() {

        return new DashboardResponse(
                vehicleRepository.count(),
                driverRepository.count(),
                customerRepository.count(),
                tripRepository.count(),
                bookingRepository.count(),
                paymentRepository.count()
        );
    }
}