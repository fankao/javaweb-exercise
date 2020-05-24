package www.dao;

import java.util.List;

import org.bson.types.ObjectId;

import www.entity.User;

public interface UserDAO {
	List<User> findAll();

	User findById(ObjectId id);

	User insert(User user);

	User update(User user);

	boolean remove(User user);
}
