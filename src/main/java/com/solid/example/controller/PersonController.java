package com.solid.example.controller;

import com.solid.example.dto.PersonRequest;
import com.solid.example.entities.Person;
import com.solid.example.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping("/create")
    public ResponseEntity<Person> createPerson(@RequestBody @Validated PersonRequest personRequest) {
        return new ResponseEntity<>(personService.createPersonCorrect(personRequest), HttpStatus.OK);
    }

}
