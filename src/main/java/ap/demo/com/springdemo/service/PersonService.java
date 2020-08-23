package ap.demo.com.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

import ap.demo.com.springdemo.model.Person;
import ap.demo.com.springdemo.dao.PersonDao;

@Service
public class PersonService {
    
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakePersonDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int insertPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPerson() {
        return personDao.getAllPerson();
    }

    public Optional<Person> getPersonById(UUID id) {
        return personDao.getPersonById(id);
    }

    public int deletePerson(UUID id) {
        return personDao.deletePerson(id);
    }

    public int updatePerson(UUID id, Person person) {
        return personDao.updatePerson(id, person);
    }
}
