package www.bt07.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.bson.types.ObjectId;

import www.bt07.entity.Student;

public class StudentDAOImpl implements StudentDAO {
	private EntityManager em;

	public StudentDAOImpl() {
		em = StudentEntityManager.getInstance().getEnityManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findAll() {
		List<Student> students = em.createNativeQuery("{}", Student.class).getResultList();
		return students.size() == 0 ? new ArrayList<Student>() : students;
	}

	@Override
	public Student findById(String id) {
		// TODO Auto-generated method stub
		return em.find(Student.class, id);
	}

	@Override
	public Student save(Student stu) {
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			if (stu.getMaSV() != null) {
				em.merge(stu);
			} else {
				em.persist(stu);
			}
			trans.commit();
			return stu;
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteById(ObjectId id) {
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.createNativeQuery("db.students.deleteOne({'_id':'" + id + "')").executeUpdate();
			trans.commit();
		} catch (Exception e) {
			trans.rollback();
			e.printStackTrace();
		}
	}

}
