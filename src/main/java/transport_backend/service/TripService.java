package transport_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transport_backend.entity.Trip;
import transport_backend.repository.TripRepository;

import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepository repository;

    public List<Trip> getAllTrips() {
        return repository.findAll();
    }

    public Trip getTrip(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found"));
    }

    public Trip save(Trip trip) {
        return repository.save(trip);
    }

    public Trip update(Long id, Trip trip) {

        Trip old = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found"));

        old.setTripNumber(trip.getTripNumber());
        old.setSource(trip.getSource());
        old.setDestination(trip.getDestination());
        old.setTripDate(trip.getTripDate());
        old.setDistance(trip.getDistance());
        old.setAmount(trip.getAmount());
        old.setStatus(trip.getStatus());
        old.setVehicle(trip.getVehicle());
        old.setDriver(trip.getDriver());
        old.setCustomer(trip.getCustomer());

        return repository.save(old);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}