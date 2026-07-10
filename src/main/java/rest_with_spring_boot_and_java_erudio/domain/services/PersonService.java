package rest_with_spring_boot_and_java_erudio.domain.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import rest_with_spring_boot_and_java_erudio.dto.PersonDTO;
import rest_with_spring_boot_and_java_erudio.data.entities.Person;
import rest_with_spring_boot_and_java_erudio.config.exception.ExceptionResponse;
import rest_with_spring_boot_and_java_erudio.domain.mappers.PersonMapper;
import rest_with_spring_boot_and_java_erudio.data.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final PersonMapper mapper;
    private final PersonRepository personRepository;
//    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public PersonService(PersonMapper mapper, PersonRepository personRepository) {
        this.mapper = mapper;
        this.personRepository = personRepository;
    }

    public PersonDTO findById(String id) throws ExceptionResponse {
        logger.info("Finding one Person!");
        PersonDTO dto = mapper.toDTO(this.findProfessor(id));
        logger.info("Search done, name: " + dto.getFirstName());
        return dto;
    }

    public List<PersonDTO> findAll(){
        logger.info("Finding All!");
        List<PersonDTO> dtos = new ArrayList<>();
        personRepository.findAll().forEach(
                person -> dtos.add(mapper.toDTO(person)));
        logger.info("Search done, size of list: " + dtos.size());
        return dtos;
    }

    public PersonDTO create(PersonDTO personDTO) {
        logger.info("Creating new person");
        PersonDTO dto = mapper.toDTO(savePerson(mapper.toObject(personDTO)));
        logger.info("Saved successfully, name: " + dto.getFirstName());
        return dto;
    }

    public PersonDTO update(long id, PersonDTO personDTO) throws ExceptionResponse {
        logger.info("Updating a person");
        Person person = this.findProfessor(String.valueOf(id));
        mapper.putData(person, personDTO);
        PersonDTO dto = mapper.toDTO(this.savePerson(person));
        logger.info("Saved successfully, name: " + dto.getFirstName());
        return dto;
    }

    public void delete(String id) throws ExceptionResponse {
        logger.info("Deleting a person");

        personRepository.delete(this.findProfessor(id));

        logger.info("Deletion performed!");
    }

    private Person savePerson(Person person){
        return personRepository.save(person);
    }

    private Person findProfessor(String id) throws ExceptionResponse {
        return personRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ExceptionResponse("Person not found", HttpStatus.NOT_FOUND));
    }

//    private Person mockPerson(int i){
//        return new Person(counter.incrementAndGet(), "FirstName_" + i,
//                "LastName_" + i, "Address_" + i, "Binario");
//    }
}
