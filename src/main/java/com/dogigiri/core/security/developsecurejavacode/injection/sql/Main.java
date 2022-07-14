package com.dogigiri.core.security.developsecurejavacode.injection.sql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String validCity = "Hampton";
        String invalidCity = "\\drop table products";
        String validOrderBy = "first_name";
        String invalidOrderBy = "Load";
        getCustomerByCity(validCity, validOrderBy).forEach(customer -> LOGGER.info("{}", customer));
    }

    private static List<Customer> getCustomerByCity(String city, String orderBy) {
        List<Customer> result = new ArrayList<>();
        try (CustomerDa customerDa = new CustomerDa()) {
            result = customerDa.selectByCity(city, orderBy);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
