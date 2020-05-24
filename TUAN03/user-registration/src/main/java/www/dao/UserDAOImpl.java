package www.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.bson.types.ObjectId;

import www.entity.User;

public class UserDAOImpl implements UserDAO {
	private EntityManager em;

	public UserDAOImpl() {
		em = DBManage.getInstance().getEntityManager();
	}

	@Override
	public List<User> findAll() {
		List<User> users = em.createQuery("db.users.find({})", User.class).getResultList();
		return users.size() == 0 ? new ArrayList<User>() : users;
	}

	@Override
	public User findById(ObjectId id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id);
	}

	@Override
	public User insert(User user) {
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(user);
			trans.commit();
			return user;
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User update(User user) {
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
			return user;
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean remove(User user) {
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.remove(user);
			trans.commit();
			return true;
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return false;
	}

}
