package rest_with_spring_boot_and_java_erudio.domain.mappers;

import rest_with_spring_boot_and_java_erudio.dto.PersonDTO;
import rest_with_spring_boot_and_java_erudio.data.entities.Person;

public class PersonMapper {

    public Person toObject(PersonDTO dto){
        return new Person((dto.getId() == null || dto.getId().isBlank()) ? null : Long.parseLong(dto.getId()),
                                    dto.getFirstName(),
                                    dto.getLastName(),
                                    dto.getAddress(),
                                    dto.getGender());
    }

    public PersonDTO toDTO(Person person){
        return new PersonDTO(person.getId().toString(),
                                person.getFirstName(),
                                person.getLastName(),
                                person.getAddress(),
                                person.getGender());
    }

    public void putData(Person person, PersonDTO dto){
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());
        person.setAddress(dto.getAddress());
        person.setGender(dto.getGender());
    }
}
