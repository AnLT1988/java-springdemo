package ap.demo.com.springdemo.dao;

import ap.demo.com.springdemo.model.Person;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.lang.System;

@Repository("fakePersonDao")
public class FakePersonDaoImpl implements PersonDao {

    private static List<Person> DB = new ArrayList<>();
    
    @Override
    public int insertPerson(UUID id, Person person) {
        System.out.println("inserting " + person.getName());
        DB.add(new Person(id, person.getName()));

        return 0;
    }

    @Override
    public List<Person> getAllPerson() {
        System.out.println(DB);
        return DB;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return DB.stream()
            .filter(person -> person.getId().equals(id))
            .findFirst();
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> person = getPersonById(id);
        if (person.isEmpty()) {
            return 0;
        }

        DB.remove(person.get());
        return 1;
    }


    @Override
    public int updatePerson(UUID id, Person person) {
        System.out.println("Updating person");
        System.out.println("ID: " + id); 
        System.out.println("New person name: " + person.getName());
        return getPersonById(id)
            .map(p -> {
                    int personTobeUpdateIdx = DB.indexOf(p);
                    if (personTobeUpdateIdx >= 0) {
                        Person newPerson = new Person(id, person.getName());
                        DB.set(personTobeUpdateIdx, newPerson);
                        return 1;
                    }
                    return 0;
                }
            )
            .orElse(0);
    }
}
