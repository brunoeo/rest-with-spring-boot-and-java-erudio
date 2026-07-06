package rest_with_spring_boot_and_java_erudio.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rest_with_spring_boot_and_java_erudio.model.Person;
import rest_with_spring_boot_and_java_erudio.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable String id){
        return personService.findById(id);
    }

    @GetMapping()
    public List<Person> findAll(){
        return personService.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person){
        return personService.create(person);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person){
        return personService.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id){
        personService.delete(id);
    }
}
