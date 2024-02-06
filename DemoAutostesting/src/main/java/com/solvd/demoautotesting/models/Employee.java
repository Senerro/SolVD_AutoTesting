/*
package com.solvd.demoautotesting.models;
import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private int salary;
    private int age;
    private String image;

    public Employee(int id, String name, int salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.image = "";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getImage() {
        return image;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Employee employee = (Employee) object;
        return id == employee.id && salary == employee.salary && age == employee.age && Objects.equals(name, employee.name) && Objects.equals(image, employee.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, age, image);
    }
}*/
