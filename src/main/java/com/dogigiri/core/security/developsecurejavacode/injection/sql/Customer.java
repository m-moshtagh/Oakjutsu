package com.dogigiri.core.security.developsecurejavacode.injection.sql;

import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Customer {
    private int customerId;
    private String firstname;
    private String lastname;
    private LocalDate birthDate;
    private String phone;
    private String address;
    private String city;
    private String state;
    private int points;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getCustomerId() == customer.getCustomerId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCustomerId());
    }
}
