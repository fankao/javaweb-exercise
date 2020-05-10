package www.bt07.dao;

import java.util.List;

import org.bson.types.ObjectId;

import www.bt07.entity.Student;

public interface StudentDAO {
	List<Student> findAll();

	Student findById(String id);

	Student save(Student stu);

	void deleteById(ObjectId id);
}
