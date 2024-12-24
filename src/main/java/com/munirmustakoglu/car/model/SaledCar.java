package com.munirmustakoglu.car.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "saled_car",
uniqueConstraints = {@UniqueConstraint(columnNames = {"gallerist_id", "car_id","customer_id"},name = "uq_gallerist_car_customer")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaledCar extends BaseEntity{  //şu galerinin şu arabasını şu müşteri almıştır

    @ManyToOne
    private Gallerist gallerist;

    @ManyToOne
    private Car car;

    @ManyToOne
    private Customer customer;
}
