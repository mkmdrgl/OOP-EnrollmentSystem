package org.example.Entities;

public class Person {
    private String id;
    private String name;

    public Person() {
        this("Unknown");
    }

    public Person(String id) {
        this(id, "Unknown");
    }

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void getID(String id) {
        this.id = id;
    }

    public void getName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
