package rest_with_spring_boot_and_java_erudio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rest_with_spring_boot_and_java_erudio.mappers.PersonMapper;

@Configuration
public class BeanConfig {

    @Bean
    public PersonMapper getPersonMapper(){
        return new PersonMapper();
    }
}
