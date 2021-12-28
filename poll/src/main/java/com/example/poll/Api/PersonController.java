package com.example.poll.Api;

import com.example.poll.Services.PersonService;
import com.example.poll.model.Person;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("Api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping
    public void addPerson(@NotNull @RequestBody Person person){
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
    @GetMapping(path = "{ID}")
    public Person getPersonById(@PathVariable("ID") UUID ID){
        return personService.getPersonById(ID)
                .orElse(null);
    }
    @DeleteMapping(path = "{ID}")
    public void deletePersonById(@PathVariable("ID") UUID ID){
        personService.deletePerson(ID);
    }
    @PutMapping(path = "{ID}")
    public void updatePerson(@PathVariable("ID")UUID ID,@NotNull @Validated @RequestBody Person personToUpdate){
        personService.updatePerson(ID, personToUpdate);
    }

}
