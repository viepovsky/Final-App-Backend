package com.backend.domain;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CARS_SERVICES")
public class CarService {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "repair_time")
    private int repairTimeInMinutes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Column(name = "service_status")
    private ServiceStatus status;

    public CarService(String name, String description, BigDecimal cost, int repairTimeInMinutes, Car car, User user, Booking booking, ServiceStatus status) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.repairTimeInMinutes = repairTimeInMinutes;
        this.car = car;
        this.user = user;
        this.booking = booking;
        this.status = status;
    }

    public CarService(String name, String description, BigDecimal cost, int repairTimeInMinutes, Car car, User user, ServiceStatus status) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.repairTimeInMinutes = repairTimeInMinutes;
        this.car = car;
        this.user = user;
        this.status = status;
    }
}
