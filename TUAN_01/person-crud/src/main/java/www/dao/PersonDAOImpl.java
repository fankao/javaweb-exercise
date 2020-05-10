package www.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.bson.types.ObjectId;

import www.entity.Person;

public class PersonDAOImpl implements PersonDAO {
	private EntityManager em;

	public PersonDAOImpl() {
		em = PersonEntityManger.getInstance().getEntityManager();
	}

	@SuppressWarnings("unchecked")
	public List<Person> findAll() {
		List<Person> persons = em.createNativeQuery("{}", Person.class).getResultList();
		return persons.size() == 0 ? new ArrayList<Person>() : persons;
	}

	public Person findById(ObjectId id) {

		return em.find(Person.class, id);
	}

	public Person save(Person p) {
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			if (p.getId() != null && findById(p.getId()) != null) {
				em.merge(p);
			} else {
				em.persist(p);
			}
			trans.commit();
			return p;
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return null;
	}

	public void deleteById(ObjectId id) {
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.createNativeQuery("db.persons.deleteOne({ '_id' : ObjectId('" + id + "')})").executeUpdate();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
	}

}
