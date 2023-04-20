package org.todoshis.models;

import org.todoshis.dao.PersonDAO;

import javax.validation.constraints.*;

public class Person {
    private int id;
    @NotEmpty(message = "Name is empty")
    @Size(min = 1, max = 60, message = "Name is more than 60 symbols")
    private String name;
    @Min(value = 1, message = "Call your parents")
    @Max(value = 120, message = "Sorry, you are dead")
    private int age;
    @NotEmpty(message = "Email is empty")
    @Email(message = "This is not email")
    private String email;

    public Person() {

    }

    public Person(String name, int age, String email) {
        this.id = ++PersonDAO.PEOPLE_COUNT;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
