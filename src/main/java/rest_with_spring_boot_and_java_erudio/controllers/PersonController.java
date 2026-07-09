package rest_with_spring_boot_and_java_erudio.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rest_with_spring_boot_and_java_erudio.dto.PersonDTO;
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
    public PersonDTO findById(@PathVariable String id){
        return personService.findById(id);
    }

    @GetMapping()
    public List<PersonDTO> findAll(){
        return personService.findAll();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO create(@RequestBody PersonDTO personDTO){
        return personService.create(personDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO update(@RequestBody PersonDTO personDTO){
        return personService.update(personDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id){
        personService.delete(id);
    }
}
