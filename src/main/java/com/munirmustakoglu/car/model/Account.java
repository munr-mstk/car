package com.munirmustakoglu.car.model;

import com.munirmustakoglu.car.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Currency;

@Entity
@Table(name = "Account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity {

    @Column(name = "account_no")
    private String accountNo;
    @Column(name = "iban")
    private String iban;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "currency_type")
    @Enumerated(EnumType.STRING) // tl secildiğinde db ye tl veya usd seçildiğinde db ye usd olarak yansır
    private CurrencyType currencyType;


}
