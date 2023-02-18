package org.example;

public class Person {
    private final String name;
    private final String surname;
    private int age = -1;
    private String address;

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
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

    public int getAge() {
        if (hasAge()) {
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
        return age != -1;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public void happyBirthday() {
        this.age++;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .surname(this.surname)
                .age(0)
                .address(this.address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
