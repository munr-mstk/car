package com.munirmustakoglu.car.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass   //Bu sınıfı extend eden  bütün tablolara kolon olarak yansıması için
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @Column(name ="create_time")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  //Hem gün ay yıl hem saat dakika saat formatında
    private Date createTime;
}
