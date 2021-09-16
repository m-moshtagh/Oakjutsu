package com.dogigiri.core.jdbc;

import java.util.List;

public class PersonService {
    private static final PersonService personService = new PersonService();

    private PersonService() {
    }

    public static PersonService getInstance() {
        return personService;
    }

    public void save(Person person) {
        try (PersonDAO personDAO = new PersonDAO()) {
            personDAO.insert(person);
            personDAO.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void edit(Person person) {
        try (PersonDAO personDAO = new PersonDAO()){
            personDAO.update(person);
            personDAO.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void remove(long personId) {
        try (PersonDAO personDAO = new PersonDAO()){
            personDAO.delete(personId);
            personDAO.commit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public List<Person> findAll() {
        try (PersonDAO personDAO = new PersonDAO()) {
            return personDAO.select();
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public int[] saveAll(List<Person> personList) {
        try (PersonDAO personDAO = new PersonDAO()) {
            int[] result =  personDAO.insert(personList);
            personDAO.commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
