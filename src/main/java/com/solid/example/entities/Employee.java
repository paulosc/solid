package com.solid.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A correct example of adhering to the Open-Closed Principle (OCP) of SOLID.
 *
 * The Employee class extends the Person class, allowing for the extension of behavior specific to employees without modifying the source code of the Person class. This follows the OCP principle, which encourages the creation of specialized classes, such as Employee, that can inherit or compose the common behavior defined in the Person class.
 *
 * The Employee class represents employees and includes properties and behavior specific to employees, such as the 'employeeId' property. By creating a separate Employee class, we keep the Person class open for extension and closed for modification, ensuring a more maintainable and extensible codebase.
 *
 * @see Person The base class providing common properties and behavior for individuals.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee extends Person implements EmployeeInfo {
    private String employeeId;
    private double salary;

    public Employee(String name, Integer age, String employeeId) {
        super(name, age);
        this.employeeId = employeeId;
    }

    /**
     * This class should refrain from overriding the 'introduce' method to ensure compliance with the L (Liskov Substitution Principle) in SOLID.
     */
    @Override
    public void introduce() {
        System.out.println("Hello, I am " + getName() + " and I am " + getAge() + " years old.");
        System.out.println("Employee ID: " + employeeId);
    }

    /**
     * Demonstrating adherence to the Interface Segregation Principle (ISP) in SOLID.
     *
     * In this example, the 'calculateSalary' method is correctly implemented. It adheres to the ISP by providing a specific and meaningful functionality related to calculating the salary. The method returns the 'salary' property, which represents the calculated salary based on the specific logic relevant to the class.
     *
     * The implementation respects the ISP by keeping the interface specific to the 'calculateSalary' functionality without introducing unrelated methods or dependencies.
     */
    @Override
    public double calculateSalary() {
        return salary;
    }
}
