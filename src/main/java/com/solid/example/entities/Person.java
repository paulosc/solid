package com.solid.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Incorrect example of adding an employee-specific property directly to the Person class.
 *
 * This approach violates the Open-Closed Principle (OCP) of the SOLID principles. The OCP suggests that you should extend the behavior of an entity without modifying its source code. Instead of adding employee-specific properties directly to the Person class, it is recommended to create a separate Employee class that extends or composes the Person class to avoid modifying the Person class for specific employee-related details.
 *
 * @see Employee A correct approach that follows the OCP by creating a separate Employee class.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person implements PersonInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;
    private String address;
//    private String employeeId; // Adding an employee-specific property directly to the Person class
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * O — Open-Closed Principle (Princípio Aberto-Fechado)
     * Correct example of adhering to the Single Responsibility Principle (S.O.L.I.D: S) for printing person details.
     *
     * This method prints the name and age of a person.
     *
     * @see Person#printDetailsWrong() An incorrect example that prints additional details.
     */
    public void printDetailsCorrect() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }


    /**
     * O — Open-Closed Principle (Princípio Aberto-Fechado)
     * Incorrect example of not adhering to the Single Responsibility Principle (S.O.L.I.D: S) for printing person details.
     *
     * This method prints the name, age, and address of a person, violating the SRP.
     *
     * The Single Responsibility Principle suggests that a method or class should have one and only one reason to change. In this case, adding the responsibility of printing the address to this method increases its reasons for change. If there are future changes in how address details are printed or formatted, it will affect this method, potentially leading to unintended side effects.
     *
     * @see Person#printDetailsCorrect() A correct example that follows the SRP by printing only the name and age.
     */
    public void printDetailsWrong() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }

    public void introduce() {
        System.out.println("Hello, I am " + name + " and I am " + age + " years old.");
    }

    @Override
    public String getFullName() {
        return name;
    }

    /**
     * Incorrect example violating the Interface Segregation Principle (ISP) in SOLID.
     *
     * In this example, the 'calculateSalary' method is incorrectly implemented. It prints an "Error not implemented" message and returns a constant value of 0. This approach contradicts the ISP, which states that clients should not be forced to depend on methods they do not use.
     *
     * By providing an error message and an unrelated constant value, this implementation introduces unnecessary and irrelevant behavior. It forces clients to depend on this method, even if they do not require it, which violates the ISP. This can lead to unnecessary coupling between clients and interfaces, making the code less maintainable and more error-prone.
     *
     * To follow the ISP, interfaces should be specific and provide only the methods relevant to the clients that implement them. In this case, the 'calculateSalary' method should provide meaningful functionality related to salary calculation.
     */
    @Override
    public double calculateSalary() {
        System.out.println("Error not implemented");
        return 0;
    }
}
