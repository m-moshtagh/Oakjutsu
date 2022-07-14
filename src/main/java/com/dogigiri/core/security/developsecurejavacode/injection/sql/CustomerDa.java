package com.dogigiri.core.security.developsecurejavacode.injection.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CustomerDa implements AutoCloseable {
    private static final Set<String> VALID_ORDER_BY_COLUMNS = Set.of("customer_id", "first_name", "last_name",
            "birth_date", "phone", "address", "city", "state", "points");
    private final Connection connection;
    private PreparedStatement statement;

    public CustomerDa() {
        connection = new JdbcConnectionProvider().getConnection();
    }

    public List<Customer> selectByCity(String city, String orderBy) throws SQLException {
        if (!VALID_ORDER_BY_COLUMNS.contains(orderBy))
            throw new IllegalArgumentException("invalid order by column");
        Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z\\s-]+[a-zA-Z]$");
        if (!pattern.matcher(city).matches())
            throw new IllegalArgumentException("unsafe data entry");

        String query = "select * from customers where city = ? order by ? ASC";
        statement = connection.prepareStatement(query);
        statement.setString(1, city);
        statement.setString(2, orderBy);
        var resultSet = statement.executeQuery();
        var customers = new ArrayList<Customer>();
        while (resultSet.next()) {
            customers.add(Customer.builder().customerId(resultSet.getInt("customer_id"))
                    .firstname(resultSet.getString("first_name"))
                    .lastname(resultSet.getString("last_name"))
                    .birthDate(resultSet.getDate("birth_date").toLocalDate())
                    .phone(resultSet.getString("phone"))
                    .address(resultSet.getString("address"))
                    .city(resultSet.getString("city"))
                    .state(resultSet.getString("state"))
                    .points(resultSet.getInt("points"))
                    .build());
        }
        return customers;
    }

    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }
}
