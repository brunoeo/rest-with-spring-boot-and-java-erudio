package rest_with_spring_boot_and_java_erudio.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import rest_with_spring_boot_and_java_erudio.dto.PersonDTO;
import rest_with_spring_boot_and_java_erudio.config.exception.ExceptionResponse;
import rest_with_spring_boot_and_java_erudio.domain.services.PersonService;
import rest_with_spring_boot_and_java_erudio.config.util.AppResponse;
import rest_with_spring_boot_and_java_erudio.config.util.DataResponse;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AppResponse<DataResponse> findById(@PathVariable String id) throws ExceptionResponse {
        return AppResponse.success(personService.findById(id), "Search done!");
    }

    @GetMapping()
    public AppResponse<DataResponse> findAll(){
        return AppResponse.success(personService.findAll(), "Search done!");
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public AppResponse<DataResponse> create(@RequestBody PersonDTO personDTO){
        return AppResponse.success(personService.create(personDTO), "Saved successfully");
    }

    @PutMapping("/{id}")
    public AppResponse<DataResponse> update(@PathVariable("id") long id, @RequestBody PersonDTO personDTO) throws ExceptionResponse {
        return AppResponse.success(personService.update(id, personDTO), "Update successfully");
    }

    @DeleteMapping(value = "/{id}")
    public AppResponse<DataResponse>  delete(@PathVariable String id) throws ExceptionResponse {
        personService.delete(id);
        return AppResponse.success("Deletion performed!");
    }
}
