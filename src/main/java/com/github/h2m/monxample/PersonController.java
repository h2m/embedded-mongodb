package com.github.h2m.monxample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    PersonRepository repository;

    @GetMapping()
    public Iterable<Person> getPersons() {
        return repository.findAll();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Person> getPerson(@PathVariable("name") String name) {
        Person one = repository.findOne(name);

        return one != null ? ResponseEntity.ok(one) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{name}")
    public Person addPerson(@PathVariable("name") String name) {
        return repository.save(new Person(name, name));
    }
}
