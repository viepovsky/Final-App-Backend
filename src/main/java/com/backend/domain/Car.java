package com.backend.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CARS")
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "make")
    private String make;

    @Column(name = "model")
    private String model;

    @Column(name = "production_year")
    private int year;

    @Column(name = "type")
    private String type;

    @Column(name = "engine")
    private String engine;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(
            targetEntity = CarService.class,
            mappedBy = "car",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<CarService> carServicesList = new ArrayList<>();

    public Car(Long id, String make, String model, String type, int year, String engine) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.type = type;
        this.year = year;
        this.engine = engine;
    }

    public Car(String make, String model, String type, int year, String engine) {
        this.make = make;
        this.model = model;
        this.type = type;
        this.year = year;
        this.engine = engine;
    }
}
