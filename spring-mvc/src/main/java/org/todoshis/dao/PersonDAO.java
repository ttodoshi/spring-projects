package org.todoshis.dao;

import org.springframework.stereotype.Component;
import org.todoshis.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    public static int PEOPLE_COUNT = 0;
    private final List<Person> people;

    public PersonDAO() {
        people = new ArrayList<>();
        people.add(new Person("Anton", 24, "antonio2004@mail.com"));
        people.add(new Person("Vlad", 14, "whatisl0ve@mail.com"));
        people.add(new Person("Sanya", 49, "sashkonotforyou@mail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
