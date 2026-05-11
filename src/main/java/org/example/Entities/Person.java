<<<<<<< HEAD:src/main/java/org/example/Entities/Person.java
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
=======
package org.example.model;

public abstract class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
>>>>>>> main:src/main/java/org/example/model/Person.java
        this.id = id;
        this.name = name;
    }

<<<<<<< HEAD:src/main/java/org/example/Entities/Person.java
    public String getID() {
=======
    public int getID() {
>>>>>>> main:src/main/java/org/example/model/Person.java
        return id;
    }

    public String getName() {
        return name;
    }

<<<<<<< HEAD:src/main/java/org/example/Entities/Person.java
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
=======
    public void setID(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void mainTask();
>>>>>>> main:src/main/java/org/example/model/Person.java

}
