package ap.demo.com.springdemo.dao;

import ap.demo.com.springdemo.model.Person;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

public interface PersonDao {
	int insertPerson(UUID id, Person person);

	default int insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}

        List<Person> getAllPerson();
        Optional<Person> getPersonById(UUID id);
        int deletePerson(UUID id);
        int updatePerson(UUID id, Person person);
}
