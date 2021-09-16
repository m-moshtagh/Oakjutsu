package com.dogigiri.core.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PersonDAO implements AutoCloseable {
    private Connection connection;
    private PreparedStatement statement;

    private final static Logger logger = LoggerFactory.getLogger(PersonDAO.class);

    public PersonDAO() {

        try {
            connection = MySqlDbConnection.getConnection();
            connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("Connecting to Database is failed");
        }
    }

    public int insert(Person person) throws Exception {
        statement = connection.prepareStatement("INSERT INTO person(first_name, last_name, age) VALUES (?,?,?)");
        statement.setString(1, person.getFirstName());
        statement.setString(2, person.getLastName());
        statement.setInt(3, person.getAge());
        return statement.executeUpdate();
    }

    public int[] insert(List<Person> personList) throws Exception{
        statement = connection.prepareStatement("INSERT INTO person(first_name, last_name, age) VALUES (?,?,?)");

        Iterator<Person> iterator = personList.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setInt(3, person.getAge());
            statement.addBatch();
        }
        int[] result = statement.executeBatch();
        return result;
    }

    public int update(Person person) throws Exception {
        statement = connection.prepareStatement("UPDATE person SET first_name=?, last_name=?, age=? WHERE person_id=?");
        statement.setString(1, person.getFirstName());
        statement.setString(2, person.getLastName());
        statement.setInt(3, person.getAge());
        statement.setLong(4, person.getPersonId());
        return statement.executeUpdate();
    }

    public int delete(long personId) throws Exception {
        statement = connection.prepareStatement("UPDATE person SET deleted_date=? WHERE person_id=?");
        statement.setLong(1, System.currentTimeMillis());
        statement.setLong(2, personId);
        return statement.executeUpdate();
    }

    public List<Person> select() throws Exception {
        statement = connection.prepareStatement("SELECT * FROM person");
        ResultSet resultSet = statement.executeQuery();
        List<Person> personList = new ArrayList<>();
        while (resultSet.next()) {
            Person person = new Person();
            person.setPersonId(resultSet.getLong("person_id"));
            person.setFirstName(resultSet.getString("first_name"));
            person.setLastName(resultSet.getString("last_name"));
            person.setAge(resultSet.getInt("age"));
            personList.add(person);
        }
        return personList;
    }


    public void commit() throws Exception {
        this.connection.commit();
    }

    public void rollBack() throws Exception {
        this.connection.rollback();
    }

    @Override
    public void close() throws Exception {

    }
}
