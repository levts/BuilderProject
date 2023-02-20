package org.example;

import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age = OptionalInt.empty();
    private String address = null;

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
        this.age = OptionalInt.of(age);
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
