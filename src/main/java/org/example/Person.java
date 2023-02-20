package org.example;

import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private OptionalInt age = OptionalInt.empty();
    private String address = null;

    public Person(String name, String surname, OptionalInt age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (age.isPresent()) {
            return age;
        } else {
            throw new IllegalStateException("Возраст этого человека неизвестен, используйте для проверки метод hasAge, прежде чем вызывать этот метод");
        }
    }

    public String getAddress() {
        if (hasAddress()) {
            return address;
        } else {
            throw new IllegalStateException("Адрес этого человека неизвестен, используйте для проверки метод hasAddress, прежде чем вызывать этот метод");
        }
    }

    public void setAddress(String city) {
        this.address = city;
    }

    public boolean hasAge() {
        return age.isEmpty();
    }

    public boolean hasAddress() {
        return address != null;
    }

    public void happyBirthday() {
        if(this.age.isPresent()) {
            int currentAge = this.age.getAsInt();
            currentAge++;
            this.age = OptionalInt.of(currentAge);
        }
        else{
            System.out.println("Возраст этого человека неизвестен.");
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .surname(this.surname)
                .age(0)
                .address(this.address);
    }

    @Override
    public String toString() {
        int ageToString;
        if(this.age.isPresent()) {
            ageToString = this.age.getAsInt();
        } else{
            ageToString = 0;
        }
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + ageToString +
                ", address='" + address + '\'' +
                '}';
    }
}
