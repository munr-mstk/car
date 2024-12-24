package com.munirmustakoglu.car.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gallerist_car",
uniqueConstraints = {@UniqueConstraint(columnNames = {"gallerist_id","car_id"},name = "uq_gallerist_car")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GalleristsCar extends BaseEntity {

    @ManyToOne       //1 galeri 1 den fazla araba satabilir
    private  Gallerist gallerist;

    @ManyToOne
    private Car car;
}
