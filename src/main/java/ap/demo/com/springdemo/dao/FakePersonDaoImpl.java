package ap.demo.com.springdemo.dao;

import ap.demo.com.springdemo.dao.PersonDao;
import ap.demo.com.springdemo.model.Person;

import java.util.UUID;
import java.util.List;
import java.util.ArrayList;

public class FakePersonDaoImpl implements PersonDao {

	private static List<Person> DB = new ArrayList<>();
	
	@Override
	public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        
		return 0;
	}

	@Override
	public int insertPerson(Person person) {
		return 0;
	}
}
