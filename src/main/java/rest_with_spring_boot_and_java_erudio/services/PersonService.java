package rest_with_spring_boot_and_java_erudio.services;

import org.springframework.stereotype.Service;
import rest_with_spring_boot_and_java_erudio.dto.PersonDTO;
import rest_with_spring_boot_and_java_erudio.entities.Person;
import rest_with_spring_boot_and_java_erudio.mappers.PersonMapper;
import rest_with_spring_boot_and_java_erudio.repositories.PersonRepository;

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

    public PersonDTO findById(String id){
        logger.info("Finding one Person!");

        return mapper.toDTO(this.findProfessor(id));
    }

    public List<PersonDTO> findAll(){
        logger.info("Finding All!");
        List<PersonDTO> dtos = new ArrayList<>();
        personRepository.findAll().forEach(
                person -> dtos.add(mapper.toDTO(person)));
        return dtos;
    }

    public PersonDTO create(PersonDTO personDTO) {
        logger.info("Creating new person");
        return mapper.toDTO(savePerson(mapper.toObject(personDTO)));
    }

    public PersonDTO update(long id, PersonDTO personDTO) {
        logger.info("Updating a person");
        Person person = this.findProfessor(String.valueOf(id));
        mapper.putData(person, personDTO);
        return mapper.toDTO(this.savePerson(person));
    }

    public void delete(String id){
        logger.info("Deleting a person");

        personRepository.delete(this.findProfessor(id));
    }

    private Person savePerson(Person person){
        return personRepository.save(person);
    }

    private Person findProfessor(String id){
        return personRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }

//    private Person mockPerson(int i){
//        return new Person(counter.incrementAndGet(), "FirstName_" + i,
//                "LastName_" + i, "Address_" + i, "Binario");
//    }
}
