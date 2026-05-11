package org.example.Entities;

public abstract class Person {
    private String personID;
    private String personName;

    public Person() {
        this("Unknown");
    }

    public Person(String id) {
        this(id, "Unknown");
    }

    public Person(String personID, String personName) {
        this.personID = personID;
        this.personName = personName;
    }

    public String getID() {
        return personID;
    }

    public String getName() {
        return personName;
    }

    public void getID(String id) {
        this.personID = personID;
    }

    public void getName(String name) {
        this.personName = personID;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + personID + '\'' +
                ", name='" + personName + '\'' +
                '}';
    }

}