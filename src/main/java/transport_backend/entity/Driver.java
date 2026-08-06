package transport_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String driverName;

    @Column(unique = true)
    private String licenseNumber;

    private String phone;

    private String email;

    private String address;

    private int experience;

    private String status;
}