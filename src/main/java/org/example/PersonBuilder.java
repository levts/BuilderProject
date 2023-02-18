package org.example;

public class PersonBuilder {
    private String name;
    private String surname;
    private int age;
    private String address;

    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder surname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder age(int age) {
        if ((age < 0) || (age > 130)) {
            throw new IllegalArgumentException("Вы указали некорректный возраст :(");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder address(String city) {
        this.address = city;
        return this;
    }

    public Person build() {
        if ((name == null) || (surname == null)) {
            throw new IllegalStateException("Вы забыли указать имя или фамилию :(");
        }
        return new Person(name, surname, age, address);
    }
}
