package transport_backend.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponse {

    private long totalVehicles;
    private long totalDrivers;
    private long totalCustomers;
    private long totalTrips;
    private long totalBookings;
    private long totalPayments;
}