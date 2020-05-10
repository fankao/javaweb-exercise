package www.dao;

import java.util.List;

import org.bson.types.ObjectId;

import www.entity.Person;

public interface PersonDAO {
	List<Person> findAll();

	Person findById(ObjectId id);

	Person save(Person p);

	void deleteById(ObjectId id);
}
