package com.munirmustakoglu.car.model;

import com.munirmustakoglu.car.enums.CarStatusType;
import com.munirmustakoglu.car.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car  extends BaseEntity{

    @Column(name = "plaka")
    private String plaka;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "productionYear")
    private Integer productionYear;

    @Column(name = "price")
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(name = "currencyType")
    private CurrencyType currencyType;

    @Column(name = "damagePrice")
    private BigDecimal damagePrice;

    @Column(name = "carStatusType")
    @Enumerated(EnumType.STRING) //satılmışmı satılmamış mı
    private CarStatusType carStatusType;
}
