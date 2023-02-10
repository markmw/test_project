package kz.baiturinov.callboard.services;

import kz.baiturinov.callboard.models.Person;
import kz.baiturinov.callboard.repository.PersonRepository;
import kz.baiturinov.callboard.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findByUsername(email);
        if (person.isEmpty()) {
            throw new UsernameNotFoundException("Email не найден");
        }
        return new PersonDetails(person.get());
    }

}
