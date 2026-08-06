package transport_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentNumber;

    private Double amount;

    private String paymentMethod;

    private String paymentStatus;

    private LocalDate paymentDate;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}