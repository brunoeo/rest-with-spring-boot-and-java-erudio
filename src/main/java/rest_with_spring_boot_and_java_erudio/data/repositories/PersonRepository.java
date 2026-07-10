package rest_with_spring_boot_and_java_erudio.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest_with_spring_boot_and_java_erudio.data.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
