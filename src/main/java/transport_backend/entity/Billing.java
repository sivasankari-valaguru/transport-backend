package transport_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "billing")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String billNumber;

    private String customerName;

    private String bookingNumber;

    private Double amount;

    private Double gst;

    private Double totalAmount;

    private String paymentMode;

    private String paymentStatus;

    private LocalDate paymentDate;
}