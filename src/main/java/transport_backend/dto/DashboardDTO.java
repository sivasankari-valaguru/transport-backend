package transport_backend.dto;

public class DashboardDTO {

    private long totalVehicles;
    private long totalDrivers;
    private long totalCustomers;
    private long totalTrips;
    private long totalBookings;
    private long totalPayments;
    private double totalRevenue;

    // Default Constructor
    public DashboardDTO() {
    }

    // Parameterized Constructor
    public DashboardDTO(long totalVehicles,
                        long totalDrivers,
                        long totalCustomers,
                        long totalTrips,
                        long totalBookings,
                        long totalPayments,
                        double totalRevenue) {

        this.totalVehicles = totalVehicles;
        this.totalDrivers = totalDrivers;
        this.totalCustomers = totalCustomers;
        this.totalTrips = totalTrips;
        this.totalBookings = totalBookings;
        this.totalPayments = totalPayments;
        this.totalRevenue = totalRevenue;
    }

    public long getTotalVehicles() {
        return totalVehicles;
    }

    public void setTotalVehicles(long totalVehicles) {
        this.totalVehicles = totalVehicles;
    }

    public long getTotalDrivers() {
        return totalDrivers;
    }

    public void setTotalDrivers(long totalDrivers) {
        this.totalDrivers = totalDrivers;
    }

    public long getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(long totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    public long getTotalTrips() {
        return totalTrips;
    }

    public void setTotalTrips(long totalTrips) {
        this.totalTrips = totalTrips;
    }

    public long getTotalBookings() {
        return totalBookings;
    }

    public void setTotalBookings(long totalBookings) {
        this.totalBookings = totalBookings;
    }

    public long getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(long totalPayments) {
        this.totalPayments = totalPayments;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}