package rest_with_spring_boot_and_java_erudio.services;

import org.springframework.stereotype.Service;
import rest_with_spring_boot_and_java_erudio.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id){
        logger.info("Finding one Person!");

        return new Person(counter.incrementAndGet(), "Bruno", "Elias",
                "Mogi das Cruzes", "Male");
    }

    public List<Person> findAll(){
        List<Person> persons = new ArrayList<>();
        for(int i=0; i<8; i++) persons.add(mockPerson(i));
        return persons;
    }

    private Person mockPerson(int i){
        return new Person(counter.incrementAndGet(), "FirstName_" + i,
                "LastName_" + i, "Address_" + i, "Binario");
    }

    public Person create(Person person) {
        logger.info("Creating new person");
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating a person");
        return person;
    }

    public void delete(String id){
        logger.info("Deleting a person");
    }
}
