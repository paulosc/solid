package com.solid.example.service;

import com.solid.example.dto.PersonRequest;
import com.solid.example.entities.Person;
import com.solid.example.mapper.PersonMapper;
import com.solid.example.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Valid example following the Dependency Inversion Principle (DIP) in Spring Boot.
 *
 * In this example, the DIP is adhered to as the high-level class, 'PersonService', depends on abstractions
 * (the 'PersonRepository' interface) rather than concrete implementations. This allows for flexibility
 * and decouples the service class from a specific repository implementation.
 *
 * The 'PersonRepository' is defined as an interface, and 'PersonService' depends on this interface for data access.
 * The use of dependency injection, as seen in the constructor, enables the service class to accept any implementation
 * that adheres to the 'PersonRepository' interface.
 *
 * This adherence to the DIP promotes flexibility, ease of testing, and maintainability, as it decouples the high-level class
 * from specific implementations and promotes coding to interfaces rather than implementations.
 */
@RequiredArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    /**
     * Portugues:
     * Exemplo correto do uso de S.O.L.I.D: S — Single Responsibility Principle (Princípio da responsabilidade única)
     * Aqui, o método createPersonCorrect da classe PersonService tem uma única responsabilidade: gerenciar a criação de uma Person.
     *
     * English:
     * Correct example of using S.O.L.I.D: S - Single Responsibility Principle
     * Here, the createPersonCorrect method in the PersonService class has a single responsibility: managing the creation of a Person.
     *
     * @param personRequest The request containing the information for the new Person.
     * @return The created Person.
     */
    public Person createPersonCorrect(PersonRequest personRequest) {
        Person person = PersonMapper.INSTANCE.toPerson(personRequest);
        return personRepository.save(person);
    }

    /**
     * Portugues:
     * Exemplo errado do uso de S.O.L.I.D: S — Single Responsiblity Principle (Princípio da responsabilidade única)
     * Aqui, o método createPersonWrong da classe PersonController está lidando com solicitações HTTP
     * e a criação de uma Person.
     *
     * English:
     * Incorrect example of using S.O.L.I.D: S - Single Responsibility Principle
     * Here, the createPersonWrong method in the PersonController class is handling HTTP requests
     * and the creation of a Person.
     *
     * @param personRequest The request containing the information for the new Person.
     * @return The created Person.
     */
    public Person createPersonWrong(@RequestBody PersonRequest personRequest) {
        Person person = PersonMapper.INSTANCE.toPerson(personRequest);
        return personRepository.save(person);
    }

    /**
     * @Repository
     * public class JpaPersonRepository {
     *     // Implementação de findAll()
     * }
     *
     *  public List<Person> getAllPersons() {
     *         return jpaPersonRepository.findAll();
     *  }
     *
     * Invalid example violating the Dependency Inversion Principle (DIP) in Spring Boot.
     *
     * In this example, the DIP is violated as the high-level class, 'PersonService', directly depends on a concrete implementation
     * ('JpaPersonRepository') instead of depending on abstractions (interfaces). This results in a tight coupling between the
     * high-level class and a specific repository implementation, making the code less flexible and less maintainable.
     *
     * 'PersonService' relies on 'JpaPersonRepository' for data access, which creates a direct and rigid dependency on the concrete
     * implementation, hindering the ability to swap out or extend repository implementations without modifying the service class.
     *
     * This violation of the DIP can lead to difficulties in testing and maintaining the code and should be avoided by depending
     * on abstractions rather than concrete implementations.
     */
}
