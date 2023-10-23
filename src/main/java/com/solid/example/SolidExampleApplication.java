package com.solid.example;

import com.solid.example.entities.Employee;
import com.solid.example.entities.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolidExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolidExampleApplication.class, args);

		Person personBob = new Employee("Bob", 25, "EMP123");
		Person personAlice = new Person("Alice", 30);
		Employee employee = new Employee("Bob", 25, "EMP123");

		/**
		 * Demonstrating adherence to the Liskov Substitution Principle (LSP).
		 *
		 * In this example, we have a superclass, Person, and a subclass, Employee. Both classes have an 'introduce' method.
		 *
		 * The Liskov Substitution Principle states that objects of a subclass should be able to replace objects of the superclass without affecting the desired behavior of the program. When this principle is adhered to, you can use objects of the subclass (Employee) where objects of the superclass (Person) are expected without altering the expected behavior.
		 *
		 * personAlice and employee are instances of the Person and Employee classes, respectively.
		 *
		 * personAlice.introduce() and employee.introduce() both work as expected, producing output that matches the behavior defined in the superclass (Person). This demonstrates the Liskov Substitution Principle in action, as objects of the subclass (Employee) can be seamlessly used in place of objects of the superclass (Person).
		 *
		 * It's important to note that, to adhere to the LSP, the subclass (Employee) should not modify or extend the behavior of the superclass (Person) in a way that changes the fundamental behavior of methods like 'introduce'. In this example, the 'introduce' method remains consistent in both the superclass and subclass.
		 */
		personAlice.introduce(); // Output: Hello, I am Alice and I am 30 years old.
		employee.introduce(); // Output: Hello, I am Bob and I am 25 years old.

		/**
		 * Incorrect example violating the Liskov Substitution Principle (LSP).
		 *
		 * In this example, we have a superclass, Person, and a subclass, Employee. The Employee class overrides the 'introduce' method to include additional employee-specific information.
		 *
		 * The Liskov Substitution Principle states that objects of a subclass should be able to replace objects of the superclass without affecting the desired behavior of the program. However, in this case, when an Employee object is substituted for a Person object, the behavior is not the same.
		 *
		 * The 'introduce' method in the Employee class introduces additional details specific to employees, such as the employee ID. When we invoke 'person.introduce()' on an Employee object, we get unexpected additional output that is not present in the superclass's behavior.
		 *
		 * This violates the Liskov Substitution Principle, as it demonstrates that substituting an Employee for a Person does not result in consistent or expected behavior. To adhere to the LSP, subclasses should not modify or extend the behavior in a way that changes the fundamental behavior of the superclass.
		 */
		personBob.introduce(); // Output includes unexpected additional details specific to employees.
	}

}
